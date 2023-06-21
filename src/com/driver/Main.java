package com.driver;

import java.util.Arrays;

import com.application.App;
import com.application.AppVersionManagementSystem;
import com.rolloutstrategy.RolloutStrategy;
import com.rolloutstrategy.implementation.BetaRolloutStrategy;
import com.rolloutstrategy.implementation.PercentageRolloutStrategy;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		// Create an instance of AppVersionManagementSystem
		AppVersionManagementSystem appVersionManagementSystem = new AppVersionManagementSystem();

		// Create Beta Applications
		App phonePe = new App(0, "PhonePe");

		// Upload new versions
		appVersionManagementSystem.addApp(phonePe);
		appVersionManagementSystem.uploadNewVersion(phonePe, 1, "2022-01-01", 10);
		appVersionManagementSystem.uploadNewVersion(phonePe, 2, "2022-02-01", 10);
		appVersionManagementSystem.uploadNewVersion(phonePe, 3, "2022-02-01", 10);

		// Install Application
		// Case 1 : Supported OS version
		appVersionManagementSystem.installApp(phonePe, 10);
		// Case 2 : Unsupported OS version
		appVersionManagementSystem.installApp(phonePe, 9);

		// Release a version
		// Case 1 : Beta Rollout Strategy
		RolloutStrategy betaRollout = new BetaRolloutStrategy(Arrays.asList("Device1", "Device2"));
		appVersionManagementSystem.releaseVersion(phonePe, betaRollout);
		// Case 1 : Percentage Rollout Strategy
		RolloutStrategy percentageRolloutStrategy = new PercentageRolloutStrategy(50);
		appVersionManagementSystem.releaseVersion(phonePe, percentageRolloutStrategy);

		// Create Patch
		appVersionManagementSystem.createUpdatePatch(phonePe.getAppId(), 2, 3);

		// Check for Updates
		// Case 1 : Using Older Version
		appVersionManagementSystem.checkForUpdates(phonePe, 1);
		// Case 1 : Using Latest Version
		appVersionManagementSystem.checkForUpdates(phonePe, 3);

	}
}
