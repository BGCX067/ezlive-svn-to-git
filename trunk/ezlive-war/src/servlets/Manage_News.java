package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBaseNews;
import divers.News;

public class Manage_News extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	private static final int STEP = 50;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("btn");
		if (operation.equalsIgnoreCase("Delete")) {
			deleteUsers(request, response);
		} else if (operation.equalsIgnoreCase("Edit")) {
			modifyUsers(request, response);
		}
	}

	private void modifyUsers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = recupIndice(request);
		request.getSession().setAttribute("idEditNews", id);
		response.sendRedirect("index.jsp");
	}

	private String recupIndice(HttpServletRequest request) {
		String id = null;
		String res = request.getParameter("radio");
		if (res != null) {
			id = res.substring(5);
		}
		return id;
	}

	private void deleteUsers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String[] listeIds = recupIndices(request);
		new DataBaseNews().suppression(listeIds);
		reinitialiserNews();
		response.sendRedirect("index.jsp");
	}

	private String[] recupIndices(HttpServletRequest request) {
		ArrayList news = (ArrayList) getServletContext().getAttribute("news");
		int debut = Integer.valueOf(
				(String) request.getSession().getAttribute("debutAfficNews"))
				.intValue();
		ArrayList ids = new ArrayList();
		for (int i = debut; i < debut + STEP; ++i) {
			String res = request.getParameter("box" + i);
			if (res != null && !res.equals("")) {
				ids.add(String.valueOf(i));
			}
		}
		String realIDs = "";
		for (int i = 0; i < ids.size(); ++i) {
			int id = Integer.parseInt((String) ids.get(i));
			realIDs += " " + (String.valueOf(((News) news.get(id)).getId()));
		}
		
		return (realIDs.trim()).split(" ");
	}

	private void reinitialiserNews() {
		getServletContext().setAttribute("news", null);
		getServletContext().setAttribute("lastNews", null);
	}
}