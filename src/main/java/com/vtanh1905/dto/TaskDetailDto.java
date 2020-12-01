package com.vtanh1905.dto;

import java.sql.Timestamp;

import com.vtanh1905.entity.Task;

public class TaskDetailDto extends Task {
	private String user_fullname;
	private String job_name;
	private Timestamp job_start_date;
	private Timestamp job_end_date;
	private String status_name;
	
	public TaskDetailDto(String name, Timestamp start_date, Timestamp end_date, int user_id, int job_id, int status_id,
			String user_fullname, String job_name, Timestamp job_start_date, Timestamp job_end_date,
			String status_name) {
		super(name, start_date, end_date, user_id, job_id, status_id);
		this.user_fullname = user_fullname;
		this.job_name = job_name;
		this.job_start_date = job_start_date;
		this.job_end_date = job_end_date;
		this.status_name = status_name;
	}
	
	public TaskDetailDto(int id ,String name, Timestamp start_date, Timestamp end_date, int user_id, int job_id, int status_id,
			String user_fullname, String job_name, Timestamp job_start_date, Timestamp job_end_date,
			String status_name) {
		super(id, name, start_date, end_date, user_id, job_id, status_id);
		this.user_fullname = user_fullname;
		this.job_name = job_name;
		this.job_start_date = job_start_date;
		this.job_end_date = job_end_date;
		this.status_name = status_name;
	}
	
	public String getUser_fullname() {
		return user_fullname;
	}
	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public Timestamp getJob_start_date() {
		return job_start_date;
	}
	public void setJob_start_date(Timestamp job_start_date) {
		this.job_start_date = job_start_date;
	}
	public Timestamp getJob_end_date() {
		return job_end_date;
	}
	public void setJob_end_date(Timestamp job_end_date) {
		this.job_end_date = job_end_date;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	
	
}
