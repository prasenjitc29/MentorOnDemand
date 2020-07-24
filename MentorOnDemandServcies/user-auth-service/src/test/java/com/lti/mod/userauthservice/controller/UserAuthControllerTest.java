package com.lti.mod.userauthservice.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.mod.userauthservice.core.UserNotFoundException;
import com.lti.mod.userauthservice.dto.UserDTO;
import com.lti.mod.userauthservice.dto.UserRolesDTO;
import com.lti.mod.userauthservice.service.UserAuthService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserAuthControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserAuthService userAuthService;

	@Test
	public void getUser_WithId_ReturnsUser() throws Exception  {
		when(userAuthService.getUser(1)).thenReturn(new UserDTO(1,1,"prasenjitc29", "prasenjit", "choudhury", "prasenjit", new ArrayList<UserRolesDTO>()));
		this.mockMvc.perform(get("/user/{id}", 1))
				.andExpect(status().isOk())
				.andExpect(jsonPath("userName").value("prasenjitc29"))
				.andExpect(jsonPath("firstName").value("prasenjit"))
				.andExpect(jsonPath("lastName").value("choudhury"));
	}

	@Test
	public void getuser_NotFound_Returns404() throws Exception {
		when(this.userAuthService.getUser(2)).thenThrow(new UserNotFoundException());
		this.mockMvc.perform(get("/user/{id}", 2))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void createtUser_ReturnsCreate() throws Exception {
		UserDTO user = new UserDTO(1,1,"prasenjitc29", "prasenjit", "choudhury", "prasenjit", new ArrayList<UserRolesDTO>());
		doNothing().when(userAuthService).createUser(user);
		this.mockMvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
		        .content(toJson(user)))
				.andExpect(status().isCreated());
	}
	
	 public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	
	@Test
	public void updateUser_ReturnsUser() throws Exception {
		UserDTO user = new UserDTO(1,1,"prasenjitc29", "prasenjit", "choudhury", "prasenjit", new ArrayList<UserRolesDTO>());
		when(this.userAuthService.updateUser(any())).thenReturn(user);
		this.mockMvc.perform(put("/user")
		.contentType(MediaType.APPLICATION_JSON)
        .content(toJson(user)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("userName").value("prasenjitc29"))
		.andExpect(jsonPath("firstName").value("prasenjit"))
		.andExpect(jsonPath("lastName").value("choudhury"));
	}
	
	@Test
	public void updateUser_NotFound_Returns404() throws Exception {
		UserDTO user = new UserDTO(1,1,"prasenjitc29", "prasenjit", "choudhury", "prasenjit", new ArrayList<UserRolesDTO>());
		when(this.userAuthService.updateUser(any())).thenThrow(new UserNotFoundException());
		this.mockMvc.perform(put("/user")
			.contentType(MediaType.APPLICATION_JSON)
	        .content(toJson(user)))		
			.andExpect(status().isNotFound());
	}
}
