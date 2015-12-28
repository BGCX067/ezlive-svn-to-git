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
	href="./images/icone.png" />
<link
	rel="stylesheet"
	type="text/css"
	media="screen"
	href="./css/satLive-screen.css" />
<script
	type="text/javascript"
	src="./JS/changeImage.js"></script>
<title>Submit a reference</title>
</head>
<body>
<c:if test="${logged == null}">
	<jsp:forward page="subscribe.jsp"></jsp:forward>
</c:if>
<jsp:include
	flush="true"
	page="header.jsp" />
<div class="contenuPage">
<h2>Submit a reference : step 1</h2>
<div class="chapitre">
<form
	method="post"
	action="Preview">
<h3>The reference</h3>
<h3>Type</h3>
<select name="typeNews">
	<kl:typesNews selected="${type}">
		<option
			value="${idType}"${selected}>${type}</option>
	</kl:typesNews>
</select>

<div class="paragraphe">
<p>Please use Announcement to announce everything related to SAT excluding the following ones:</p>
<ul>
	<li>Software should be used to announce the new release of a solver for instance,</li>
	<li>Benchmark should be used to announce a new source of benchmarks.</li>
	<li>Event should be used to announce a conference, workshop, tutorial related to SAT.</li>
</ul>
</div>

<div class="paragraphe">
<h3>Reference:</h3>
<input
	name="reference"
	type="text"
	class="saisie"
	value="${reference}"/>
<p>The complete reference of the paper, or the subject of your announcement.</p>
</div>

<div class="paragraphe">
<h3>URL:</h3>
<input
	name="url"
	type="text"
	class="saisie"
	value="${url}">
<p>A URL where the paper/software/benchmark can be downloaded.</p>
</div>

<div class="paragraphe">
<h3>Comment:</h3>
<textarea
	name="comment"
	rows="15"
	cols="90%">${comment}</textarea>
<p>A brief description of the link. Note that this comment will be displayed as HTML on the web
page, so you need to use HTML tag to end a paragraph. As a consequence, you can embed your comment
with usual HTML tags (and even add new links using HTML syntax). Since the text is also sent by
email to SAT Live! mailing list, please try to format the text such that it can also be easily read
by this way.</p>
</div>

<div class="chapitre">
<h3>Keywords</h3>
<p>Please select keywords which are related to your reference.</p>
<select
	class="moyen"
	name="listeKeywords"
	multiple="4">
	<kl:keywords>
		<option
			value="${keyword}" ${selected}>${keyword}</option>
	</kl:keywords>
</select>
<p>If you want to suggest new keywords, just type them below:</p>
<p
	class="code"
	style="font-size:80%">(Note that you must separate them by a semi-colon)</p>
<input
	class="saisie"
	name="newKeywords"
	type="text" /></div>

<div class="paragraphe">
<p>Use the preview button to check that both the text and the link are ok.</p>
<p>Be sure to have added the correct keywords</p>
<input
	class="bouton"
	type="submit"
	value="Preview"/><input
	class="bouton"
	type="reset"
	value="Clear Form"/></div>
</form>
</div>

<div class="paragraphe">
<h2>Preview</h2>
<div class="preview"><kl:date>
	<p class="entete">Added ${date} by ${author}</p>
</kl:date>${preview}</div>
</div>

<div class="paragraphe">
<form
	method="post"
	action="Poste">
<h2>Submit the reference</h2>
<p>Once the reference seems ok, be sure you have pushed the preview button${suite}</p>
</form>
</div>

<jsp:include
	flush="true"
	page="html-files/footer.html" /></div>
<div id="colonneDroite"><jsp:include
	flush="true"
	page="html-files/menu.html" /><jsp:include page="countdown.jsp" /></div>
</body>
</html>
