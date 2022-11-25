package com.hungnguyen.springboot.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {
	
	private Long id;
	
	private Date createdDate;

	private String createdBy;

	private Date modifiedDate;

	private String modifiedBy;
}
