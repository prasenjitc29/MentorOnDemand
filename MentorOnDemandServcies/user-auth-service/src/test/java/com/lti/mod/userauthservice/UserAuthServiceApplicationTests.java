package com.lti.mod.userauthservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;

import org.apache.tomcat.jni.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.lti.mod.userauthservice.dto.UserDTO;
import com.lti.mod.userauthservice.dto.UserRolesDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserAuthServiceApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void createUserSuccessTest() {
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> request = 
	    	      new HttpEntity<String>(new UserDTO(1,1,"prasenjitc29", "prasenjit", "choudhury", "prasenjit", new ArrayList<UserRolesDTO>()).toString());
		
		ResponseEntity<UserDTO> response = testRestTemplate.postForEntity("/user",request, UserDTO.class);
		
		assertThat(response.getStatusCode().equals(HttpStatus.CREATED));
	}
	
	@Test
	public void getUserSuccessTest() {
		ResponseEntity<UserDTO> response = testRestTemplate.getForEntity("/user", UserDTO.class, "1");
		
		assertThat(response.getStatusCode().equals(HttpStatus.CREATED));
	}

}
