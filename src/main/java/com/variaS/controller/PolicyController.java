package com.variaS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.variaS.dto.PolicyDTO;
import com.variaS.entity.Policy;
import com.variaS.entity.Profile;
import com.variaS.entity.Rule;
import com.variaS.service.PolicyService;
import com.variaS.service.RuleService;

@Controller
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	PolicyService policyService;

	@Autowired
	RuleService ruleService;

	@GetMapping("/showPolicy")
	public String showPolicy(@RequestParam("policyId") Long policyId, Model theModel) {

		Policy policy = policyService.getPolicy(policyId);
		theModel.addAttribute("policyTitle", policy.getTitle());
		PolicyDTO policyDTO = new PolicyDTO(policy.getId(), policy.getDescription(), policy.getVersion());
		theModel.addAttribute("policyDTO", policyDTO);
		List<Profile> profiles = policy.getProfiles();
		theModel.addAttribute("profiles", profiles);
		List<Rule> rules = policy.getRules();
		theModel.addAttribute("rules", rules);

		return "policy";
	}

	@GetMapping("/showRule")
	public String showRule(@RequestParam("ruleId") Long ruleId, Model theModel) {

		Rule rule = ruleService.getRule(ruleId);
		theModel.addAttribute("ruleTitle", rule.getTitle());
		theModel.addAttribute("ruleProfiles", rule.getProfiles());
		theModel.addAttribute("rule", rule);
		return "rule";
	}

}
