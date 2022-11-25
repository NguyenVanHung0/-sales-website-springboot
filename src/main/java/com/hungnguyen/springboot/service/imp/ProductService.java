package com.hungnguyen.springboot.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungnguyen.springboot.entity.Order;
import com.hungnguyen.springboot.entity.Product;
import com.hungnguyen.springboot.entity.ProductCategory;
import com.hungnguyen.springboot.model.dto.ProductDTO;
import com.hungnguyen.springboot.model.mapper.Mapper;
import com.hungnguyen.springboot.repository.OrderRepository;
import com.hungnguyen.springboot.repository.ProductCategoryRepository;
import com.hungnguyen.springboot.repository.ProductRepository;
import com.hungnguyen.springboot.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	private Mapper mapper;

	@Override
	public List<ProductDTO> getListProduct() {
		List<Product> list = productRepository.findAll();
		List<ProductDTO> result = new ArrayList<>();
		for(Product product : list) {
			ProductDTO productDTO = mapper.toProductDTO(product);
			result.add(productDTO);
		}
		return result;
	}
	
	@Override
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id).get();
		ProductDTO productDTO = mapper.toProductDTO(product);
		return productDTO;
	}

	@Override
	public ProductDTO createAndUpdateProduct(ProductDTO productDTO) {
		Product product = new Product();
		if(productDTO.getId() != null) {
			Product oldProduct = productRepository.findById(productDTO.getId()).get();
			product = mapper.toProduct(productDTO, oldProduct);
		}
		else {
			product = mapper.toProduct(productDTO);
		}
		
		ProductCategory productCategory = productCategoryRepository.findById(productDTO.getProductCategoryId()).get();
		product.setProductCategory(productCategory);
		
		List<Long> listOrderId = productDTO.getListOrderId();
		List<Order> orders = new ArrayList<>();
		for(Long id : listOrderId) {
			orders.add(orderRepository.findById(id).get());
		}
		product.setListOrder(orders);
		
		productRepository.save(product);
		return mapper.toProductDTO(product);
	}

	@Override
	public void deleteProduct(Long[] ids) {
		for (Long id : ids) {
			productRepository.deleteById(id);
		}
	}

}
