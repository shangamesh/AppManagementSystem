package com.rolloutstrategy.implementation;

import java.util.List;

import com.application.AppVersion;
import com.rolloutstrategy.RolloutStrategy;

public class BetaRolloutStrategy implements RolloutStrategy {
	private List<String> targetDevices;

	public BetaRolloutStrategy(List<String> targetDevices) {
		this.targetDevices = targetDevices;
	}

	@Override
	public void rollout(AppVersion version) {
		System.out.println("Performing beta rollout of version " + version.getVersionNumber() + " on target devices: "
				+ targetDevices);
		// Perform the actual rollout logic
	}
}
