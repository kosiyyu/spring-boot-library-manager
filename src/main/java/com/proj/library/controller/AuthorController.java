package com.proj.library.controller;

import com.proj.library.model.Author;
import com.proj.library.service.AuthorService;
import com.proj.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @GetMapping
    public String displayAuthors(Model model) {
        model.addAttribute("authorList", authorService.findAllAlphabeticalOrder());
        return "author/list-authors";
    }

    @GetMapping("/new")
    public String displayAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        model.addAttribute("bookList", bookService.findAllAlphabeticalOrder());
        return "author/form-author";
    }

    @PostMapping("/save")
    public String saveAuthor(@Valid Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/update")
    public String displayAuthorFormUpdate(@RequestParam("authorId") long authorId, Model model) {
        Author author = authorService.findById(authorId);
        model.addAttribute("author", author);
        model.addAttribute("bookList", bookService.findAllAlphabeticalOrder());
        return "author/form-author";
    }

    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam("authorId") long authorId) {
        //here validation
        authorService.deleteById(authorId);
        return "redirect:/authors";
    }

}
