package com.hungnguyen.springboot.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.hungnguyen.springboot.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryDTO extends BaseDTO {
	private String name;

	private String title;

	private String description;

	private int status;
	
	private List<Long> listProductId = new ArrayList<>();
}
