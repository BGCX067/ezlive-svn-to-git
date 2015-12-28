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
<title>Submit a reference : step 2</title>
<link
	rel="SHORTCUT ICON"
	href="./images/icone.png" />
<link
	rel="stylesheet"
	type="text/css"
	media="screen"
	href="./css/satLive-screen.css" />
</head>
<body>
<jsp:include
	flush="true"
	page="header.jsp" />
<div class="contenuPage">
<h2>Subscription to the SAT Live! notification list : step 2</h2>
<h3>Please check your informations below :</h3>
<p class="${className}">${resName}</p>
<p class="${classEmail}">${resEmail}</p>
<p class="${classHomepage}">${resHomepage}</p>
<p>${resAffiliation}</p>
<p>${resPays}</p>
<p>${resInfo}</p>
<p>${resDisplay}</p>
<form
	action="${actionForm}"
	method="post"><input
	type="submit"
	value="${valueBtn}" /></form>
<jsp:include
	flush="true"
	page="html-files/footer.html" /></div>
<div id="colonneDroite"><jsp:include
	flush="true"
	page="html-files/menu.html" /><jsp:include page="countdown.jsp" /></div>
</body>
</html>
