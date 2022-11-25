package com.hungnguyen.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends Base {

	@Column
	private int status;

	@Column
	private double totalMoney;

	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonBackReference
	private User user;

	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	@JoinTable(name = "orderproduct", 
				joinColumns = @JoinColumn(name = "orderId"), 
				inverseJoinColumns = @JoinColumn(name = "productId"))
	private List<Product> products = new ArrayList<>();

}
