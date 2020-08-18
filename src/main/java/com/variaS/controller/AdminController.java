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
@RequestMapping("/admin")
public class AdminController {
	
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
	
	@GetMapping("/users")
	public String listUsers(Model theModel) {

		// get customers from the service
		List<User> theUsers = userService.getUsers();


		// add the customers to the model
		theModel.addAttribute("users", theUsers);

		return "list-users";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		List<Department> departments = departmentService.getDepartments();
		theModel.addAttribute("departments", departments);
		
		// create model attribute to bind form data
		UserDTO userDTO = new UserDTO();
		theModel.addAttribute("userDTO", userDTO);
		return "registration-form";
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, 
			BindingResult bindingResult) {
		
		String resultPage = "registration-form";
		System.out.println("\n" + bindingResult + "\n");
		// check if form has not validation error, then save user and send redirect
		if(!bindingResult.hasErrors()) {
			
			// convert dto to entity
			User theUser = convertToEntity(userDTO);

			// save the customer using our service
			userService.saveUser(theUser);
			
			//send redirect to user list
			resultPage = "redirect:/admin/users";
		}
		return resultPage;
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("userDTO") UserDTO userDTO) {

		// convert dto to entity
			User theUser = convertToEntity(userDTO);

			// save the customer using our service
			userService.updateUser(theUser);

		return "redirect:/admin/users";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId,
									Model theModel) {
		List<Department> departments = departmentService.getDepartments();
		theModel.addAttribute("departments", departments);
		
		// get the user from our service
		User user = userService.getUser(theId);
		UserDTO userDTO = convertToDTO(user);
		
		// set user DTO as a model attribute to pre-populate the form
		theModel.addAttribute("userDTO", userDTO);
		
		// send over to our form		
		return "user-form";
	}


	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {
		
		// delete the user
		userService.deleteUser(theId);
		
		return "redirect:/admin/users";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// search customers from the service
		List<User> users = userService.searchUser(theSearchName);

		// add the customers to the model
		theModel.addAttribute("users", users);

		return "list-users";
	}


	private User convertToEntity(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setUserName(userDTO.getUserName());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setEmail(userDTO.getEmail());
		user.setDescription(userDTO.getDescription());
		Department department = departmentService.getDepartment(userDTO.getDepartment());
		user.setDepartment(department);
		return user;
	}
	
	private UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUserName(user.getUserName());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		userDTO.setDescription(user.getDescription());
		Department department = user.getDepartment();
		if(department != null) {
			userDTO.setDepartment(department.getFullName());
		}
		return userDTO;
	}
	

}
