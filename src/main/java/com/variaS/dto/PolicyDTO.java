package com.variaS.dto;

import java.util.List;

import com.variaS.entity.Profile;
import com.variaS.entity.Rule;

public class PolicyDTO {

    private Long id;
	private String description;
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

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	

}
