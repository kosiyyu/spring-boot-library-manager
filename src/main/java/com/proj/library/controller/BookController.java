package com.proj.library.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.library.model.Book;
import com.proj.library.service.AuthorService;
import com.proj.library.service.BookService;
import com.proj.library.service.HomeService;

@Controller
@RequestMapping("/books")
public class BookController {

	private BookService bookService;	
	private AuthorService authorService;
	private HomeService homeService;

	public BookController(BookService bookService, AuthorService authorService, HomeService homeService) {
		this.bookService = bookService;
		this.authorService = authorService;
		this.homeService = homeService;
	}

	@GetMapping
	public String displayBooks(Model model) {
		model.addAttribute("bookList", bookService.findAllAlphabeticalOrder());
		return "book/list-books";
	}
	
	@GetMapping("/new")
	public String displayBookForm(Model model) {
		
		model.addAttribute("authorList", authorService.findAllAlphabeticalOrder());
		model.addAttribute("book", new Book());
		return "book/form-book";
	}
	
	@GetMapping("/info")
	public String displayBookInfo(@RequestParam("bookId") long bookId, Model model ) {
		Book book = bookService.findById(bookId);
		model.addAttribute("book", book);
		model.addAttribute("homeService", homeService);
		model.addAttribute("authorList", authorService.findAllAlphabeticalOrder());
		return "book/info-book";
	}
	
	@PostMapping("/save")
	public String saveBook(@Valid Book book) {
		bookService.save(book);	
		return "redirect:/books"; 
	}
	
	@GetMapping("/update")
	public String displayBookFormUpdate(@RequestParam("bookId") long bookId, Model model ) {
		Book book = bookService.findById(bookId);
		model.addAttribute("authorList", authorService.findAllAlphabeticalOrder());
		model.addAttribute("book", book);
		return "book/form-book";
	}
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam("bookId") long bookId) {
		//here validation
		bookService.deleteById(bookId);
		return "redirect:/books"; 
	}
}
