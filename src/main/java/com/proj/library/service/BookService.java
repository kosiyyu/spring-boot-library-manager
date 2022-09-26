package com.proj.library.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.library.model.Book;
import com.proj.library.repository.IBookRepository;

@Service
public class BookService {

	IBookRepository bookRepository;

	public BookService(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public List<Book> findAllAlphabeticalOrder(){
		List<Book> alphabeticalOrderList = bookRepository.findAll();
		Collections.sort(alphabeticalOrderList, new BookAlphabeticalComparator());
		return alphabeticalOrderList;
	}
	
	public Book findById(long bookId) {
		return bookRepository.findById(bookId).get();
	}
	
	public Book save(Book book) {
		bookRepository.save(book);
		return book;
	}
	
	public List<Book> save(List<Book> bookList) {
		bookRepository.saveAll(bookList);
		return bookList;
	}
	
	public void deleteById(long id) {
		bookRepository.deleteById(id);
	}
	

	
	
}
