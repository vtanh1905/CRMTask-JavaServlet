package com.vtanh1905.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtanh1905.config.PathConfig;
import com.vtanh1905.entity.User;

@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		User userLogin = (User) req.getSession().getAttribute("userLogin");
		final String PATH = req.getServletPath();

		if(PATH.startsWith("/assets")) {
			chain.doFilter(request, response);
			return;
		}
		
		// Kiểm tra user không login mà cố zo trang quản lý
		if (userLogin == null && !PATH.equals(PathConfig.LOGIN)) {
			resp.sendRedirect(req.getContextPath() + PathConfig.LOGIN);
			return;
		}

		// Kiểm tra user đã login mà cố zo trang login
		if (userLogin != null && PATH.equals(PathConfig.LOGIN)) {
			resp.sendRedirect(req.getContextPath() + PathConfig.DASHBOARD);
			return;
		}

		// Kiểm user không phải admin mà cố zo trang quản ly role và user
		if (userLogin != null && userLogin.getRole_id() != 1 && (PATH.startsWith(PathConfig.USER) || PATH.startsWith(PathConfig.ROLE))) {
			resp.sendRedirect(req.getContextPath() + PathConfig.DASHBOARD);
			return;
		}
		
		// Kiểm user không phải admin mà cố zo trang quản ly role và user
		if (userLogin != null && userLogin.getRole_id() != 3 && PATH.startsWith(PathConfig.PROFILE)) {
			resp.sendRedirect(req.getContextPath() + PathConfig.DASHBOARD);
			return;
		}
		
		if (userLogin != null && userLogin.getRole_id() == 3 && (!PATH.startsWith(PathConfig.PROFILE))) {
			resp.sendRedirect(req.getContextPath() + PathConfig.PROFILE);
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
