package com.mentorondemand.student.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mentorondemand.student.dto.UserDTO;

@FeignClient("user-service")
public interface UserFeign {
	
	@GetMapping(path = "/api/user/{userName}")
	public UserDTO getUser(@PathVariable("userName")String userName);

}