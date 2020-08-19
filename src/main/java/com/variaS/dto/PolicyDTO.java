package com.variaS.dto;

import java.util.List;

import com.variaS.entity.Profile;
import com.variaS.entity.Rule;

public class PolicyDTO {

    private Long id;
	private String title;
	private String description;
    private List<Profile> profiles;
    private List<Rule> rules;
	private long version;

	


	public PolicyDTO(Long id, String description, long version) {
		super();
		this.id = id;
		this.description = description;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	

}
