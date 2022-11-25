package com.hungnguyen.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Base {
	@Column
	private String code;

	@Column
	private String name;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private String image;

	@Column
	private String[] moreImage;

	@Column
	private double price;

	@Column
	private double promotionPrice;

	@Column
	private int quantity;


	@Column
	private String detail;

	@Column
	private int status;

	@ManyToMany(mappedBy = "products")
	private List<Order> listOrder = new ArrayList<>();
	
	@ManyToOne()
	@JoinColumn(name = "categoryId")
	@JsonBackReference
    private ProductCategory productCategory;
}
