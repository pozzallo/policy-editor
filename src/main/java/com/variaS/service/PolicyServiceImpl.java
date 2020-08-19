package com.variaS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.variaS.dao.PolicyDao;
import com.variaS.entity.Policy;

@Service
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private PolicyDao policyDao;

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

}
