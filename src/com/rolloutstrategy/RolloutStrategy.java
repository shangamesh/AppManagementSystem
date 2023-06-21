package com.rolloutstrategy;

import com.application.AppVersion;

// Abstraction
public interface RolloutStrategy {
	void rollout(AppVersion version);
}
