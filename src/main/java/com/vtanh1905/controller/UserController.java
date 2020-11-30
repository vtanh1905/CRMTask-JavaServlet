package com.vtanh1905.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtanh1905.config.PathConfig;
import com.vtanh1905.service.RoleService;

@WebServlet(name = "userController", urlPatterns = { PathConfig.USER, PathConfig.USER_ADD, PathConfig.USER_EDIT,
		PathConfig.USER_REMOVE })
public class UserController extends HttpServlet {
	
	private RoleService roleService;
	
	public UserController() {
		roleService = new RoleService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();

		switch (PATH) {
		case PathConfig.USER:
			req.getRequestDispatcher("/WEB-INF/views/user/index.jsp").forward(req, resp);
			return;
		case PathConfig.USER_ADD:
			req.setAttribute("roles", roleService.findAll());
			
			req.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(req, resp);
			return;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();
		switch (PATH) {
		case PathConfig.USER_ADD:
			req.setAttribute("roles", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(req, resp);
			return;
		}
	}
}
