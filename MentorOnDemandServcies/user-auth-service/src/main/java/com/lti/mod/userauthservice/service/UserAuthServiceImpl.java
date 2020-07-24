package com.lti.mod.userauthservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lti.mod.userauthservice.bean.User;
import com.lti.mod.userauthservice.core.UserNotFoundException;
import com.lti.mod.userauthservice.dto.UserDTO;
import com.lti.mod.userauthservice.dto.UserRolesDTO;
import com.lti.mod.userauthservice.mapper.UserMapper;
import com.lti.mod.userauthservice.repo.UserRepository;

@Service
public class UserAuthServiceImpl implements UserAuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	public void createUser(UserDTO userDTO) {
		User user = userMapper.userDtoToUser(userDTO);
		user = userRepository.save(user);
		userMapper.usetToUserDto(user);
	}
	

	private List<UserRolesDTO> saveOrUpdateUserRoles(List<UserRolesDTO> userRoles, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO updateUser(UserDTO userDTO) {
		User user = userMapper.userDtoToUser(userDTO);
		user = userRepository.save(user);
		if(user!=null) {
			throw new UserNotFoundException();
		}
		return userMapper.usetToUserDto(user);
	}

	public void deleteUser(Integer id) {
		User user = userRepository.findById(id);
		userRepository.delete(user);
	}

	public UserDTO getUser(Integer id) {
		User user = userRepository.findById(id);
		if(user!=null) {
			throw new UserNotFoundException();
		}
		return userMapper.usetToUserDto(user);
	}

}
