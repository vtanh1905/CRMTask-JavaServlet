package com.vtanh1905.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.entity.Job;
import com.vtanh1905.utils.JDBCConnection;

public class JobRepository {
	public List<Job> findAll() {
		List<Job> jobs = new ArrayList<Job>();
		final String QUERY = "SELECT * FROM jobs"; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				jobs.add(new Job(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getTimestamp("start_date"), resultSet.getTimestamp("end_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return jobs;
	}
	
	public Job findById(int jobId) {
		final String QUERY = "SELECT * FROM jobs where id = ? "; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, jobId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				return new Job(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getTimestamp("start_date"), resultSet.getTimestamp("end_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
		
	public int save(Job job) {
		final String QUERY = "INSERT INTO jobs(name, start_date, end_date) values(?, ?, ?)"; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, job.getName());
			preparedStatement.setTimestamp(2, job.getStart_date());
			preparedStatement.setTimestamp(3, job.getEnd_date());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int update(Job job) {
		final String QUERY = "UPDATE jobs SET name = ?, start_date = ?, end_date = ?  WHERE id = ?"; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, job.getName());
			preparedStatement.setTimestamp(2, job.getStart_date());
			preparedStatement.setTimestamp(3, job.getEnd_date());
			preparedStatement.setInt(4, job.getId());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int delete(int jobId) {
		final String QUERY = "DELETE FROM jobs WHERE id = ?"; 

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, jobId);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
