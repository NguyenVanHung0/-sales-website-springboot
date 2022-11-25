package com.hungnguyen.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungnguyen.springboot.entity.New;

public interface NewRepository extends JpaRepository<New, Long> {

}
