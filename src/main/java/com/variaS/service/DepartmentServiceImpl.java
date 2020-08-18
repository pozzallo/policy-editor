package com.variaS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.variaS.dao.DepartmentDao;
import com.variaS.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	// need to inject customer dao
	@Autowired
	private DepartmentDao departmentDAO;

	@Override
	@Transactional
	public List<Department> getDepartments() {
		
		return departmentDAO.getDepartments() ;
	}

	@Override
	@Transactional
	public Department getDepartment(String departmentFullName) {
	
		return departmentDAO.getDepartment(departmentFullName);
	}
	

}





