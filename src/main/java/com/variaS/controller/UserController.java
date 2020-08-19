package com.variaS.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.variaS.dto.PasswordDTO;
import com.variaS.dto.UserDTO;
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
	
	@RequestMapping("/showChangePasswordForm")
	public String showChangePasswordForm(Model theModel) {
		
		theModel.addAttribute("passwordDTO", new PasswordDTO());

		return "change-password";
	}

	@RequestMapping(value="/changePassword", method = RequestMethod.POST)
	public String changePassword(Principal principal,
			@Valid @ModelAttribute("passwordDTO") PasswordDTO passwordDTO,BindingResult bindingResult) {
		
		System.out.println(bindingResult);
		String resultPage = "change-password";
		if(!bindingResult.hasErrors()) {
			String userName = principal.getName();
			System.out.println("Principale name: " + userName);
			User currentUser = userService.findByUserName(userName);
			userService.changeUserPassword(passwordDTO.getPassword(), currentUser);
			resultPage = "password-confirmation";
		}
	return resultPage;
}
	
	


	
}
