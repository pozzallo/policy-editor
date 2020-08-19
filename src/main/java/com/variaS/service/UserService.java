package com.variaS.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.variaS.entity.User;

public interface UserService extends UserDetailsService {

    
	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

	public List<User> searchUser(String theSearchName);

	public User findByUserName(String userName);

	void updateUser(User user);

	public void changeUserPassword(String password, User currentUser);

}
