package com.variaS.service;

import com.variaS.entity.Rule;

public interface RuleService {

	Rule getRule(Long ruleId);

	void updateRule(Long id,String title,String description, String checkedText, String fixText);

	void save(Rule rule);

	void delete(Long ruleId);

	void remuveRule(Long ruleId);

}
