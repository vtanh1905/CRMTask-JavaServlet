package com.vtanh1905.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtanh1905.entity.Job;
import com.vtanh1905.repository.JobRepository;
import com.vtanh1905.utils.JDBCConnection;

public class JobService {
	private JobRepository jobRepository;
	
	public JobService() {
		jobRepository = new JobRepository();
	}
	
	public List<Job> findAll() {
		return jobRepository.findAll();
	}
	
	public Job findById(int jobId) {
		return jobRepository.findById(jobId);
	}
		
	public int save(Job job) {
		if(job.getStart_date().compareTo(job.getEnd_date()) >= 0) {
			return -1;
		}
		
		return jobRepository.save(job);
	}
	
	public int update(Job job) {
		if(job.getStart_date().compareTo(job.getEnd_date()) >= 0) {
			return -1;
		}
		
		return jobRepository.update(job);
	}
	
	public int delete(int jobId) {
		return jobRepository.delete(jobId);
	}
}
