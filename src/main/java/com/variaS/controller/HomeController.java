package com.variaS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.variaS.entity.Policy;
import com.variaS.service.PolicyService;

@Controller
public class HomeController {
	@Autowired
	PolicyService policyService;
	

	@GetMapping("/")
	public String showHome(Model theModel) {
		List<Policy> policies = policyService.getPolicies();
		
		theModel.addAttribute("policies", policies);
		
		return "home";
	}
}
