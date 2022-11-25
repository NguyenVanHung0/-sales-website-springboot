package com.hungnguyen.springboot.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungnguyen.springboot.entity.Product;
import com.hungnguyen.springboot.entity.ProductCategory;
import com.hungnguyen.springboot.model.dto.ProductCategoryDTO;
import com.hungnguyen.springboot.model.mapper.Mapper;
import com.hungnguyen.springboot.repository.ProductCategoryRepository;
import com.hungnguyen.springboot.repository.ProductRepository;
import com.hungnguyen.springboot.service.IProductCategoryService;

@Service
public class ProductCategoryService implements IProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private Mapper mapper;

	@Override
	public List<ProductCategoryDTO> getListProductCategory() {
		List<ProductCategory> list = productCategoryRepository.findAll();
		List<ProductCategoryDTO> result = new ArrayList<>();
		for (ProductCategory productCategory : list) {
			result.add(mapper.toProductCategoryDTO(productCategory));
		}
		return result;
	}

	@Override
	public ProductCategoryDTO getProductCategoryById(Long id) {
		ProductCategory productCategory = productCategoryRepository.findById(id).get();
		ProductCategoryDTO productCategoryDTO = mapper.toProductCategoryDTO(productCategory);
		
		return productCategoryDTO;
	}

	@Override
	public ProductCategoryDTO createOrUpdateProductCategory(ProductCategoryDTO productCategoryDTO) {
		ProductCategory productCategory = new ProductCategory();
		if(productCategoryDTO.getId() != null) {
			ProductCategory oldProductCategory = productCategoryRepository.findById(productCategoryDTO.getId()).get() ;
			productCategory = mapper.toProductCategory(productCategoryDTO, oldProductCategory);
		}
		else {
			productCategory = mapper.toProductCategory(productCategoryDTO);
		}
		
		List<Long> listProductId = productCategoryDTO.getListProductId();
		List<Product> products = new ArrayList<>();
		for(Long id : listProductId) {
			products.add(productRepository.findById(id).get());
		}
		productCategory.setProducts(products);
		
		productCategoryRepository.save(productCategory);
		return mapper.toProductCategoryDTO(productCategory);
	}

	@Override
	public void deleteProductCategory(Long[] ids) {
		for (Long id : ids) {
			productCategoryRepository.deleteById(id);
		}
	}
		
}
	
	


