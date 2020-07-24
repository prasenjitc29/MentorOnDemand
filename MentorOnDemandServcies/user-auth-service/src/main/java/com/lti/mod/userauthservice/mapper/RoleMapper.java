package com.lti.mod.userauthservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.lti.mod.userauthservice.bean.Role;
import com.lti.mod.userauthservice.dto.RoleDTO;



@Mapper(componentModel = "spring", uses = {})
public interface RoleMapper {
 RoleDTO roleToROleDTO(Role role);
 List<RoleDTO> roleToRoleDTOs(List<Role> roles);
}
