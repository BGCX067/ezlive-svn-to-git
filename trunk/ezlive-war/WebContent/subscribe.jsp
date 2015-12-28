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
	content="text/html; fcharset=ISO-8859-1" />
<link
	rel="SHORTCUT ICON"
	href="./images/icone.png" />
<link
	rel="stylesheet"
	type="text/css"
	media="screen"
	href="./css/satLive-screen.css" />
<title>Submit a reference : step 1</title>
<script type="text/javascript">
      
</script>
</head>
<body>
<jsp:include
	flush="true"
	page="header.jsp" />
<div class="contenuPage">
<h1>Subscription to the SAT Live! notification list</h1>
<h2>DUE TO RECENT HEAVY SPAMMING, REGISTRATION TO THE MAILING LIST IS CLOSED.</h2>
<p>Please send an email to daniel at satlive.org to be added to the list.</p>
<p>Please provide us with some informations about you.</p>

<form
	method="post"
	action="Inscription">
<h2>Name:</h2>
<input
	class="saisie"
	type="text"
	name="name"
	value="${name}" />
<p>It will be displayed on the site in the Contributed by field.</p>
<h2>Email</h2>
<input
	class="saisie"
	type="text"
	name="email"
	value="${email}" />
<p>Necessary: it's your identifier in the system.</p>
<h2>Homepage</h2>
<input
	class="saisie"
	type="text"
	name="homepage"
	value="${homepage}" />
<p>You can add here your homepage or your own page about SAT.</p>
<h2>Affiliation</h2>
<input
	class="saisie"
	type="text"
	name="affiliation"
	value="${affiliation}" />
<p>The name of your university, company, laboratory ...</p>
<h2>Country</h2>
<select name="pays">
	<kl:countries selected="${id}">
		<option
			value="${id}"${selected}>${pays}</option>
	</kl:countries>
</select>
<p class="checkbox"><input
	type="checkbox"
	name="info"
	value="${info}"
	checked />Send me an e-mail when new papers are added on the site.</p>

<p class="checkbox"><input
	type="checkbox"
	name="display"
	value="${display}"
	checked />This information can be displayed on the "People interested by SAT" page of the site.</p>
<input
	class="bouton"
	type="submit"
	value="Submit" /><input
	class="bouton"
	type="reset"
	value="Clear Form" /></form>
<jsp:include
	flush="true"
	page="html-files/footer.html" /></div>
<div id="colonneDroite"><jsp:include
	flush="true"
	page="html-files/menu.html" /><jsp:include page="countdown.jsp" /></div>
</body>
</html>
