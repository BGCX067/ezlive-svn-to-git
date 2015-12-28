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

public class FiltreLastNews implements Filter {
	private FilterConfig config;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (config.getServletContext().getAttribute("lastNews") == null) {
			initNews();
		}
		if (config.getServletContext().getAttribute("nbNews") == null) {
			int nb = new DataBaseNews().nbNews();
			config.getServletContext().setAttribute("nbNews",
					String.valueOf(nb));
		}
		if (config.getServletContext().getAttribute("mostClicked") == null) {
			initMostClicked();
		}
		chain.doFilter(request, response);
	}

	private void initMostClicked() {
		ArrayList mostClicked = new DataBaseNews().tabMostClicked();
		config.getServletContext().setAttribute("mostClicked", mostClicked);
	}

	private void initNews() {
		ArrayList lastNews = new DataBaseNews().tabLastNews();
		config.getServletContext().setAttribute("lastNews", lastNews);
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
