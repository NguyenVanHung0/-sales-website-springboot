package com.hungnguyen.springboot.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungnguyen.springboot.entity.New;
import com.hungnguyen.springboot.entity.NewCategory;
import com.hungnguyen.springboot.model.dto.NewCategoryDTO;
import com.hungnguyen.springboot.model.mapper.Mapper;
import com.hungnguyen.springboot.repository.NewCategoryRepository;
import com.hungnguyen.springboot.repository.NewRepository;
import com.hungnguyen.springboot.service.INewCategoryService;

@Service
public class NewCategoryService implements INewCategoryService{

	@Autowired
	private NewCategoryRepository newCategoryRepository;
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public List<NewCategoryDTO> getListNewCategory() {
		List<NewCategory> list = newCategoryRepository.findAll();
		List<NewCategoryDTO> result = new ArrayList<>();
		for(NewCategory newCategory : list) {
			result.add(mapper.toNewCategoryDTO(newCategory));
		}
		return result;
	}

	@Override
	public NewCategoryDTO getNewCategoryById(Long id) {
		NewCategoryDTO result = mapper.toNewCategoryDTO(newCategoryRepository.findById(id).get());
		
		return result;
	}

	@Override
	public NewCategoryDTO createAndUpdateNewCategory(NewCategoryDTO newCategoryDTO) {
		NewCategory newCategory = new NewCategory();
		if(newCategoryDTO.getId() != null) {
			NewCategory oldNewCategory = newCategoryRepository.findById(newCategoryDTO.getId()).get();
			newCategory = mapper.toNewCategory(newCategoryDTO, oldNewCategory);
		}
		else {
			newCategory = mapper.toNewCategory(newCategoryDTO);
		}
		
		List<Long> listNewId = newCategoryDTO.getNews();
		List<New> news = new ArrayList<>();
		for(Long id : listNewId) {
			news.add(newRepository.findById(id).get());
		}
		newCategory.setNews(news);
		newCategoryRepository.save(newCategory);
		return mapper.toNewCategoryDTO(newCategory);
	}

	@Override
	public void deleteNewCategory(Long[] ids) {
		for(Long id : ids) {
			newCategoryRepository.deleteById(id);
		}
	}

}
