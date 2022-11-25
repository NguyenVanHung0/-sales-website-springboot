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

import com.hungnguyen.springboot.model.dto.ProductCategoryDTO;
import com.hungnguyen.springboot.service.IProductCategoryService;

@RestController
@RequestMapping("productcategory")
public class ProductCategoryController {
	
	@Autowired 
	IProductCategoryService iProductCategoryService;
	
	@GetMapping("")
	public ResponseEntity<?> getListProductCategory(){
		return ResponseEntity.ok(iProductCategoryService.getListProductCategory());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getProductCategoryById(@PathVariable Long id){
		return ResponseEntity.ok(iProductCategoryService.getProductCategoryById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<?> createProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO){
		return ResponseEntity.ok(iProductCategoryService.createOrUpdateProductCategory(productCategoryDTO));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> createProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO, @PathVariable Long id){
		productCategoryDTO.setId(id);
		return ResponseEntity.ok(iProductCategoryService.createOrUpdateProductCategory(productCategoryDTO));
	}
	
	@DeleteMapping("")
	public void deleteProductCategory(@RequestBody Long[] ids){
		iProductCategoryService.deleteProductCategory(ids); 
	}
}
