package com.hungnguyen.springboot.service;

import java.util.List;

import com.hungnguyen.springboot.model.dto.UserDTO;


public interface IUserService {
	public List<UserDTO> getListUser();
	public UserDTO getUserById(Long id);
	public UserDTO createAndUpdateUser(UserDTO userDTO);
	public void deleteUser(Long[] ids);
}
