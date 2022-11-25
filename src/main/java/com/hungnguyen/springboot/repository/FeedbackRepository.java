package com.hungnguyen.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungnguyen.springboot.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
