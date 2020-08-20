package com.variaS.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "policies")
public class Policy {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 512)
	private String title;
	
    @Column(length = 1024)
	private String description;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "policy", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch (FetchMode.SELECT)
    private List<Profile> profiles;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "policy", cascade = CascadeType.ALL)
    @Fetch (FetchMode.SELECT)
    private List<Rule> rules;
	
    @Column(name = "version")
	private long version;

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

	public Policy(Long id, String description, long version) {
		super();
		this.id = id;
		this.description = description;
		this.version = version;
	}

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
