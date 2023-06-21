package com.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rolloutstrategy.RolloutStrategy;
import com.utilities.ApplicationManagementSystemHelper;

public class AppVersionManagementSystem {
	private List<App> apps;
	private ApplicationManagementSystemHelper helper = ApplicationManagementSystemHelper.getInstance();

	public AppVersionManagementSystem() {
		this.apps = new ArrayList<>();
	}

	public void addApp(App app) {
		apps.add(app);
	}

	public void uploadNewVersion(App app, Integer versionNumber, String releaseDate, Integer minSupportedOS) {
		AppVersion appVersion = new AppVersion(versionNumber, releaseDate, minSupportedOS);
		app.addVersion(appVersion);
		System.out.println("New Version Uploaded : " + appVersion);
	}

	public void installApp(App app, int currentOSVersion) {
		AppVersion latestVersion = helper.getLatestVersion(app);
		if (latestVersion != null) {
			if (isAppVersionSupported(latestVersion, currentOSVersion)) {
				byte[] appFileContent = helper.getAppFileContent(app, latestVersion);
				if (appFileContent != null) {
					// Perform the app installation using the appFileContent
					System.out.println("App installed successfully.");
				} else {
					System.out.println("Error: Failed to retrieve app file content.");
				}
			} else {
				System.out.println("Error: Current OS version is not supported by the latest app version.");
			}
		}
	}

	public byte[] createUpdatePatch(int appId, Integer fromVersionNumber, Integer toVersionNumber) {
		App app = apps.get(appId);
		if (Optional.of(app).isPresent()) {
			AppVersion sourceVersion = null;
			AppVersion targetVersion = null;
			// Find the source and target versions
			for (AppVersion version : app.getVersions()) {
				if (version.getVersionNumber() == fromVersionNumber) {
					sourceVersion = version;
				}
				if (version.getVersionNumber() == toVersionNumber) {
					targetVersion = version;
				}
			}
			if (sourceVersion != null && targetVersion != null) {
				// Create the update patch from source to target version
				byte[] diffPatch = helper.createDiffPatch(sourceVersion, targetVersion);
				if (diffPatch != null) {
					return diffPatch;
				}
			}
		}
		return null;
	}

	public boolean isAppVersionSupported(AppVersion appversion, Integer currentOSVersion) {
		Integer minOSVersion = appversion.getMinSupportedOS();
		// Compare the minimum supported OS version with the current OS version
		// Return true if the current OS version is equal to or greater than the minimum
		// supported version
		return currentOSVersion >= minOSVersion;
	}

	public void checkForUpdates(App app, Integer currentAppVersion) throws InterruptedException {
		AppVersion latestVersion = helper.getLatestVersion(app);
		if (latestVersion.getVersionNumber() == currentAppVersion) {
			System.out.println("Latest Version is alreday installed");
		} else {
			System.out.println("Latest Version is not alreday installed, please update");
			helper.updateApp();
		}
	}

	public void releaseVersion(App app, RolloutStrategy rolloutStrategy) {
		rolloutStrategy.rollout(app.getVersions().get(app.getVersions().size() - 1));
	}
}
