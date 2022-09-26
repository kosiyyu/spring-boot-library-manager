package com.proj.library.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.library.model.Author;
import com.proj.library.repository.IAuthorRepository;
@Service
public class AuthorService {
	IAuthorRepository authorRepository;

	public AuthorService(IAuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public List<Author> findAll(){
		return authorRepository.findAll();
	}
	
	public List<Author> findAllAlphabeticalOrder(){
		List<Author> alphabeticalOrderList = authorRepository.findAll();
		Collections.sort(alphabeticalOrderList, new AuthorAlphabeticalComparator());
		return alphabeticalOrderList;
	}
	
	public Author findById(long authorId) {
		return authorRepository.findById(authorId).get();
	}
	
	public Author save(Author author) {
		authorRepository.save(author);
		return author;
	}
	
	public List<Author> save(List<Author> authorList) {
		authorRepository.saveAll(authorList);
		return authorList;
	}
	
	public void deleteById(long id) {
		authorRepository.deleteById(id);
	}
}
