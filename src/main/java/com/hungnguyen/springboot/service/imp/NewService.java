package com.hungnguyen.springboot.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungnguyen.springboot.entity.New;
import com.hungnguyen.springboot.entity.NewCategory;
import com.hungnguyen.springboot.model.dto.NewDTO;
import com.hungnguyen.springboot.model.mapper.Mapper;
import com.hungnguyen.springboot.repository.NewCategoryRepository;
import com.hungnguyen.springboot.repository.NewRepository;
import com.hungnguyen.springboot.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private NewCategoryRepository newCategoryRepository;
	
	@Autowired
	private Mapper mapper;

	@Override
	public List<NewDTO> getListNew() {
		List<New> list = newRepository.findAll();
		List<NewDTO> result = new ArrayList<>();
		for(New news : list) {
			result.add(mapper.toNewDTO(news));
		}
		return result;
	}

	@Override
	public NewDTO getNewById(Long id) {
		NewDTO newDTO = mapper.toNewDTO(newRepository.findById(id).get());
		return newDTO;
	}

	@Override
	public NewDTO createAndUpdateNew(NewDTO newDTO) {
		New news = new New();
		if(newDTO.getId() != null) {
			New oldNew = newRepository.findById(newDTO.getId()).get();
			news = mapper.toNew(newDTO, oldNew);
		}
		else {
			news = mapper.toNew(newDTO);
		}
		NewCategory newCategory = newCategoryRepository.findById(newDTO.getCategoryId()).get();
		news.setNewCategory(newCategory);
		newRepository.save(news);
		return mapper.toNewDTO(news);
	}

	@Override
	public void deleteNew(Long[] ids) {
		for(Long id : ids) {
			newRepository.deleteById(id);
		}
	}

}
