package com.variaS.dao;

import java.util.List;

import com.variaS.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
    User getUser(int theId);

	void deleteUser(int theId);

	List<User> searchUser(String theSearchName);
	
	List<User> getUsers();

	void updateUser(User user);
}
