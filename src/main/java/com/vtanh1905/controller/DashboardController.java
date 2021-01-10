package com.vtanh1905.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtanh1905.config.PathConfig;
import com.vtanh1905.entity.User;
import com.vtanh1905.service.TaskService;

@WebServlet(name = "dahsboardController", urlPatterns = {PathConfig.DASHBOARD})
public class DashboardController extends HttpServlet {
	
	private TaskService taskService;
	
	public DashboardController() {
		taskService = new TaskService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setAttribute("statistic", taskService.findAmoutOfTaskBelongStatus());
		req.getRequestDispatcher("/WEB-INF/views/dashboard/index.jsp").forward(req, resp);
	}
}
