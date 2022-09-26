package com.proj.library.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	@GetMapping
	public String displayLogoutForm() {
		return "logout/logout";
	}
	
	@GetMapping("/logout-success")
	public String displayLogoutSuccess() {
		return "logout/logout-success";
	}
	
	@GetMapping("/logout-failure")
	public String displayLogoutFailure() {
		return "logout/logout-failure";
	}
		
    @PostMapping("/handle")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){    
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            return "redirect:/logout/logout-success";
        }
        return "redirect:logout/logout-failure";
    }
}
