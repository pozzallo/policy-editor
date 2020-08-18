package com.variaS.dao;

import java.util.List;

import com.variaS.entity.Department;

public interface DepartmentDao {

	public List<Department> getDepartments();
	
	public Department getDepartment(String fullName);

}
