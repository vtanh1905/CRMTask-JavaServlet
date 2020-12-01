package com.vtanh1905.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtanh1905.config.PathConfig;
import com.vtanh1905.entity.Job;
import com.vtanh1905.entity.Task;
import com.vtanh1905.service.JobService;
import com.vtanh1905.service.TaskService;
import com.vtanh1905.service.UserService;
import com.vtanh1905.utils.DateLibrary;

@WebServlet(name = "taskController", urlPatterns = { PathConfig.TASK, PathConfig.TASK_ADD, PathConfig.TASK_EDIT,
		PathConfig.TASK_REMOVE })
public class TaskController extends HttpServlet {

	private UserService userService;
	private JobService jobService;
	private TaskService	taskService;

	public TaskController() {
		userService = new UserService();
		jobService = new JobService();
		taskService = new TaskService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();

		switch (PATH) {
		case PathConfig.TASK:
			req.setAttribute("tasks", taskService.findAllDetail());
			req.getRequestDispatcher("/WEB-INF/views/task/index.jsp").forward(req, resp);
			return;
		case PathConfig.TASK_ADD:
			req.setAttribute("jobs", jobService.findAll());
			req.setAttribute("users", userService.findAllByRole(3));
			req.getRequestDispatcher("/WEB-INF/views/task/add.jsp").forward(req, resp);
			return;
		case PathConfig.TASK_EDIT:
			req.setAttribute("task", taskService.findById(Integer.parseInt(req.getParameter("id"))));
			req.setAttribute("jobs", jobService.findAll());
			req.setAttribute("users", userService.findAllByRole(3));
			req.getRequestDispatcher("/WEB-INF/views/task/edit.jsp").forward(req, resp);
			return;
		case PathConfig.TASK_REMOVE:
			int result = taskService.delete(Integer.parseInt(req.getParameter("id")));
			if(result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.getRequestDispatcher("/WEB-INF/views/task/index.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.TASK);	
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();
		int result;
		Task task;
		switch (PATH) {
		case PathConfig.TASK_ADD:
			task = new Task(req.getParameter("name"),
					DateLibrary.convertSimpleDayToTimestamp(req.getParameter("start_date")),
					DateLibrary.convertSimpleDayToTimestamp(req.getParameter("end_date")),
					Integer.parseInt(req.getParameter("user_id")), Integer.parseInt(req.getParameter("job_id")), 1);
			result = taskService.save(task);
			if(result == - 1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.setAttribute("jobs", jobService.findAll());
				req.setAttribute("users", userService.findAllByRole(3));
				req.setAttribute("task", task);
				req.getRequestDispatcher("/WEB-INF/views/task/add.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.TASK);
			return;
		case PathConfig.TASK_EDIT:
			task = new Task(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),
					DateLibrary.convertSimpleDayToTimestamp(req.getParameter("start_date")),
					DateLibrary.convertSimpleDayToTimestamp(req.getParameter("end_date")),
					Integer.parseInt(req.getParameter("user_id")), Integer.parseInt(req.getParameter("job_id")), 1);
			result = taskService.update(task);
			if(result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.setAttribute("jobs", jobService.findAll());
				req.setAttribute("users", userService.findAllByRole(3));
				req.setAttribute("task", task);
				req.getRequestDispatcher("/WEB-INF/views/task/edit.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.TASK);
			
			return;
		}
	}
}
