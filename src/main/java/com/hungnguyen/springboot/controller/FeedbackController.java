package com.hungnguyen.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hungnguyen.springboot.model.dto.FeedbackDTO;
import com.hungnguyen.springboot.service.IFeedbackService;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
	
	@Autowired
	IFeedbackService iFeedbackService;
	
	@GetMapping("")
	public ResponseEntity<?> getListFeedback(){
		return ResponseEntity.ok(iFeedbackService.getListFeedback());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getFeedbackById(@PathVariable Long id){
		return ResponseEntity.ok(iFeedbackService.getFeedbackById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<?> createFeedback(@RequestBody FeedbackDTO feedbackDTO){
		return ResponseEntity.ok(iFeedbackService.createAndUpdateFeedback(feedbackDTO));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateFeedback(@RequestBody FeedbackDTO feedbackDTO, @PathVariable Long id){
		feedbackDTO.setId(id);
		return ResponseEntity.ok(iFeedbackService.createAndUpdateFeedback(feedbackDTO));
	}
	
	@DeleteMapping("")
	public void deleteFeedback(@RequestBody Long[] ids) {
		iFeedbackService.deleteFeedback(ids);
	}
}
