package com.vtanh1905.dto;

import com.vtanh1905.entity.User;

public class UserRoleDto extends User{
	private String role_name;
	private String role_description;
	
	public UserRoleDto(String email, String password, String fullname, String avatar, int role_id, String role_name,
			String role_description) {
		super(email, password, fullname, avatar, role_id);
		this.role_name = role_name;
		this.role_description = role_description;
	}
	
	public UserRoleDto(int id,String email, String password, String fullname, String avatar, int role_id, String role_name,
			String role_description) {
		super(id, email, password, fullname, avatar, role_id);
		this.role_name = role_name;
		this.role_description = role_description;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_description() {
		return role_description;
	}

	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}
	
	
	
}
