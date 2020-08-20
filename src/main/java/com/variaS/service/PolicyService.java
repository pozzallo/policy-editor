package com.variaS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.variaS.entity.Policy;

public interface PolicyService {
	
	

	public List<Policy> getPolicies();

	public Policy getPolicy(Long policyId);

	public void save(Policy policy);

	public void update(Long id,long version, String description);

	public void delete(Policy policy);

	public void remuveRule(Long policyId, Long ruleId);


}
