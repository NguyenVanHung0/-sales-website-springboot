package com.hungnguyen.springboot.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.hungnguyen.springboot.entity.New;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewCategoryDTO extends BaseDTO {

	private String name;

	private String title;

	private int status;

	private String description;

	private List<Long> news = new ArrayList<>();
}
