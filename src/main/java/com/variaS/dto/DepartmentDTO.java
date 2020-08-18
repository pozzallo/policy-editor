package com.variaS.dto;

import java.util.List;



import com.variaS.entity.User;

public class DepartmentDTO {
	
	private int id;
	
	private String shortName;
	
	private String fullName;
	
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



	public DepartmentDTO() {
	}

	public DepartmentDTO(String shortName, String fullName) {
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
		return  shortName + "( " + fullName + " )";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
