package com.variaS.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.variaS.entity.Rule;

@Repository
public class RuleDaoImpl implements RuleDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Rule getRule(Long ruleId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Rule rule = currentSession.get(Rule.class, ruleId);
		return rule;
	}




}
