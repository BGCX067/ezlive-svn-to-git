package filtres;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import database.DataBaseKeyWord;

public class FiltreKeyword implements Filter {
	private FilterConfig config;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (config.getServletContext().getAttribute("keywords") == null) {
			initKeywords();
		}
		chain.doFilter(request, response);
	}

	private void initKeywords() {
		ArrayList keywords = new DataBaseKeyWord().tabKeyword();
		config.getServletContext().setAttribute("keywords", keywords);		
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
}
