package com.hungnguyen.springboot.service;

import java.util.List;

import com.hungnguyen.springboot.model.dto.ProductDTO;

public interface IProductService {
	public List<ProductDTO> getListProduct();
	public ProductDTO getProductById(Long id);
	public ProductDTO createAndUpdateProduct(ProductDTO productDTO);
	public void deleteProduct(Long[] ids);
}
