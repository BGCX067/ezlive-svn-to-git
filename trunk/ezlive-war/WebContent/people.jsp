<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://klups.apache.org/"
	prefix="kl"%>
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
<title>Some people interested in SAT</title>
</head>
<body>
<jsp:include
	flush="true"
	page="header.jsp" />
<div class="contenuPage">
<div class="chapitre">
<h2>Some people interested in SAT</h2>
<p>Here is a list of people interested in SAT. To be added to this list, <a href="subscribe.jsp">just
fill out this form.</a></p>
<p class="note">(Please note that people providing a wrong e-mail address will be automatically
removed from both this list and the mailing-list.)</p>
</div>
<div id="listingPeople"><kl:nbPeople>
	<p class="center">${nbPeople} persons listed</p>
</kl:nbPeople>
<table>
	<tr>
		<td><img
			src="./images/field/topleft.gif"
			alt="" /></td>
		<td id="top"><img
			src="./images/field/top.gif"
			style="height:17px;width:100%"
			alt="" /></td>
		<td><img
			src="./images/field/topright.gif"
			alt="" /></td>
	</tr>
	<tr>
		<td class="field_left"></td>
		<td id="people">
		<table id="tabPeople">
			<tr>
				<th id="name">Name</th>
				<th id="mail">Email</th>
				<th>Affiliation</th>
				<th id="country">Country</th>
			</tr>
			<kl:listePeople>
				<tr class="${typeLigne}">
					<td>${pplname}</td>
					<td>${pplmail}</td>
					<td>${pplaffiliation}</td>
					<td>${pplcountry}</td>
				</tr>
			</kl:listePeople>
		</table>
		</td>
		<td class="field_right"></td>
	</tr>
	<tr>
		<td><img
			src="./images/field/bottomleft.gif"
			alt="" /></td>
		<td id="bottom"><img
			src="./images/field/bottom.gif"
			style="height:17px;width:100%"
			alt="" /></td>
		<td><img
			src="./images/field/bottomright.gif"
			alt="" /></td>
	</tr>
</table>
</div>
<jsp:include
	flush="true"
	page="html-files/footer.html" /></div>
<div id="colonneDroite"><jsp:include
	flush="true"
	page="html-files/menu.html" /><jsp:include page="countdown.jsp" /></div>
</body>
</html>
