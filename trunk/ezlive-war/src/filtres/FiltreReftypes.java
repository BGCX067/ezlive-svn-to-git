package filtres;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import database.DataBaseReftypes;

public class FiltreReftypes implements Filter {
	private FilterConfig config;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (config.getServletContext().getAttribute("reftypes") == null) {
			initReftypes();
		}
		chain.doFilter(request, response);
	}

	private void initReftypes() {
		ArrayList types = new DataBaseReftypes().tabReftype();
		config.getServletContext().setAttribute("reftypes", types);
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
}
