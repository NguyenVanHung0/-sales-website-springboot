package com.hungnguyen.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungnguyen.springboot.entity.NewCategory;

public interface NewCategoryRepository extends JpaRepository<NewCategory, Long> {

}
