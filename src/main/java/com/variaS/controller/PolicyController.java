package com.variaS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	@RequestMapping("/showPolicy" )
	public String showPolicy(@RequestParam("policyId") Long policyId, Model theModel) {

		Policy policy = policyService.getPolicy(policyId);
		theModel.addAttribute("policyTitle", policy.getTitle());
		PolicyDTO policyDTO = new PolicyDTO(policy.getId(), policy.getDescription(), policy.getVersion());
		theModel.addAttribute("policyDTO", policyDTO);
		List<Profile> profiles = policy.getProfiles();
		theModel.addAttribute("profiles", profiles);
		List<Rule> rules = policy.getRules();
		theModel.addAttribute("rules", rules);
		theModel.addAttribute("policyId", policyId);

		return "policy";
	}

	@GetMapping("/showRule")
	public String showRule(@RequestParam("ruleId") Long ruleId,@RequestParam("policyId") Long policyId, 
			Model theModel) {

		Rule rule = ruleService.getRule(ruleId);
		
		theModel.addAttribute("ruleTitle", rule.getTitle());
		theModel.addAttribute("ruleProfiles", rule.getProfiles());
		theModel.addAttribute("rule", rule);
		theModel.addAttribute("policyId", policyId);
		return "rule";
	}
	
	@PostMapping("/savePolicy")
	public String savePolicy(@ModelAttribute("policyDTO") PolicyDTO policyDTO) {

		policyService.update(policyDTO.getId(),policyDTO.getVersion(),policyDTO.getDescription());
		
		return "redirect:/policy/showPolicy?policyId=" + policyDTO.getId();
	}
	
	@PostMapping("/saveRule")
	public String saveRule(@ModelAttribute("rule") Rule rule, @RequestParam("policyId") Long policyId) {

		if(rule.getId() == null) {
			rule.setPolicy(policyService.getPolicy(policyId));
			ruleService.save(rule);
			
		}else {
			ruleService.updateRule(rule.getId(),rule.getTitle(),rule.getDescription(),rule.getCheckedText(),rule.getFixText());
		}
	
		
		return "redirect:/policy/showRule?ruleId=" + rule.getId() + "&policyId=" + policyId;
	}
	
	@GetMapping("/addRule")
	public String addRule(@RequestParam("policyId") Long policyId, Model theModel ) {
		
		theModel.addAttribute("rule", new Rule());
		theModel.addAttribute("policyId", policyId);
		return "rule";
		
	}
	
	@GetMapping("/deletePolicy")
	public String deletePolicy(@RequestParam("policyId") Long policyId) {
		policyService.delete(policyService.getPolicy(policyId));

		return "redirect:/";
	}
	
//	@GetMapping("/deleteRule")
//	public String deleteRule(@RequestParam("policyId") Long policyId, @RequestParam("ruleId") Long ruleId) {
//		Policy policy = policyService.getPolicy(policyId);
//		Optional<Rule> optionalRule = policy.getRules().stream().filter(rule -> rule.getId().equals(ruleId)).findFirst();
//		Rule rule = optionalRule.get();
//		policy.getRules().remove(rule);
//		return "redirect:/policy/showPolicy?policyId=" + policyId;
//	}

	
	@GetMapping("/deleteRule")
	public String deleteRule(@RequestParam("policyId") Long policyId, @RequestParam("ruleId") Long ruleId) {
		policyService.remuveRule(policyId,ruleId);
//		ruleService.remuveRule(ruleId);
		return "redirect:/policy/showPolicy?policyId=" + policyId;
	}
	
	
	
}
