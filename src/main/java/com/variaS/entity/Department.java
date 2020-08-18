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


@Entity
@Table(name="departments")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="short_name")
	private String shortName;
	
	@Column(name="full_name")
	private String fullName;
	
	@OneToMany(fetch = FetchType.LAZY,
			mappedBy = "department", //field in class User
			cascade =
		{CascadeType.DETACH,CascadeType.MERGE, 
		CascadeType.PERSIST,CascadeType.REFRESH})
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



	public Department() {
	}

	public Department(String shortName, String fullName) {
		this.shortName = shortName;
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fulName) {
		this.fullName = fulName;
	}
	
	@Override
	public String toString() {
		return  fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
