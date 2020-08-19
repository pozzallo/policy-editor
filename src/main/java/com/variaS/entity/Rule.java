package com.variaS.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "rules")
public class Rule {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 512)
	private String title;
	
    @Column(length = 1024)
	private String description;
	
    @Column(length = 1024)
	private String checkedText;
	
    @Column(length = 1024)
	private String fixText;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "POLICY_ID")
	private Policy policy;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="profiles_rules",
			joinColumns = @JoinColumn(name = "RULE_ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "PROF_ID", referencedColumnName = "ID"
			))
	private List<Profile> profiles;

	
	public Rule() {
	}
	
	public Rule(String title, String description, String checkedText, String fixText,
			List<Profile> profiles, Policy policy) {
		super();
		this.title = title;
		this.description = description;
		this.checkedText = checkedText;
		this.fixText = fixText;
		this.profiles = profiles;
		this.policy = policy;
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

	public String getCheckedText() {
		return checkedText;
	}

	public void setCheckedText(String checkedText) {
		this.checkedText = checkedText;
	}

	public String getFixText() {
		return fixText;
	}

	public void setFixText(String fixText) {
		this.fixText = fixText;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	
	
	
	

}
