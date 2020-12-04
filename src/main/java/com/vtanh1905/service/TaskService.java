package com.vtanh1905.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.dto.AmountOfTaskBelongStatus;
import com.vtanh1905.dto.ListTaskOfUserDto;
import com.vtanh1905.dto.TaskAndUserDto;
import com.vtanh1905.dto.TaskDetailDto;
import com.vtanh1905.entity.Task;
import com.vtanh1905.entity.User;
import com.vtanh1905.repository.TaskRepository;
import com.vtanh1905.utils.JDBCConnection;

public class TaskService {
	private TaskRepository taskRepository;
	private UserService userService;
	
	public TaskService() {
		taskRepository = new TaskRepository();
		userService = new UserService();
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
	
	public List<Task> findByUserId(int userId) {
		return taskRepository.findByUserId(userId);
	}
	
	public ListTaskOfUserDto getListTaskOfUser(int userId) {
		List<Task> lists = this.findByUserId(userId);
		List<Task> tasksNotDo = new ArrayList<Task>();
		List<Task> tasksDoing = new ArrayList<Task>();
		List<Task> tasksDone = new ArrayList<Task>();
		
		for(Task task : lists) {
			int statusType = task.getStatus_id();
			switch (statusType) {
			case 1:
				tasksNotDo.add(task);
				break;
			case 2:
				tasksDoing.add(task);
				break;
			case 3:
				tasksDone.add(task);
				break;
			}
		}
		
		return new ListTaskOfUserDto(userService.findById(userId), tasksNotDo, tasksDoing, tasksDone);
	}
	
	public List<TaskAndUserDto> findByJobId(int jobId) {
		return taskRepository.findByJobId(jobId);
	}
	
	public List<ListTaskOfUserDto> getListTaskOfUsersInJob(List<TaskAndUserDto> listTask){
		List<ListTaskOfUserDto> lists = new ArrayList<ListTaskOfUserDto>();
		List<TaskAndUserDto> listTaskInJob = listTask;
		int len = listTaskInJob.size();
		if(len > 0) {
			ListTaskOfUserDto temp = new ListTaskOfUserDto();
			User user = new User();
			user.setId(listTaskInJob.get(0).getUser_id());
			user.setFullname(listTaskInJob.get(0).getUser_fullname());
			user.setAvatar(listTaskInJob.get(0).getUser_avatar());
			temp.setUser(user);
			for (int i = 0; i < len; i++) {
				if(temp.getUser().getId() == listTaskInJob.get(i).getUser_id()) {
					int statusType = listTaskInJob.get(i).getStatus_id();
					if(statusType == 1) {
						temp.getTasksNotDo().add(listTaskInJob.get(i));
					}else if(statusType == 2) {
						temp.getTasksDoing().add(listTaskInJob.get(i));
					}else {
						temp.getTasksDone().add(listTaskInJob.get(i));
					}
				}else {
					lists.add(temp);
					temp = new ListTaskOfUserDto();
					user = new User();
					user.setId(listTaskInJob.get(i).getUser_id());
					user.setFullname(listTaskInJob.get(i).getUser_fullname());
					user.setAvatar(listTaskInJob.get(i).getUser_avatar());
					temp.setUser(user);
					--i;
				}
			}
			lists.add(temp);
		}
		return lists;
	}
	
	public List<Integer> getListAmountTaskByStatusId(List<TaskAndUserDto> listTask){
		List<Integer> listAmout = new ArrayList<Integer>();
		Integer countNotDo, countDoing, countDone;
		countNotDo = countDoing = countDone = 0;
		for(TaskAndUserDto task : listTask) {
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
