package com.vtanh1905.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtanh1905.config.PathConfig;
import com.vtanh1905.entity.User;
import com.vtanh1905.service.RoleService;
import com.vtanh1905.service.TaskService;
import com.vtanh1905.service.UserService;

@WebServlet(name = "userController", urlPatterns = { PathConfig.USER, PathConfig.USER_ADD, PathConfig.USER_EDIT,
		PathConfig.USER_REMOVE, PathConfig.USER_DETAIL })
public class UserController extends HttpServlet {

	private RoleService roleService;
	private UserService userService;
	private TaskService	taskService;

	public UserController() {
		roleService = new RoleService();
		userService = new UserService();
		taskService = new TaskService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();

		switch (PATH) {
		case PathConfig.USER:
			req.setAttribute("users", userService.findAllWithRole());
			req.getRequestDispatcher("/WEB-INF/views/user/index.jsp").forward(req, resp);
			return;
		case PathConfig.USER_ADD:
			req.setAttribute("roles", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(req, resp);
			return;

		case PathConfig.USER_EDIT:
			req.setAttribute("roles", roleService.findAll());
			req.setAttribute("user", userService.findById(Integer.parseInt(req.getParameter("id"))));
			req.getRequestDispatcher("/WEB-INF/views/user/edit.jsp").forward(req, resp);
			return;
		case PathConfig.USER_REMOVE:
			int result = userService.delete(Integer.parseInt(req.getParameter("id")));
			if (result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.getRequestDispatcher("/WEB-INF/views/user/index.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.USER);
			return;
		case PathConfig.USER_DETAIL:
			req.setAttribute("tasksOfUser", taskService.getListTaskOfUser(Integer.parseInt(req.getParameter("id"))));
			req.getRequestDispatcher("/WEB-INF/views/user/detail.jsp").forward(req, resp);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();
		User user;
		int result;
		switch (PATH) {
		case PathConfig.USER_ADD:
			user = new User(req.getParameter("email"), req.getParameter("password"), req.getParameter("fullname"),
					req.getParameter("avatar"), Integer.parseInt(req.getParameter("role_id")));
			result = userService.save(user);
			if (result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.setAttribute("user", user);
				req.setAttribute("roles", roleService.findAll());
				req.getRequestDispatcher("/WEB-INF/views/user/add.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.USER);
			return;
		case PathConfig.USER_EDIT:
			String oldPassowrd = req.getParameter("oldPassword");
			String newPassword = req.getParameter("password");
			newPassword = newPassword.equals("") ? oldPassowrd : newPassword;
			user = new User(Integer.parseInt(req.getParameter("id")), req.getParameter("email"),
					newPassword, req.getParameter("fullname"), req.getParameter("avatar"),
					Integer.parseInt(req.getParameter("role_id")));
			result = userService.update(user, !oldPassowrd.equals(newPassword));
			if (result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.setAttribute("user", user);
				req.setAttribute("roles", roleService.findAll());
				req.getRequestDispatcher("/WEB-INF/views/user/edit.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.USER);
			return;
		}

	}
}
