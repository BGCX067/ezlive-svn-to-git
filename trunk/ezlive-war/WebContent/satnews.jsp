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
<script
	type="text/javascript"
	src="./JS/changeImage.js"></script>
<link
	rel="SHORTCUT ICON"
	href="./images/icone.png" />
<link
	rel="stylesheet"
	type="text/css"
	media="screen"
	href="./css/satLive-screen.css" />
<meta
	http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1" />
<title>SAT-Live!</title>
</head>
<body>
<jsp:include
	flush="true"
	page="header.jsp" />
<div class="contenuPage">
<div>
<h2>List of references</h2>
<div id="listingNews">
<p class="center grand">${nbNews} elements available</p>
<div class="centre"><a href="BeginNews">BEGIN</a><a href="PreviousNews"><img
	src="./images/previous.gif"
	alt="PREVIOUS" /></a><a href="NextNews"><img
	src="./images/next.gif"
	alt="NEXT" /></a><a href="EndNews">END</a></div>
<kl:initDebutAffichage></kl:initDebutAffichage>
<p class="centre">News from n°${debutAffic+1} to n°${debutAffic+10}</p>
<kl:listeNews>
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
</kl:listeNews></div>
<div>
<div class="centre"><a href="BeginNews">BEGIN</a><a href="PreviousNews"><img
	src="./images/previous.gif"
	alt="PREVIOUS" /></a><a href="NextNews"><img
	src="./images/next.gif"
	alt="NEXT" /></a><a href="EndNews">END</a></div>
</div>
</div>
<jsp:include
	flush="true"
	page="html-files/footer.html" /></div>
<div id="colonneDroite"><jsp:include
	flush="true"
	page="html-files/menu.html" /><jsp:include page="countdown.jsp" /></div>
</body>
</html>
