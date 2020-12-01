package com.vtanh1905.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.dto.AmountOfTaskBelongStatus;
import com.vtanh1905.dto.TaskDetailDto;
import com.vtanh1905.entity.Task;
import com.vtanh1905.repository.TaskRepository;
import com.vtanh1905.utils.JDBCConnection;

public class TaskService {
	private TaskRepository taskRepository;
	
	public TaskService() {
		taskRepository = new TaskRepository();
	}
	
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	public List<TaskDetailDto> findAllDetail() {
		return taskRepository.findAllDetail();
	}


	public Task findById(int taskId) {
		return taskRepository.findById(taskId);
	}

	public int save(Task task) {
		if(task.getStart_date().compareTo(task.getEnd_date()) >= 0) {
			return -1;
		}
		
		return taskRepository.save(task);
	}

	public int update(Task task) {
		if(task.getStart_date().compareTo(task.getEnd_date()) >= 0) {
			return -1;
		}
		
		return taskRepository.update(task);
	}

	public int delete(int taskId) {
		return taskRepository.delete(taskId);
	}
	
	public List<AmountOfTaskBelongStatus> findAmoutOfTaskBelongStatus(){
		return taskRepository.findAmoutOfTaskBelongStatus();
	}
}
