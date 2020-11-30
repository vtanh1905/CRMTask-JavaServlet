package com.vtanh1905.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.entity.Role;
import com.vtanh1905.repository.RoleRepository;
import com.vtanh1905.utils.JDBCConnection;

public class RoleService {
	private RoleRepository roleRepository;
	
	public RoleService() {
		roleRepository = new RoleRepository();
	}
	
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
	
	public Role findById(int roleId) {
		return roleRepository.findById(roleId);
	}
	
	public int save(Role role) {
		Role checkNameExist = roleRepository.findByName(role.getName());
		if(checkNameExist != null) return -1;
		
		return roleRepository.save(role);
	}
	
	public int update(Role role) {
		Role checkNameExist = roleRepository.findByName(role.getName());
		if(checkNameExist != null && checkNameExist.getId() != role.getId()) return -1;
		
		return roleRepository.update(role);
	}
	
	public int delete(int roleID) {
		return roleRepository.delete(roleID);
	}
}
