package com.lti.mod.userauthservice.service;

import com.lti.mod.userauthservice.dto.UserDTO;

public interface UserAuthService {
	public void createUser(UserDTO userDTO);
	public UserDTO updateUser(UserDTO userDTO);
	public void deleteUser(Integer id);
	public UserDTO getUser(Integer id);
}
