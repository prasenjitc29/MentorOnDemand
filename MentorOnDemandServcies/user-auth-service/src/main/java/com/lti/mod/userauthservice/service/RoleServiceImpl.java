package com.lti.mod.userauthservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.mod.userauthservice.bean.Role;
import com.lti.mod.userauthservice.dto.RoleDTO;
import com.lti.mod.userauthservice.mapper.RoleMapper;
import com.lti.mod.userauthservice.repo.RoleRepository;



public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleMapper roleMapper;

	public List<RoleDTO> getRoles() {
		List<RoleDTO> roleDtos = new ArrayList<RoleDTO>();
		List<Role> roles = roleRepository.findAll();
		if(roles != null)
			roleDtos =  roleMapper.roleToRoleDTOs(roles);
		return roleDtos;
	}

}
