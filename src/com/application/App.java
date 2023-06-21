package com.application;

import java.util.ArrayList;
import java.util.List;

public class App {
	private Integer appId;

	private String appName;
	private List<AppVersion> versions;

	public App(Integer appId, String appName) {
		this.appId = appId;
		this.appName = appName;
		this.versions = new ArrayList<>();
	}

	public void addVersion(AppVersion version) {
		versions.add(version);
	}

	public List<AppVersion> getVersions() {
		return versions;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

}
