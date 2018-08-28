package com.energyman.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginHandlerInterceptor implements HandlerInterceptor{

	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestPath = request.getServletPath();
		if(requestPath.startsWith("/superadmin/signin")||requestPath.startsWith("/superadmin/toLogin")){
			return true;
		}
		if(requestPath.startsWith("/admin/css")||requestPath.startsWith("/admin/img")||requestPath.startsWith("/admin/font")||requestPath.startsWith("/admin/js")){
			return true;
		}
		if (request.getSession().getAttribute("user") != null) {
			return true;
		}
		System.out.println(request.getContextPath());
		response.sendRedirect(request.getContextPath() + "/superadmin/signin");
		return false;
	}

	
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	 
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
