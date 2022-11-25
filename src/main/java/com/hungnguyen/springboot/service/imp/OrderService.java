package com.hungnguyen.springboot.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungnguyen.springboot.entity.Order;
import com.hungnguyen.springboot.entity.Product;
import com.hungnguyen.springboot.entity.User;
import com.hungnguyen.springboot.model.dto.OrderDTO;
import com.hungnguyen.springboot.model.mapper.Mapper;
import com.hungnguyen.springboot.repository.OrderRepository;
import com.hungnguyen.springboot.repository.ProductRepository;
import com.hungnguyen.springboot.repository.UserRepository;
import com.hungnguyen.springboot.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public List<OrderDTO> getListOrder() {
		List<Order> list = orderRepository.findAll();
		List<OrderDTO> result = new ArrayList<>();
		for(Order order : list) {
			OrderDTO orderDTO = mapper.toOrderDTO(order);
			List<Product> listProduct = order.getProducts();
			List<Long> products = new ArrayList<>();
			for(Product product : listProduct) {
				products.add(product.getId());
			}
			orderDTO.setProducts(products);
			
			result.add(orderDTO);
		}
		return result;
	}

	@Override
	public OrderDTO getOrderById(Long id) {
		Order order = orderRepository.findById(id).get();
		OrderDTO orderDTO = mapper.toOrderDTO(order);
		List<Product> listProduct = order.getProducts();
		List<Long> products = new ArrayList<>();
		for(Product product : listProduct) {
			products.add(product.getId());
		}
		orderDTO.setProducts(products);
		return orderDTO;
	}

	@Override
	public OrderDTO createAndUpdateOrder(OrderDTO orderDTO) {
		Order order = new Order();
		if(orderDTO.getId() != null) {
			Order oldOrder = orderRepository.findById(orderDTO.getId()).get();
			order = mapper.toOrder(orderDTO, oldOrder);
		}
		else {
			order = mapper.toOrder(orderDTO);
		}
		
		User user = userRepository.findById(orderDTO.getUserId()).get();
		order.setUser(user);
		
		List<Long> listProductId = orderDTO.getProducts();
		List<Product> products = new ArrayList<>();
		for(Long id : listProductId) {
			products.add(productRepository.findById(id).get());
		}
		order.setProducts(products);
		
		orderRepository.save(order);
		return mapper.toOrderDTO(order);
	}

	@Override
	public void deleteOrder(Long[] ids) {
		for(Long id : ids) {
			orderRepository.deleteById(id);
		}
	}

}
