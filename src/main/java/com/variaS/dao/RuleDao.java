package com.variaS.dao;

import com.variaS.entity.Rule;

public interface RuleDao {
	
	public Rule getRule(Long ruleId);

	public void save(Rule rule);

	public void delete(Rule rule);
}
