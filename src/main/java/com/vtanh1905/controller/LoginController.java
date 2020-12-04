package com.vtanh1905.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtanh1905.config.PathConfig;
import com.vtanh1905.service.LoginService;
import com.vtanh1905.service.UserService;

@WebServlet(name = "loginController", urlPatterns = {PathConfig.LOGIN} )
public class LoginController extends HttpServlet{
	
	private LoginService loginService;
	
	public LoginController() {
		loginService = new LoginService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(loginService.login(req.getParameter("email"), req.getParameter("password"), req)) {
			resp.sendRedirect(req.getContextPath() + PathConfig.DASHBOARD);
		}else {
			req.setAttribute("messageError", "Email or Password is not correct");
			req.getRequestDispatcher("/WEB-INF/views/login/index.jsp").forward(req, resp);
		}
		
	}
}
