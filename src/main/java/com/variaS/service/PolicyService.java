package com.variaS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.variaS.entity.Policy;

public interface PolicyService {
	
	

	public List<Policy> getPolicies();

	public Policy getPolicy(Long policyId);

}
