package com.vtanh1905.dto;

import java.sql.Timestamp;

import com.vtanh1905.entity.Task;

public class TaskAndUserDto extends Task {
	private String user_fullname;
	private String user_avatar;
	
	public TaskAndUserDto(String name, Timestamp start_date, Timestamp end_date, int user_id, int job_id, int status_id,
			String user_fullname, String user_avatar) {
		super(name, start_date, end_date, user_id, job_id, status_id);
		this.user_fullname = user_fullname;
		this.user_avatar = user_avatar;
	}

	public String getUser_fullname() {
		return user_fullname;
	}

	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}

	public String getUser_avatar() {
		return user_avatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}
	
	
}
