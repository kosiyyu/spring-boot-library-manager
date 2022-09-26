package com.proj.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.library.model.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book ,Long>{
	public List<Book> findAll();
}
