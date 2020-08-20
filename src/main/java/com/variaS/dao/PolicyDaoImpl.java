package com.variaS.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.variaS.entity.Policy;

@Repository
public class PolicyDaoImpl implements PolicyDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Policy> getPolicies() {
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query 
		Query<Policy> theQuery = 
				currentSession.createQuery("from Policy",
											Policy.class);
		
		// execute query and get result list
		List<Policy> policies = theQuery.getResultList();
				
		// return the results		
		return policies;
	}


	@Override
	public Policy getPolicy(Long policyId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Policy policy = currentSession.get(Policy.class, policyId);
		return policy;
	}


	@Override
	public void save(Policy policy) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(policy);
	}


	@Override
	public void delete(Policy policy) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(policy);
	}

}
