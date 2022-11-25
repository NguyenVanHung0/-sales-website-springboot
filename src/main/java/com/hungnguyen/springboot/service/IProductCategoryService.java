package com.hungnguyen.springboot.service;

import java.util.List;

import com.hungnguyen.springboot.model.dto.ProductCategoryDTO;

public interface IProductCategoryService {
	public List<ProductCategoryDTO> getListProductCategory();
	public ProductCategoryDTO getProductCategoryById(Long id);
	public ProductCategoryDTO createOrUpdateProductCategory(ProductCategoryDTO productCategoryDTO);
	public void deleteProductCategory(Long[] ids);
}
