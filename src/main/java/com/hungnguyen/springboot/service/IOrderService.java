package com.hungnguyen.springboot.service;

import java.util.List;

import com.hungnguyen.springboot.model.dto.OrderDTO;

public interface IOrderService {
	public List<OrderDTO> getListOrder();
	public OrderDTO getOrderById(Long id);
	public OrderDTO createAndUpdateOrder(OrderDTO orderDTO);
	public void deleteOrder(Long[] ids);
}
