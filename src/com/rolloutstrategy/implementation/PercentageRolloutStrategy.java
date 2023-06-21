package com.rolloutstrategy.implementation;

import com.application.AppVersion;
import com.rolloutstrategy.RolloutStrategy;

public class PercentageRolloutStrategy implements RolloutStrategy {
	private int percentage;

	public PercentageRolloutStrategy(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public void rollout(AppVersion version) {
		System.out.println("Performing percentage rollout of version " + version.getVersionNumber() + " on "
				+ percentage + "% of devices");
		// Perform the actual rollout logic
	}
}
