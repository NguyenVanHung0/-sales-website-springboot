package com.hungnguyen.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Controller
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base {
	@Column
	private String userName;

	@Column
	private String password;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String address;

	@Column
	private String email;

	@Column
	private String phone;

	@Column
	private int status;

	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Order> orders = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Feedback> feedBacks = new ArrayList<>();

}
