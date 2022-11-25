package com.hungnguyen.springboot.service;

import java.util.List;

import com.hungnguyen.springboot.model.dto.NewCategoryDTO;

public interface INewCategoryService {
	public List<NewCategoryDTO> getListNewCategory();
	public NewCategoryDTO getNewCategoryById(Long id);
	public NewCategoryDTO createAndUpdateNewCategory(NewCategoryDTO newCategoryDTO);
	public void deleteNewCategory(Long[] ids);
}
