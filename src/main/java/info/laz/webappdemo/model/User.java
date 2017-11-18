package info.laz.webappdemo.model;


import javax.persistence.*;

@Entity
public class User {
	@Id
    private Integer id;
	
	@Column
    private String name;
	
	@Column
	private String activeFeatures;
	
	@Column
	private String inactiveFeatures;

    public User() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActiveFeatures() {
		return activeFeatures;
	}

	public void setActiveFeatures(String activeFeatures) {
		this.activeFeatures = activeFeatures;
	}

	public String getInactiveFeatures() {
		return inactiveFeatures;
	}

	public void setInactiveFeatures(String inactiveFeatures) {
		this.inactiveFeatures = inactiveFeatures;
	}
}
