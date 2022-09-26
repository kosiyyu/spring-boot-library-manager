package com.proj.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proj.library.service.AuthorService;
import com.proj.library.service.BookService;
import com.proj.library.service.HomeService;

@Controller
@RequestMapping("")
public class HomeController {

	BookService bookService;
	AuthorService authorService;
	HomeService homeService;
	
	public HomeController(BookService bookService, AuthorService authorService, HomeService homeService) {
		this.bookService = bookService;
		this.authorService = authorService;
		this.homeService = homeService;
	}

	@GetMapping
	public String displayHome(Model model) {
		model.addAttribute("homeServie", homeService);
		model.addAttribute("bookList", bookService.findAllAlphabeticalOrder());
		return "home/home";
	}
}
