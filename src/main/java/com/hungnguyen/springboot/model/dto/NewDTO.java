package com.hungnguyen.springboot.model.dto;

import java.util.Date;

import com.hungnguyen.springboot.entity.NewCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewDTO extends BaseDTO{
	
	private String title;
	
	private String description;
	
	private String image;
	
	private String detail;
	
	private int status;
	
	private Date topHot;
	
	private String tagName;
	
    private Long categoryId;
}
