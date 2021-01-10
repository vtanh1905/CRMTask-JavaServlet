package com.vtanh1905.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.dto.TaskAndUserDto;
import com.vtanh1905.dto.TaskDetailDto;
import com.vtanh1905.entity.Task;
import com.vtanh1905.repository.TaskRepository;
import com.vtanh1905.utils.JDBCConnection;

public class ProfileService {
	private TaskRepository taskRepository;
	
	public ProfileService() {
		taskRepository = new TaskRepository();
	}
	
	public List<TaskDetailDto> getTasksOfUser(int userId) {
		return taskRepository.findAllDetailByUserId(userId);
	}
	
	public TaskDetailDto getTask(int taskId, int userId) {
		return taskRepository.findAllDetailByIdAndUserId(taskId, userId);
	}
	
	public int updateStatus(int taskId, int userId, int statusId) {
		return taskRepository.updateStatus(taskId, userId, statusId);
	}
	
	public List<Integer> getListAmountTaskByStatusId(List<TaskDetailDto> listTask){
		List<Integer> listAmout = new ArrayList<Integer>();
		Integer countNotDo, countDoing, countDone;
		countNotDo = countDoing = countDone = 0;
		for(TaskDetailDto task : listTask) {
			if(task.getStatus_id() == 1) {
				++countNotDo;
			}else if(task.getStatus_id() == 2) {
				++countDoing;
			}else {
				++countDone;
			}
		}
		listAmout.add(countNotDo);
		listAmout.add(countDoing);
		listAmout.add(countDone);
		return listAmout;
	}
}
