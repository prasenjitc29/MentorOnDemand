package com.lti.mod.userauthservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.mod.userauthservice.bean.UserRoles;


@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long>{
	
	

}
