package com.hungnguyen.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungnguyen.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
