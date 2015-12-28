<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<%@ taglib
	uri="http://klups.apache.org/"
	prefix="kl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1" />
<link
	rel="stylesheet"
	type="text/css"
	media="screen"
	href="./css/satLive-screen.css" />
<link
	rel="SHORTCUT ICON"
	href="./images/icone.png" />
<title>SAT Live!</title>
<script
	type="text/javascript"
	src="./JS/changeImage.js"></script>
</head>
<body>
<jsp:include
	flush="true"
	page="header.jsp" />

<div class="contenuPage">
<%@ include file="./html-files/preamble.html" %>
<div>
<h2>Last 10 new entries</h2>
<div id="listingNews">
<p class="center">${nbNews} elements available</p>
<kl:listeLastNews>
	<div class="news">
	<table
		id="news${idNews}"
		class="news"
		style="empty-cells:show">
		<tr>
			<td style="width:17px"><img
				src="./images/field/topleft.gif"
				alt="" /></td>
			<td
				style="width:50px"
				class="field_top"></td>
			<td
				colspan="2"
				class="field_top"></td>
			<td style="width:17px"><img
				src="./images/field/topright.gif"
				alt="" /></td>
		</tr>
		<tr style="background:#cfc">
			<td class="field_left"></td>
			<td colspan="3">
			<table style="width:100%">
				<tr>
					<th>
					<p>[${hits} visits] ${reference}</p>
					</th>
					<td
						rowspan="2"
						onclick="javascript:scrollNews('${idNews}')"
						style="width:30px;cursor:pointer"><img
						id="fleche${idNews}"
						src="./images/field/empty.gif"
						alt="" /></td>
				</tr>
				<tr>
					<td>
					<p class="italic">Added by ${author} on ${date}</p>
					<p style="text-align:justify">Keywords : <kl:keywordsNews>
						<a href="keywords.jsp?kwd=${idKeyword}">${keyword}</a>
					</kl:keywordsNews></p>
					</td>
				</tr>
			</table>
			</td>
			<td class="field_right"></td>
		</tr>
		<tr>
			<td><img
				src="./images/field/bottomleft.gif"
				alt="" /></td>
			<td><img
				src="./images/field/bottom.gif"
				style="height:17px;width:100%"
				alt="" /></td>
			<td colspan="2"><img
				src="./images/field/empty.gif"
				style="height:17px;width:100%"
				alt="" /></td>
			<td><img
				src="./images/field/right.gif"
				style="width:17px;height:17px"
				alt="" /></td>
		</tr>
		<tr>
			<td colspan="2"></td>
			<td
				class="field_left"
				style="width:17px"></td>
			<td style="background:#cfc">
			<div style="overflow-x: auto"><c:choose>
				<c:when test="${empty comment}">&nbsp</c:when>
				<c:otherwise>${comment}</c:otherwise>
			</c:choose></div>
			</td>
			<td class="field_right"></td>
		</tr>
		<tr>
			<td colspan="2"></td>
			<td><img
				src="./images/field/bottomleft.gif"
				alt="" /></td>
			<td class="field_bottom"></td>
			<td><img
				src="./images/field/bottomright.gif"
				alt="" /></td>
		</tr>
	</table>
	<script type="text/javascript">scrollNews('${idNews}')</script></div>
</kl:listeLastNews></div>
<p class="toRight"><a href="satnews.jsp">More ...</a></p>
</div>
<jsp:include
	flush="true"
	page="html-files/footer.html" /></div>
<div id="colonneDroite"><jsp:include
	flush="true"
	page="html-files/menu.html" /><jsp:include page="countdown.jsp" /></div>
</body>
</html>
