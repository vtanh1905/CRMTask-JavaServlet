package com.vtanh1905.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.dto.UserRoleDto;
import com.vtanh1905.entity.User;
import com.vtanh1905.utils.JDBCConnection;

public class UserRepository {
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		final String QUERY = "SELECT * FROM users";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt("id"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("fullname"), resultSet.getString("avatar"),
						resultSet.getInt("role_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public List<UserRoleDto> findAllWithRole() {
		List<UserRoleDto> users = new ArrayList<UserRoleDto>();
		final String QUERY = "SELECT * FROM users u, roles r where u.role_id = r.id";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				users.add(new UserRoleDto(resultSet.getInt("id"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("fullname"), resultSet.getString("avatar"),
						resultSet.getInt("role_id"), resultSet.getString("name"), resultSet.getString("description")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User findById(int userId) {
		final String QUERY = "SELECT * FROM users where id = ? ";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return new User(resultSet.getInt("id"), resultSet.getString("email"), resultSet.getString("password"),
						resultSet.getString("fullname"), resultSet.getString("avatar"), resultSet.getInt("role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public User findByEmail(String email) {
		final String QUERY = "SELECT * FROM users where email = ? ";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return new User(resultSet.getInt("id"), resultSet.getString("email"), resultSet.getString("password"),
						resultSet.getString("fullname"), resultSet.getString("avatar"), resultSet.getInt("role_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int save(User user) {
		final String QUERY = "INSERT INTO users(email, password, fullname, avatar ,role_id) values(?, ?, ?, ?, ?)";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFullname());
			preparedStatement.setString(4, user.getAvatar());
			preparedStatement.setInt(5, user.getRole_id());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int update(User user) {
		final String QUERY = "UPDATE users SET email = ?, password = ?, fullname = ?, avatar = ?, role_id = ? WHERE id = ?";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFullname());
			preparedStatement.setString(4, user.getAvatar());
			preparedStatement.setInt(5, user.getRole_id());
			preparedStatement.setInt(6, user.getId());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int delete(int userId) {
		final String QUERY = "DELETE FROM users WHERE id = ?";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, userId);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}
}
