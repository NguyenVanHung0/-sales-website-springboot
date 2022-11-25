package com.hungnguyen.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungnguyen.springboot.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
