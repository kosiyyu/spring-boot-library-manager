package com.proj.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rules")
public class RulesController {
	
	@GetMapping
	public String displayRules() {
		return "rules/rules";
	}
}
