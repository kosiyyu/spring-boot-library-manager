package com.proj.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.library.model.Author;
@Repository
public interface IAuthorRepository extends JpaRepository<Author,Long>{
	public List<Author> findAll();
	public void deleteById(long id);
}
