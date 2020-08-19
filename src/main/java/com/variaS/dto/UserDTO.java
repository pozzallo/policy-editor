package com.variaS.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.variaS.validation.FieldMatch;
import com.variaS.validation.ValidEmail;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class UserDTO {
	
	private int id;
	
	@NotNull(message="is requered")
	private String userName;
	
	@NotNull(message="is requered")
	private String firstName;
	
	@NotNull(message="is requered")
	private String lastName;
	
	@ValidEmail
	private String email;
	
	@NotNull(message="is requered")
	private String department;
	
	private String description;
	
	@NotNull(message="is requered")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String matchingPassword;

	public UserDTO() {
	
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setUserName(String username) {
		this.userName = username;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + userName + ", fullname= " + firstName + "" + lastName + ", email=" + email
				+ ", department=" + department + ", description=" + description + "]";
	}

	public String getUserName() {
	return userName;
	}
	

}
