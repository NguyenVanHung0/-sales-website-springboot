package com.hungnguyen.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungnguyen.springboot.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
