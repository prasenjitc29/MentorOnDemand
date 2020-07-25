package com.mentorondemand.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.user.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	List<Role> findByIdIn(List<Integer> roleIds);

}
