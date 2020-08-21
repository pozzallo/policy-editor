package com.variaS.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.variaS.entity.Policy;
import com.variaS.service.PolicyService;
import com.variaS.utils.XccdfGenerator;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	@Autowired
	PolicyService policyService;

	
//	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@PostMapping("/uploadFile")
	public String submit(@RequestParam("file") MultipartFile file) {
		System.out.println(file);
		Policy createdPolicy = null;
		try {
			byte[] bytes = file.getBytes();
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
			createdPolicy = XccdfGenerator.createPolicy(byteArrayInputStream);
			policyService.save(createdPolicy);
			System.out.println(createdPolicy.getTitle());		
			System.out.println(createdPolicy.getId());	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "redirect:/policy/showPolicy?policyId=" + createdPolicy.getId();
	}
}
