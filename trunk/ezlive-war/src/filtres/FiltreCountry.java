package filtres;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import database.DataBaseCountry;
import divers.Country;

public class FiltreCountry implements Filter {
	private FilterConfig config;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (config.getServletContext().getAttribute("countries") == null) {
			initCountry();
		}
		chain.doFilter(request, response);
	}

	private void initCountry() {
		List<Country> countries = new DataBaseCountry().tabPays();
		config.getServletContext().setAttribute("countries", countries);
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
