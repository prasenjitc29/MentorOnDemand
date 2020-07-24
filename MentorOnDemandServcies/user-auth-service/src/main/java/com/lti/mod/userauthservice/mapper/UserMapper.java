package com.lti.mod.userauthservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.lti.mod.userauthservice.bean.User;
import com.lti.mod.userauthservice.bean.UserRoles;
import com.lti.mod.userauthservice.dto.UserDTO;
import com.lti.mod.userauthservice.dto.UserRolesDTO;



@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {
	User userDtoToUser(UserDTO user);
	UserDTO usetToUserDto(User user);
	
	UserRoles userRoleDtoToUserRole(UserRolesDTO userRoleDTO);
	UserRolesDTO userRoleToUserRoleDto(UserRoles userRoleDTO);
	
	List<UserRoles> userRoleDtoToUserRoles(List<UserRolesDTO> userRoleDTO);
	List<UserRolesDTO> userRoleToUserRoleDtos(List<UserRoles> userRoleDTO);

}
