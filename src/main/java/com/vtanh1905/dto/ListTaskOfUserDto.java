package com.vtanh1905.dto;

import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.entity.Task;
import com.vtanh1905.entity.User;

public class ListTaskOfUserDto {
	private User user;
	private List<Task> tasksNotDo;
	private List<Task> tasksDoing;
	private List<Task> tasksDone;
	
	public ListTaskOfUserDto() {
		user = new User();
		tasksNotDo = new ArrayList<Task>();
		tasksDoing = new ArrayList<Task>();
		tasksDone = new ArrayList<Task>();
	}
	
	public ListTaskOfUserDto(User user, List<Task> tasksNotDo, List<Task> tasksDoing, List<Task> tasksDone) {
		super();
		this.user = user;
		this.tasksNotDo = tasksNotDo;
		this.tasksDoing = tasksDoing;
		this.tasksDone = tasksDone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Task> getTasksNotDo() {
		return tasksNotDo;
	}

	public void setTasksNotDo(List<Task> tasksNotDo) {
		this.tasksNotDo = tasksNotDo;
	}

	public List<Task> getTasksDoing() {
		return tasksDoing;
	}

	public void setTasksDoing(List<Task> tasksDoing) {
		this.tasksDoing = tasksDoing;
	}

	public List<Task> getTasksDone() {
		return tasksDone;
	}

	public void setTasksDone(List<Task> tasksDone) {
		this.tasksDone = tasksDone;
	}
	
}
