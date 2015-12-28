package filtres;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import database.DataBaseNews;

public class FiltreNews implements Filter {

	private FilterConfig config;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (config.getServletContext().getAttribute("news") == null) {
			initNews();
		}
		if (config.getServletContext().getAttribute("nbNews") == null) {
			int nb = new DataBaseNews().nbNews();
			config.getServletContext().setAttribute("nbNews",
					String.valueOf(nb));
		}
		if (config.getServletContext().getAttribute("newsEvent") == null) {
			initNewsEvent();
		}
		chain.doFilter(request, response);
	}

	private void initNewsEvent() {
		ArrayList news = new DataBaseNews().tabNews();
		config.getServletContext().setAttribute("newsEvent", news);
	}

	private void initNews() {
		ArrayList news = new DataBaseNews().tabNews();
		config.getServletContext().setAttribute("news", news);
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
