package com.variaS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.variaS.dao.PolicyDao;
import com.variaS.dao.RuleDao;
import com.variaS.entity.Policy;
import com.variaS.entity.Rule;

@Service
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private PolicyDao policyDao;
	
	@Autowired
	private RuleDao ruleDao;

	@Override
	@Transactional
	public List<Policy> getPolicies() {
		return policyDao.getPolicies();
	}

	@Override
	@Transactional
	public Policy getPolicy(Long policyId) {
		
		return policyDao.getPolicy(policyId);
	}

	@Override
	@Transactional
	public void save(Policy policy) {
		policyDao.save(policy);
		
	}

	@Override
	@Transactional
	public void update(Long id, long version, String description) {
		Policy policy = policyDao.getPolicy(id);
		policy.setVersion(version);
		policy.setDescription(description);
		policyDao.save(policy);
		
	}

	@Override
	@Transactional
	public void delete(Policy policy) {
		policyDao.delete(policy);
	}

	@Override
	@Transactional
	public void remuveRule(Long policyId, Long ruleId) {
		Policy policy = policyDao.getPolicy(policyId);
		Optional<Rule> optionalRule = policy.getRules().stream().filter(rule -> rule.getId().equals(ruleId)).findFirst();
		Rule rule = optionalRule.get();
		policy.getRules().remove(rule);
		rule.setPolicy(null);
		
		policyDao.save(policy);
	}

}
