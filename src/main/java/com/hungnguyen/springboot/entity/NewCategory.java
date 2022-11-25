package com.hungnguyen.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "newcategory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewCategory extends Base{
	@Column
	private String name;
	
	@Column
	private String title;
	
	@Column
	private int status;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy = "newCategory")
	@JsonManagedReference
	private List<New> news = new ArrayList<>();
}
