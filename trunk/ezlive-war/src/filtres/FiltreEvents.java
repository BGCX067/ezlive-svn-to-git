package filtres;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import database.DataBaseEvent;
import divers.Event;
import divers.MngEvent;

public class FiltreEvents implements Filter {
	private FilterConfig config;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (config.getServletContext().getAttribute("events") == null) {
			initEvents();
		}
		if (config.getServletContext().getAttribute("allEvents") == null) {
			initAllEvents();
		}
		chain.doFilter(request, response);
	}

	private void initAllEvents() {
		List<MngEvent> events = new DataBaseEvent().allEvents();
		config.getServletContext().setAttribute("allEvents", events);
	}

	private void initEvents() {
		List<Event> events = new DataBaseEvent().tabEvents();
		config.getServletContext().setAttribute("events", events);
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
