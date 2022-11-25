package com.hungnguyen.springboot.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO extends BaseDTO {
	private String code;

	private String name;

	private String title;

	private String description;

	private String image;

	private String[] moreImage;

	private double price;

	private double promotionPrice;

	private int quantity;

	private String detail;

	private int status;

	private List<Long> listOrderId = new ArrayList<>();

	private Long productCategoryId;
}
