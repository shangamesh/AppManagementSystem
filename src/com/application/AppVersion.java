package com.application;

public class AppVersion {

	private Integer versionNumber;
	private String releaseDate;
	private Integer minSupportedOS;

	public AppVersion(Integer versionNumber, String releaseDate, Integer minSupportedOS) {
		this.versionNumber = versionNumber;
		this.releaseDate = releaseDate;
		this.minSupportedOS = minSupportedOS;
	}

	public Integer getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getMinSupportedOS() {
		return minSupportedOS;
	}

	public void setMinSupportedOS(Integer minSupportedOS) {
		this.minSupportedOS = minSupportedOS;
	}

	@Override
	public String toString() {
		return "AppVersion [versionNumber=" + versionNumber + ", releaseDate=" + releaseDate + ", minSupportedOS="
				+ minSupportedOS + "]";
	}

}
