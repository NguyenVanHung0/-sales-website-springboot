package com.hungnguyen.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungnguyen.springboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
