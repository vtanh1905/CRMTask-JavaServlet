package com.vtanh1905.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtanh1905.config.PathConfig;
import com.vtanh1905.dto.TaskDetailDto;
import com.vtanh1905.entity.Task;
import com.vtanh1905.entity.User;
import com.vtanh1905.service.ProfileService;

@WebServlet(name = "profileController", urlPatterns = { PathConfig.PROFILE, PathConfig.PROFILE_EDIT })
public class ProfileController extends HttpServlet {

	private ProfileService profileService;

	public ProfileController() {
		profileService = new ProfileService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();
		User userLogin = (User) req.getSession().getAttribute("userLogin");
		switch (PATH) {
		case PathConfig.PROFILE:
			List<TaskDetailDto> tasks = profileService.getTasksOfUser(userLogin.getId());
			req.setAttribute("listAmountStatusTask", profileService.getListAmountTaskByStatusId(tasks));
			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher("/WEB-INF/views/profile/index.jsp").forward(req, resp);
			break;
		case PathConfig.PROFILE_EDIT:
			TaskDetailDto task = profileService.getTask(Integer.parseInt(req.getParameter("id")), userLogin.getId());
			req.setAttribute("task", task);
			req.getRequestDispatcher("/WEB-INF/views/profile/edit.jsp").forward(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String PATH = req.getServletPath();
		User userLogin = (User) req.getSession().getAttribute("userLogin");
		switch (PATH) {
		case PathConfig.PROFILE_EDIT:
			profileService.updateStatus(Integer.parseInt(req.getParameter("id")), userLogin.getId(),
					Integer.parseInt(req.getParameter("status_id")));
			resp.sendRedirect(req.getContextPath() + PathConfig.PROFILE);
			break;
		}
	}
}
