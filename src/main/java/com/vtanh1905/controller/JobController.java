package com.vtanh1905.controller;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtanh1905.config.PathConfig;
import com.vtanh1905.dto.TaskAndUserDto;
import com.vtanh1905.entity.Job;
import com.vtanh1905.entity.Role;
import com.vtanh1905.service.JobService;
import com.vtanh1905.service.TaskService;
import com.vtanh1905.utils.DateLibrary;

@WebServlet(name = "jobController", urlPatterns = { PathConfig.JOB, PathConfig.JOB_ADD, PathConfig.JOB_EDIT,
		PathConfig.JOB_REMOVE, PathConfig.JOB_DETAIL })
public class JobController extends HttpServlet {

	private JobService jobService;
	private TaskService taskService;

	public JobController() {
		jobService = new JobService();
		taskService = new TaskService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();

		switch (PATH) {
		case PathConfig.JOB:
			req.setAttribute("jobs", jobService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/job/index.jsp").forward(req, resp);
			return;
		case PathConfig.JOB_ADD:
			req.getRequestDispatcher("/WEB-INF/views/job/add.jsp").forward(req, resp);
			return;

		case PathConfig.JOB_EDIT:
			req.setAttribute("job", jobService.findById(Integer.parseInt(req.getParameter("id"))));
			req.getRequestDispatcher("/WEB-INF/views/job/edit.jsp").forward(req, resp);
			return;
		case PathConfig.JOB_REMOVE:
			int result = jobService.delete(Integer.parseInt(req.getParameter("id")));
			if(result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.getRequestDispatcher("/WEB-INF/views/job/index.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.JOB);	
			return;
		case PathConfig.JOB_DETAIL:
			List<TaskAndUserDto> listTasks = taskService.findByJobId(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("listAmountStatusTask", taskService.getListAmountTaskByStatusId(listTasks));
			req.setAttribute("listTaskOfUsers", taskService.getListTaskOfUsersInJob(listTasks));
			req.getRequestDispatcher("/WEB-INF/views/job/detail.jsp").forward(req, resp);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();
		int result;
		Job job;
		switch (PATH) {
		case PathConfig.JOB_ADD:
			job = new Job(req.getParameter("name"),
					DateLibrary.convertSimpleDayToTimestamp(req.getParameter("start_date")),
					DateLibrary.convertSimpleDayToTimestamp(req.getParameter("end_date")));
			result = jobService.save(job);
			if(result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.setAttribute("job", job);
				req.getRequestDispatcher("/WEB-INF/views/job/add.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.JOB);
			return;
		case PathConfig.JOB_EDIT:
			job = new Job(Integer.parseInt(req.getParameter("id")) ,req.getParameter("name"),
					DateLibrary.convertSimpleDayToTimestamp(req.getParameter("start_date")),
					DateLibrary.convertSimpleDayToTimestamp(req.getParameter("end_date")));
			result = jobService.update(job);
			if(result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.setAttribute("job", job);
				req.getRequestDispatcher("/WEB-INF/views/job/edit.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.JOB);
			return;
		}
	}
}
