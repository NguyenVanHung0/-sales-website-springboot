package com.hungnguyen.springboot.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.hungnguyen.springboot.entity.Product;
import com.hungnguyen.springboot.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO extends BaseDTO {
	private int status;

	private double totalMoney;

	private Long userId;

	private List<Long> products = new ArrayList<>();
}
