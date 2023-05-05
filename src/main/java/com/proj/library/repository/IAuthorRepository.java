package com.proj.library.repository;

import com.proj.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAll();

    void deleteById(long id);
}
