package com.lti.mod.userauthservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.mod.userauthservice.bean.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
