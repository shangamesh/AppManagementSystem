package com.utilities;

import java.util.List;
import java.util.Optional;

import com.application.App;
import com.application.AppVersion;

public class ApplicationManagementSystemHelper {

	private static ApplicationManagementSystemHelper applicationManagementSystemHelper = null;

	// Singleton Thread Safe Instance
	public static ApplicationManagementSystemHelper getInstance() {
		synchronized (ApplicationManagementSystemHelper.class) {
			if (applicationManagementSystemHelper == null)
				return new ApplicationManagementSystemHelper();
			else
				return applicationManagementSystemHelper;
		}
	}

	public byte[] createDiffPatch(AppVersion sourceVersion, AppVersion targetVersion) {

		// Logic to create a diff patch from the source version to the target version
		// Return the patch as a byte array (implementation not shown)
		System.out.println("Diff created from sourceVersion " + sourceVersion + " to : " + targetVersion);
		return new byte[0];
	}

	public AppVersion getLatestVersion(App app) {
		List<AppVersion> appVersions = app.getVersions();
		if (Optional.of(appVersions).isPresent()) {
			return appVersions.get(appVersions.size() - 1);
		}
		return null;
	}

	public byte[] getAppFileContent(App app, AppVersion version) {
		// Retrieve the app file content based on the app and version (implementation
		// not shown)
		return new byte[0];
	}

	public void updateApp() throws InterruptedException {
		System.out.println("Updating to latest Version");
		Thread.sleep(1000);
		System.out.println("Update Done");
	}
}
