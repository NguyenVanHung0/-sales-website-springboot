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
@Table(name = "productcategory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory extends Base {
	@Column
	private String name;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private int status;

	@OneToMany(mappedBy = "productCategory")
	@JsonManagedReference
	private List<Product> products = new ArrayList<>();

}
