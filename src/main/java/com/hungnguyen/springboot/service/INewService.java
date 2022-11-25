package com.hungnguyen.springboot.service;

import java.util.List;

import com.hungnguyen.springboot.model.dto.NewDTO;

public interface INewService {
	public List<NewDTO> getListNew();
	public NewDTO getNewById(Long id);
	public NewDTO createAndUpdateNew(NewDTO newDTO);
	public void deleteNew(Long[] ids);
}
