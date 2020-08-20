package com.variaS.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.variaS.dao.RuleDao;
import com.variaS.entity.Policy;
import com.variaS.entity.Rule;

@Service
public class RuleServiceImpl implements RuleService {
	
	@Autowired
	private RuleDao ruleDao;


	@Override
	@Transactional
	public Rule getRule(Long ruleId) {
		
		return ruleDao.getRule(ruleId);
	}


	@Override
	@Transactional
	public void updateRule(Long id, String title,String description, String checkedText, String fixText) {
		Rule rule = ruleDao.getRule(id);
		rule.setTitle(title);
		rule.setDescription(description);
		rule.setCheckedText(checkedText);
		rule.setFixText(fixText);
		ruleDao.save(rule);
	}


	@Override
	@Transactional
	public void save(Rule rule) {
		ruleDao.save(rule);
	}


	@Override
	@Transactional
	public void delete(Long ruleId) {
		Rule rule = ruleDao.getRule(ruleId);
		ruleDao.delete(rule);
	}


	@Override
	@Transactional
	public void remuveRule(Long ruleId) {
		Rule rule = ruleDao.getRule(ruleId);
		rule.setPolicy(null);
		ruleDao.delete(rule);
	}
	


}
