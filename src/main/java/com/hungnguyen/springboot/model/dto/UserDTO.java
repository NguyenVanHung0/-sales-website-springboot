package com.hungnguyen.springboot.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.hungnguyen.springboot.entity.Feedback;
import com.hungnguyen.springboot.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends BaseDTO {
	private String userName;

	private String firstName;
	
	private String lastName;

	private String address;

	private String email;

	private String phone;

	private int status;
	
	private List<Long> listOrderId = new ArrayList<>();
	
	private List<Long> listFeedbackId = new ArrayList<>();
	
}
