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
public class FeedbackDTO {
	private Long id;

	private String content;

	private int status;

	private Date createDate;

	private Long userId;
}
