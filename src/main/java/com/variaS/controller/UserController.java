package com.variaS.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.variaS.dto.UserDTO;
import com.variaS.entity.Department;
import com.variaS.entity.User;
import com.variaS.service.DepartmentService;
import com.variaS.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// need to inject our user service
	@Autowired
	private UserService userService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@GetMapping("/info")
	public String showMyLoginPage() {

		return "user-info";
	}
	

	
	
	


	
}
