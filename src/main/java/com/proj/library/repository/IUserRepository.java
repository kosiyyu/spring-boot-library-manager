package com.proj.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.library.model.User;

public interface IUserRepository extends JpaRepository<User ,Long>{

	
}
