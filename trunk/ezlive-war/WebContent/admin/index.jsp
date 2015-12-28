<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib
	uri="http://klups.apache.org/"
	prefix="kl"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1" />
<link
	rel="SHORTCUT ICON"
	href="../images/icone.png" />
<link
	rel="stylesheet"
	type="text/css"
	media="screen"
	href="../css/satLive-screen.css" />
<title>Administration page</title>
</head>
<body>
<h1>Management page</h1>
<p>Please select which entities you want to manage</p>
<form
	method="post"
	action="Manager">
<table>
	<tr>
		<td><input
			name="btn"
			class="bouton"
			type="submit"
			value="Users" /></td>
		<td><input
			name="btn"
			class="bouton"
			type="submit"
			value="Keywords" /></td>
		<td><input
			name="btn"
			class="bouton"
			type="submit"
			value="News" /></td>
		<td><input
			name="btn"
			class="bouton"
			type="submit"
			value="Countdowns" /></td>
		<td><input
			name="btn"
			class="bouton"
			type="submit"
			value="Mailinfos" /></td>
	</tr>
</table>
</form>
<c:choose>
	<c:when test="${entity == 'Users'}">
		<jsp:include
			flush="true"
			page="manageUsers.jsp" />
	</c:when>
	<c:when test="${entity == 'Keywords'}">
		<jsp:include
			flush="true"
			page="manageKeywords.jsp" />
	</c:when>
	<c:when test="${entity == 'News'}">
		<jsp:include
			flush="true"
			page="manageNews.jsp" />
	</c:when>
	<c:when test="${entity == 'Countdowns'}">
		<jsp:include
			flush="true"
			page="manageCountdowns.jsp" />
	</c:when>
	<c:when test="${entity == 'Mailinfos'}">
		<jsp:include
			flush="true"
			page="manageMailinfos.jsp" />
	</c:when>
</c:choose>
</body>
</html>
