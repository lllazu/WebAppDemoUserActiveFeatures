package info.laz.webappdemo.data;

import java.util.List;

public class FeaturesResponse {
	private List<String> active_features;
	private String user;
	private String version;

	public FeaturesResponse() {
	}

	public List<String> getActive_features() {
		return active_features;
	}

	public void setActive_features(List<String> active_features) {
		this.active_features = active_features;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
