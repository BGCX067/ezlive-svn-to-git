package filtres;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import database.DataBaseUser;

public class FiltreUser2Display implements Filter {
	private FilterConfig config;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (config.getServletContext().getAttribute("users2display") == null) {
			initUsers();
		}
		chain.doFilter(request, response);
	}

	private void initUsers() {
		ArrayList users = new DataBaseUser().tabUser2Display();
		config.getServletContext().setAttribute("users2display", users);
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}
}
