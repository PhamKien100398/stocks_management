package project.com.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import project.com.model.Menu;
import project.com.model.Users;

public class FilterSystem implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		Users users = (Users) request.getSession().getAttribute("user");
		if (users == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		if (users != null) {
			String url = request.getServletPath();
			if (!checkUrl(url, users)) {
				response.sendRedirect(request.getContextPath() + "/access-denied");
				return false;
			}
		}
		return true;
	}

	public boolean checkUrl(String url, Users user) {
		if (url.contains("/index") || url.contains("/logout") || url.contains("/access-denied")) {
			return true;
		}
		for (Menu menu : user.getMenus()) {
			if (url.contains(menu.getUrl())) {
				return true;
			}
		}
		return false;
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
