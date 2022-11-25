package com.hungnguyen.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hungnguyen.springboot.model.dto.UserDTO;
import com.hungnguyen.springboot.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@GetMapping("")
	public ResponseEntity<?> getListUser(){
			return ResponseEntity.ok(iUserService.getListUser());
	}
	
	@GetMapping("/{id}")
	public UserDTO getUserById(@PathVariable Long id){
		return iUserService.getUserById(id);
	}
	
	@PostMapping("")
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
		return ResponseEntity.ok(iUserService.createAndUpdateUser(userDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
		userDTO.setId(id);
		return ResponseEntity.ok(iUserService.createAndUpdateUser(userDTO));
	}
	
	@DeleteMapping("")
	public void deleteUser(@RequestBody Long[] ids){
		iUserService.deleteUser(ids);
	}

}
