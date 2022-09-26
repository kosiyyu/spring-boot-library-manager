package com.proj.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.proj.library.model.User;
import com.proj.library.service.UserService;

@Controller
public class RegisterController {
	
	UserService userService;
	
	RegisterController(UserService userService){
		this.userService = userService;
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "register/register";
	}
	
	@PostMapping("/register/save")
	public String saveUser(Model model, User user)
	{
		userService.saveAndEncode(user);
		return "redirect:/";
	}
	
}
