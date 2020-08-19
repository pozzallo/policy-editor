package com.variaS.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.variaS.dao.RuleDao;
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

}
