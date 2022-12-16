package mititelu.laura.udemy.thrillio.entities;

import mititelu.laura.udemy.thrillio.partner.Shareable;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Weblink extends Bookmark implements Shareable {

	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "Weblink{" +
				"id=" + getId() +
				", title='" + getTitle() + '\'' +
				", profile='" + getProfile() + '\'' +
				", url='" + url + '\'' +
				", host='" + host + '\'' +
				'}';
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if(url.toLowerCase().contains("porn") || getTitle().toLowerCase().contains("porn") || host.toLowerCase().contains("adult")){
			return false;
		}
		return true;
	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>WebLink</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<url>").append(url).append("</url>");
		builder.append("<host>").append(host).append("</host>");
		builder.append("</item>");
		return builder.toString();
	}
}
