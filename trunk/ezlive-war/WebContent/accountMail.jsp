<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script
	type="text/javascript"
	src="./JS/changeImage.js"></script>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=UTF-8" />
<link
	rel="SHORTCUT ICON"
	href="./images/icone.png" />
<link
	rel="stylesheet"
	type="text/css"
	media="screen"
	href="./css/satLive-screen.css" />
<title>Confirmation Mail</title>
</head>
<body>
<jsp:include
	flush="true"
	page="header.jsp" />
<div class="contenuPage">
<p>Congratulations !</p>
<p>The administrator just send you an email.</p>
<p>In order to validate your subscription please confirm by clicking the link within.</p>
<form action="index.jsp"><input
	type="submit"
	value="Back to the index" /></form>

<jsp:include
	flush="true"
	page="html-files/footer.html" /></div>
<div id="colonneDroite"><jsp:include
	flush="true"
	page="html-files/menu.html" /><jsp:include page="countdown.jsp" /></div>
</body>
</html>
