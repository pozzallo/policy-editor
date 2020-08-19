package com.variaS.dao;

import java.util.List;

import com.variaS.entity.Policy;

public interface PolicyDao {

	public List<Policy> getPolicies();

	public Policy getPolicy(Long policyId);
	

}
