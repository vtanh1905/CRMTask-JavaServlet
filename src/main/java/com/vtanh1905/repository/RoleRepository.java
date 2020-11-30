package com.vtanh1905.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.entity.Role;
import com.vtanh1905.utils.JDBCConnection;

public class RoleRepository {
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<Role>();
		final String QUERY = "SELECT * FROM roles"; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				roles.add(new Role(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return roles;
	}
	
	public Role findById(int roleId) {
		final String QUERY = "SELECT * FROM roles where id = ? "; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, roleId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				return new Role(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public Role findByName(String name) {
		final String QUERY = "SELECT * FROM roles where name = ? "; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				return new Role(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public int save(Role role) {
		final String QUERY = "INSERT INTO roles(name, description) values(?, ?)"; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, role.getName());
			preparedStatement.setString(2, role.getDescription());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int update(Role role) {
		final String QUERY = "UPDATE roles SET name = ?, description = ? WHERE id = ?"; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, role.getName());
			preparedStatement.setString(2, role.getDescription());
			preparedStatement.setInt(3, role.getId());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int delete(int roleID) {
		final String QUERY = "DELETE FROM roles WHERE id = ?"; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, roleID);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
