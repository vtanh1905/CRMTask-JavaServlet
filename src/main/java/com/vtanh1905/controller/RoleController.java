package com.vtanh1905.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtanh1905.config.PathConfig;
import com.vtanh1905.entity.Role;
import com.vtanh1905.service.RoleService;

@WebServlet(name = "roleController", urlPatterns = { PathConfig.ROLE, PathConfig.ROLE_ADD, PathConfig.ROLE_EDIT,
		PathConfig.ROLE_REMOVE })
public class RoleController extends HttpServlet {

	private RoleService roleService;

	public RoleController() {
		roleService = new RoleService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();

		switch (PATH) {
		case PathConfig.ROLE:
			req.setAttribute("roles", roleService.findAll());
			req.getRequestDispatcher("/WEB-INF/views/role/index.jsp").forward(req, resp);
			return;
		case PathConfig.ROLE_ADD:
			req.getRequestDispatcher("/WEB-INF/views/role/add.jsp").forward(req, resp);
			return;
		case PathConfig.ROLE_EDIT:
			req.setAttribute("role", roleService.findById(Integer.parseInt(req.getParameter("id"))));
			req.getRequestDispatcher("/WEB-INF/views/role/edit.jsp").forward(req, resp);
			return;
		case PathConfig.ROLE_REMOVE:
			int result = roleService.delete(Integer.parseInt(req.getParameter("id")));
			if(result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.getRequestDispatcher("/WEB-INF/views/role/index.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.ROLE);	
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();
		int result;
		switch (PATH) {
		case PathConfig.ROLE_ADD:
			Role roleSave = new Role(req.getParameter("name"), req.getParameter("description"));
			result = roleService.save(roleSave);
			if(result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.setAttribute("role", roleSave);
				req.getRequestDispatcher("/WEB-INF/views/role/add.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.ROLE);
			return;
		case PathConfig.ROLE_EDIT:
			Role roleEdit = new Role(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("description"));
			result = roleService.update(roleEdit);
			if(result == -1) {
				req.setAttribute("messageError", "Lỗi! Vui lòng kiểm tra lại.");
				req.setAttribute("role", roleEdit);
				req.getRequestDispatcher("/WEB-INF/views/role/edit.jsp").forward(req, resp);
				return;
			}
			resp.sendRedirect(req.getContextPath() + PathConfig.ROLE);
			return;
		}
	}

}
