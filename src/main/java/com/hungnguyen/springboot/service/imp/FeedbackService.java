package com.hungnguyen.springboot.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungnguyen.springboot.entity.Feedback;
import com.hungnguyen.springboot.entity.User;
import com.hungnguyen.springboot.model.dto.FeedbackDTO;
import com.hungnguyen.springboot.model.mapper.Mapper;
import com.hungnguyen.springboot.repository.FeedbackRepository;
import com.hungnguyen.springboot.repository.UserRepository;
import com.hungnguyen.springboot.service.IFeedbackService;

@Service
public class FeedbackService implements IFeedbackService{

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public List<FeedbackDTO> getListFeedback() {
		List<Feedback> list = feedbackRepository.findAll();
		List<FeedbackDTO> result = new ArrayList<>();
		for(Feedback feedback : list) {
			result.add(mapper.toFeedbackDTO(feedback));
		}
		return result;
	}

	@Override
	public FeedbackDTO getFeedbackById(Long id) {
		FeedbackDTO feedbackDTO = mapper.toFeedbackDTO(feedbackRepository.findById(id).get());
		return feedbackDTO;
	}

	@Override
	public FeedbackDTO createAndUpdateFeedback(FeedbackDTO feedbackDTO) {
		Feedback feedback = new Feedback();
		if(feedbackDTO.getId() != null) {
			Feedback oldFeedback = feedbackRepository.findById(feedbackDTO.getId()).get();
			feedback = mapper.toFeedback(feedbackDTO, oldFeedback);
		}
		else {
			feedback = mapper.toFeedback(feedbackDTO);
		}
		
		User user = userRepository.findById(feedbackDTO.getUserId()).get();
		feedback.setUser(user);
		
		feedbackRepository.save(feedback);
		return mapper.toFeedbackDTO(feedback);
	}

	@Override
	public void deleteFeedback(Long[] ids) {
		for(Long id : ids) {
			feedbackRepository.deleteById(id);
		}
		
	}

}
