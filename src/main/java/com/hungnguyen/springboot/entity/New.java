package com.hungnguyen.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "new")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class New extends Base {
	@Column 
	private String title;
	
	@Column 
	private String description;
	
	@Column 
	private String image;
	
	
	@Column 
	private String detail;
	
	@Column 
	private int status;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column
	private Date topHot;
	
	@Column 
	private String tagName;
	
	@ManyToOne()
	@JoinColumn(name = "categoryId")
	@JsonBackReference
    private NewCategory newCategory;
}
