package com.variaS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "profiles")
public class Profile {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 512)
	private String title;
	
    @Column(length = 1024)
	private String description;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "POLICY_ID")
	private Policy policy;
    
    
    public Profile() {
	}

	public Profile(String title, String description, Policy policy) {
		super();
		this.title = title;
		this.description = description;
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

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
    
    

}
