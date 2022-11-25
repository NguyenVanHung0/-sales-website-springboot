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

import com.hungnguyen.springboot.model.dto.OrderDTO;
import com.hungnguyen.springboot.service.IOrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	IOrderService iOrderService;
	
	@GetMapping("")
	public ResponseEntity<?> getListOrder(){
		return ResponseEntity.ok(iOrderService.getListOrder());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getOrderById(@PathVariable Long id){
		return ResponseEntity.ok(iOrderService.getOrderById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO){
		return ResponseEntity.ok(iOrderService.createAndUpdateOrder(orderDTO));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable Long id){
		orderDTO.setId(id);
		return ResponseEntity.ok(iOrderService.createAndUpdateOrder(orderDTO));
	}
	
	@DeleteMapping("")
	public void deleteOrder(@RequestBody Long[] ids) {
		iOrderService.deleteOrder(ids);
	}

}
