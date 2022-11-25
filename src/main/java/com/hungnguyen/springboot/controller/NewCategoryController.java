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

import com.hungnguyen.springboot.model.dto.NewCategoryDTO;
import com.hungnguyen.springboot.service.INewCategoryService;

@RestController
@RequestMapping("newcategory")
public class NewCategoryController {
	
	@Autowired 
	INewCategoryService iNewCategoryService;

	@GetMapping("")
	public ResponseEntity<?> getListNewCategory(){
		return ResponseEntity.ok(iNewCategoryService.getListNewCategory());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getNewCategoryById(@PathVariable Long id){
		return ResponseEntity.ok(iNewCategoryService.getNewCategoryById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<?> createNewCatedory(@RequestBody NewCategoryDTO newCategoryDTO){
		return ResponseEntity.ok(iNewCategoryService.createAndUpdateNewCategory(newCategoryDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> createNewCatedory(@RequestBody NewCategoryDTO newCategoryDTO, @PathVariable Long id){
		newCategoryDTO.setId(id);
		return ResponseEntity.ok(iNewCategoryService.createAndUpdateNewCategory(newCategoryDTO));
	}
	
	@DeleteMapping("")
	public void deleteNewCategory(@RequestBody Long[] ids){
		iNewCategoryService.deleteNewCategory(ids);
	}
	
}
