package com.hierarchical.HierProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hierarchical.HierProject.repos.RegisterRepo;
import com.hierarchical.HierProject.repos.UserRepo;
import com.hierarchical.HierProject.bean.UserDetails;
import com.hierarchical.HierProject.model.Register;
import com.hierarchical.HierProject.model.User;

@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RegisterRepo registerRepo;
	
	@GetMapping(value="getUserdata")
	public @ResponseBody UserDetails getUserData(@RequestParam String username) {
		User user=userRepo.findByUsername(username);
		Register register=registerRepo.getRegisterData(user.getUser_UUID());
		UserDetails userDetails=new UserDetails();
		userDetails.setUsername(user.getUsername());
		userDetails.setPassword(user.getPassword());
		userDetails.setEmail(register.getEmail());
		userDetails.setPhone(register.getPhone());
		userDetails.setDob(register.getDob());
		userDetails.setType(register.getType());
		return userDetails;
		
	}
}
