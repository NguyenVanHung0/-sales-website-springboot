package com.hungnguyen.springboot.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungnguyen.springboot.entity.Feedback;
import com.hungnguyen.springboot.entity.Order;
import com.hungnguyen.springboot.entity.User;
import com.hungnguyen.springboot.exception.NotFoundException;
import com.hungnguyen.springboot.model.dto.UserDTO;
import com.hungnguyen.springboot.model.mapper.Mapper;
import com.hungnguyen.springboot.repository.FeedbackRepository;
import com.hungnguyen.springboot.repository.OrderRepository;
import com.hungnguyen.springboot.repository.UserRepository;
import com.hungnguyen.springboot.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public List<UserDTO> getListUser() {
		List<User> listUser = userRepository.findAll();
		List<UserDTO> result = new ArrayList<>();
		for (User user : listUser) {
			result.add(mapper.toUserDTO(user));
		}
		return result;
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepository.findById(id).get();
		if(user == null) {
			throw new NotFoundException("User khong ton tai");
		}
		else {
			return mapper.toUserDTO(user);
		}
	}

	@Override
	public UserDTO createAndUpdateUser(UserDTO userDTO) {
		User user = new User();
		if(userDTO.getId() != null) {
			User oldUser = userRepository.findById(userDTO.getId()).get();
			user = mapper.toUser(userDTO, oldUser);
		}
		else {
			user = mapper.toUser(userDTO);
		}
		List<Order> orders = new ArrayList<>();
		List<Feedback> feedbacks = new ArrayList<>();
		
		for(Long id : userDTO.getListOrderId()) {
			Order order = orderRepository.findById(id).get();
			orders.add(order);
		}
		
		for(Long id : userDTO.getListFeedbackId()) {
			Feedback feedback = feedbackRepository.findById(id).get();
			feedbacks.add(feedback);
		}
		
		user.setOrders(orders);
		user.setFeedBacks(feedbacks);
		
		userRepository.save(user);
		return mapper.toUserDTO(user);
	}

	@Override
	public void deleteUser(Long[] ids) {
		for (Long id : ids) {
			userRepository.deleteById(id);
		}
	}

}
