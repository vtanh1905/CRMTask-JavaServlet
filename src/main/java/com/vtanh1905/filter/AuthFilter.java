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
public class AuthFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		User userLogin = (User)req.getSession().getAttribute("userLogin");
		final String PATH = req.getServletPath();
		
		if(userLogin == null && !PATH.equals("/login")) {
			resp.sendRedirect(req.getContextPath() + PathConfig.LOGIN);
			return;
		}
		
		if(userLogin != null && PATH.equals("/login")) {
			resp.sendRedirect(req.getContextPath() + PathConfig.DASHBOARD);
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
	
}
