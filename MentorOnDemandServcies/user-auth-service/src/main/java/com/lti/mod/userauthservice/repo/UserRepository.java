package com.lti.mod.userauthservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.mod.userauthservice.bean.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findById(Integer id);

}
