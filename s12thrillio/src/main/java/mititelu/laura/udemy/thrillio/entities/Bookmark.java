package mititelu.laura.udemy.thrillio.entities;

import mititelu.laura.udemy.thrillio.constants.KidFriendlyStatus;

public abstract class Bookmark {

	private long id;
	private String title;
	private String profile;

	private String kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;

	private User kidFriendlyMarkedBy;

	private User sharedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Bookmark{" +
				"id=" + id +
				", title='" + title + '\'' +
				", profile='" + profile + '\'' +
				'}';
	}

	// public abstract void generateProfileUrl();
	public abstract boolean isKidFriendlyEligible();

	public String getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}

	public void setKidFriendlyStatus(String kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
	}

	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}

	public User getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}
}
