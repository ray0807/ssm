package com.balloon.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.balloon.constant.Constants;

public class AuthCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String authKey = (String) request.getParameter(Constants.AUTH_KEY);
//		if (authKey == null) {
//			// 没有authkey
//			String path = request.getContextPath();
//			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//					+ path + "/";
//			request.setAttribute("domain", basePath);
//			request.setAttribute(Constants.AUTH_KEY_TAG, Constants.AUTH_KEY_TOKEN);
//			request.setAttribute(Constants.AUTH_KEY, Constants.AUTH_KEY_DEFAULT);
//			RequestDispatcher dis = request.getRequestDispatcher("/auth.do");
//			// dis.forward(request, response);
//			dis.include(request, response);
//			return false;
//		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
