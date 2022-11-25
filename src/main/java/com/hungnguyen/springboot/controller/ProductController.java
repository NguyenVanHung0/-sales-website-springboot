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

import com.hungnguyen.springboot.model.dto.ProductDTO;
import com.hungnguyen.springboot.service.IProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	IProductService iProductService;
	
	@GetMapping("")
	public ResponseEntity<?> getListProduct(){
		return ResponseEntity.ok(iProductService.getListProduct());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id){
		return ResponseEntity.ok(iProductService.getProductById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<?> createUser(@RequestBody ProductDTO productDTO){
		return ResponseEntity.ok(iProductService.createAndUpdateProduct(productDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody ProductDTO productDTO, @PathVariable Long id){
		productDTO.setId(id);
		return ResponseEntity.ok(iProductService.createAndUpdateProduct(productDTO));
	}
	
	@DeleteMapping("")
	public void deleteProduct(@RequestBody Long[] ids){
		iProductService.deleteProduct(ids);
	}
}
