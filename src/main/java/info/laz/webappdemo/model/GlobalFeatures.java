package info.laz.webappdemo.model;


import javax.persistence.*;

@Entity
public class GlobalFeatures {
	@Id
    private Integer id;
	
	@Column
    private String appVersion;
	
	@Column
	private String activeFeatures;
	
	public GlobalFeatures() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getActiveFeatures() {
		return activeFeatures;
	}

	public void setActiveFeatures(String activeFeatures) {
		this.activeFeatures = activeFeatures;
	}
}
