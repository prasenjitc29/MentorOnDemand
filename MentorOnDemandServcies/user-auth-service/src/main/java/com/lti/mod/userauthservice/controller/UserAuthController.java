package com.lti.mod.userauthservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.mod.userauthservice.dto.UserDTO;
import com.lti.mod.userauthservice.service.UserAuthService;

@RestController
public class UserAuthController {
	
	@Autowired
	private UserAuthService userAuthService;

	@PostMapping("/user")
	public ResponseEntity createUser(@RequestBody UserDTO user ) {
		 userAuthService.createUser(user);
		 return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id){
		UserDTO user = userAuthService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/user")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user){
		user = userAuthService.updateUser(user);
		return ResponseEntity.ok(user);
	}
	
//	@DeleteMapping(path = "/user", value = "/{id}")
//	public void deleteUser(@PathVariable Integer id){
//		userAuthService.deleteUser(id);
//	}
	
	
}
