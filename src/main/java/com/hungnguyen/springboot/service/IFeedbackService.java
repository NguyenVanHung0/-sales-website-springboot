package com.hungnguyen.springboot.service;

import java.util.List;

import com.hungnguyen.springboot.model.dto.FeedbackDTO;

public interface IFeedbackService {
	public List<FeedbackDTO> getListFeedback();
	public FeedbackDTO getFeedbackById(Long id);
	public FeedbackDTO createAndUpdateFeedback(FeedbackDTO feedbackDTO);
	public void deleteFeedback(Long[] ids);
}
