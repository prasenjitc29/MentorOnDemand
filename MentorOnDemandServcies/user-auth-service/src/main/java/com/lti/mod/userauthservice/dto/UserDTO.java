package com.lti.mod.userauthservice.dto;

import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class UserDTO {

	private Integer id;
	private Integer version;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private List<UserRolesDTO> userRoles = null;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Integer id, Integer version, String userName, String firstName, String lastName, String password,
			List<UserRolesDTO> userRoles) {
		super();
		this.id = id;
		this.version = version;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userRoles = userRoles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<UserRolesDTO> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRolesDTO> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", version=" + version + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + ", userRoles=" + userRoles + "]";
	}
	
	

}


//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
//public class UserDTO {
//
//	private String userName;
//	private String firstName;
//	private String lastName;
//	private String password;
//	private List<UserRolesDTO> userRoles = null;
//	public UserDTO(String userName, String firstName, String lastName, String password,
//			List<UserRolesDTO> userRoles) {
//		super();
//		this.userName = userName;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.password = password;
//		this.userRoles = userRoles;
//	}
//	
//	
//}
