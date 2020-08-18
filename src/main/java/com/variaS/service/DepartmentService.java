package com.variaS.service;
import java.util.List;

import  com.variaS.entity.Department;

public interface DepartmentService {
	
	public List<Department> getDepartments();

	public Department getDepartment(String department);

}
