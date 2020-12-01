package com.vtanh1905.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.dto.AmountOfTaskBelongStatus;
import com.vtanh1905.dto.TaskDetailDto;
import com.vtanh1905.entity.Task;
import com.vtanh1905.service.TaskService;
import com.vtanh1905.utils.JDBCConnection;

public class TaskRepository {
	public List<Task> findAll() {
		List<Task> tasks = new ArrayList<Task>();
		final String QUERY = "SELECT * FROM tasks";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tasks.add(new Task(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getTimestamp("start_date"), resultSet.getTimestamp("end_date"),
						resultSet.getInt("user_id"), resultSet.getInt("job_id"), resultSet.getInt("status_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tasks;
	}

	public List<TaskDetailDto> findAllDetail() {
		List<TaskDetailDto> tasks = new ArrayList<TaskDetailDto>();
		final String QUERY = "SELECT t.*, u.fullname as 'user_fullname', j.name as 'job_name', j.start_date as 'job_start_date', j.end_date as 'job_end_date' , s.name as 'status_name' FROM tasks t, users u, jobs j, status s where t.user_id = u.id and t.job_id = j.id and t.status_id = s.id";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tasks.add(new TaskDetailDto(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getTimestamp("start_date"), resultSet.getTimestamp("end_date"),
						resultSet.getInt("user_id"), resultSet.getInt("job_id"), resultSet.getInt("status_id"),
						resultSet.getString("user_fullname"), resultSet.getString("job_name"),
						resultSet.getTimestamp("job_start_date"), resultSet.getTimestamp("job_end_date"),
						resultSet.getString("status_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tasks;
	}

	public Task findById(int taskId) {
		final String QUERY = "SELECT * FROM tasks where id = ? ";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, taskId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return new Task(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getTimestamp("start_date"), resultSet.getTimestamp("end_date"),
						resultSet.getInt("user_id"), resultSet.getInt("job_id"), resultSet.getInt("status_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int save(Task task) {
		final String QUERY = "INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id) values(?, ?, ?, ?, ?, ?)";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, task.getName());
			preparedStatement.setTimestamp(2, task.getStart_date());
			preparedStatement.setTimestamp(3, task.getEnd_date());
			preparedStatement.setInt(4, task.getUser_id());
			preparedStatement.setInt(5, task.getJob_id());
			preparedStatement.setInt(6, task.getStatus_id());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int update(Task task) {
		final String QUERY = "UPDATE tasks SET name = ?, start_date = ?, end_date = ?, user_id = ?, job_id = ?, status_id = ?  WHERE id = ?";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setString(1, task.getName());
			preparedStatement.setTimestamp(2, task.getStart_date());
			preparedStatement.setTimestamp(3, task.getEnd_date());
			preparedStatement.setInt(4, task.getUser_id());
			preparedStatement.setInt(5, task.getJob_id());
			preparedStatement.setInt(6, task.getStatus_id());
			preparedStatement.setInt(7, task.getId());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int delete(int taskId) {
		final String QUERY = "DELETE FROM tasks WHERE id = ?";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, taskId);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}
	
	public List<AmountOfTaskBelongStatus> findAmoutOfTaskBelongStatus(){
		List<AmountOfTaskBelongStatus> tasks = new ArrayList<AmountOfTaskBelongStatus>();
		final String QUERY = "SELECT s.id as 'status_id', count(t.id) as 'amount' FROM status s left join tasks t on s.id = t.status_id  group by s.id";

		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tasks.add(new AmountOfTaskBelongStatus(resultSet.getInt("status_id"), resultSet.getInt("amount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tasks;
	}
}
