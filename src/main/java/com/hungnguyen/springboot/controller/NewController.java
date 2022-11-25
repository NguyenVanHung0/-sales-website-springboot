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

import com.hungnguyen.springboot.model.dto.NewDTO;
import com.hungnguyen.springboot.service.INewService;

@RestController
@RequestMapping("new")
public class NewController {
	
	@Autowired
	INewService iNewService;
	
	@GetMapping("")
	public ResponseEntity<?> getListNew(){
		return ResponseEntity.ok(iNewService.getListNew());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getNewById(@PathVariable Long id){
		return ResponseEntity.ok(iNewService.getNewById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<?> createNew(@RequestBody NewDTO newDTO){
		return ResponseEntity.ok(iNewService.createAndUpdateNew(newDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateNew(@RequestBody NewDTO newDTO, @PathVariable Long id){
		newDTO.setId(id);
		return ResponseEntity.ok(iNewService.createAndUpdateNew(newDTO));
	}
	
	@DeleteMapping("")
	public void deteleNew(@RequestBody Long[] ids) {
		iNewService.deleteNew(ids);
	}

}
