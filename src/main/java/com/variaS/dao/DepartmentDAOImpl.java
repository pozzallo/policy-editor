package com.variaS.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.variaS.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Department> getDepartments() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query 
		Query<Department> theQuery = 
				currentSession.createQuery("from Department",
											Department.class);
		
		// execute query and get result list
		List<Department> departments = theQuery.getResultList();
				
		// return the results		
		return departments;
	}

	@Override
	public Department getDepartment(String fullName) {
		System.out.println("Department full name: " + fullName);
		Session currentSession = sessionFactory.getCurrentSession();
				Query<Department> theQuery = 
						currentSession.createQuery("from Department d where d.fullName=:fullName",
													Department.class);
				theQuery.setParameter("fullName", fullName);
				// execute query and get result list
				Department department = theQuery.getSingleResult();
				System.out.println(department);
						
				// return the results		
				return department;
	}



}
