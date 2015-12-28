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
	rel="stylesheet"
	type="text/css"
	media="screen"
	href="./css/satLive-screen.css" />
<link
	rel="SHORTCUT ICON"
	href="./images/icone.png" />
<title>About SAT-Live!</title>
</head>
<body>
<jsp:include
	flush="true"
	page="header.jsp" />
<div class="contenuPage">

<div class="chapitre">
<h2>What is SAT Live!?</h2>
<div class="paragraphe">
<p>This site is a dynamic version of <a
	class="obsolete"
	href="http://cafe.newcastle.edu.au/daniel/SAT">the SAT page I manually maintained</a>. Its aim is
to provide up-to-date links concerning the research on the SATisfiability problem. If you are
working in this area, please feel free to add a link to an article, a web page or software available
on the net. The information will be available as soon as you add it: there is no moderator.</p>
</div>
<div class="paragraphe">
<p>You can find more explanations <a href="http://www.satlive.org/satlive.html">here</a> (<a
	href="http://www.satlive.org/satlive.ps">postscript version</a>, <a
	href="http://www.satlive.org/satlive.pdf">pdf version</a>).</p>
</div>
<div class="paragraphe">
<p>Please note that this site is still under development. Your <a
	href="mailto:daniel@satlive.org">comments and feedback</a> are welcome.</p>
</div>
</div>

<div class="chapitre">
<h2>Credits</h2>
<div class="paragraphe">
<p>I would like to thanks all the users of SAT Live!, particularily:</p>
</div>
<div class="paragraphe">
<ul>
	<li>Andrew Slater, for his comments from the very first versions of the site, and his help
	concerning my english ;-=).</li>
	<li><a href="http://www.cs.cornell.edu/home/selman/">Bart Selman</a>, to have given some
	credibility to the site by proposing some links at an early stage of the site.</li>
	<li><a
		class="obsolete"
		href="http://sat.inesc-id.pt/Redirect/jpms-warning.html/">Joao Marques Silva</a>, who has
	advertised the site on his personal SAT page from its very first version.</li>
	<li><a href="http://www.lri.fr/~simon/">Laurent Simon</a>, to have created SAT-Ex, the site
	that gave me the idea to create SAT Live!.</li>
	<li>The very first users, there is always some trouble when a new site/software/product... is
	released.</li>
</ul>
</div>
<div class="paragraphe">
<p>I would also thanks the person who makes this possible, <a
	href="http://ebusiness.newcastle.edu.au/maryanne/">Mary-Anne Williams</a>.</p>
</div>
</div>

<div class="chapitre">
<h2>What is behind SAT Live!?</h2>
<div class="paragraphe">
<p>SAT Live! is a site mainly written thanks to <a href="http://java.sun.com/products/jsp/">Java
Server Pages (JSP)</a> technology, a Java-based scripting framework for Dynamic HTML.</p>
</div>
<div class="paragraphe">
<p>SAT Live! is running on a <a href="http://www.linux.org/">Linux</a> box (PIII500, 128 Mo). It
uses <a href="http://httpd.apache.org/">Apache</a> web server, plus <a
	href="http://jakarta.apache.org/">Tomcat</a> to handle JSP pages. The JVM used is <a
	href="http://java.sun.com/j2se/1.3/index.jsp">Sun J2SE</a>.</p>
</div>
<div class="paragraphe">
<p>Data are stored in a <a href="http://www.hughes.com.au/">mini-SQL database</a>, linked to
Java thanks to the <a
	class="obsolete"
	href="http://www.imaginary.com/Java/Soul/">Imaginary mSQL JDBC driver</a>.</p>
</div>
<div class="paragraphe">
<p>To map database records to objects, I also use <a
	href="http://freespace.virgin.net/joe.carter/TableGen/index.html">TableGen</a> and <a
	href="http://www.ewin.org/~bret/java/">Brett Ewin database pooling package</a>.</p>
</div>
<div class="paragraphe">
<p>The statistics of the site are provided thanks to <a href="http://www.analog.cx/">Analog
software</a>.</p>
</div>
<div class="paragraphe">
<p>The forums are provided thanks to <a href="http://www.jivesoftware.com/jive/index.jspa">Jive
open source software</a>.</p>
</div>
</div>

<div class="chapitre">
<h2>History</h2>
<ul>
	<li>1 august 2001: major changes. The site is now using caching techniques to display
	information quicker. New features have also been added: SATBIB search, click on keywords displays
	the list of all links containing this keyword, same thing for the reference type.</li>
	<li>19 june 2001: added JavaScript commands to display the URL of the link on the browser
	status bar (thanks to Tim Leonard for the suggestion).</li>
	<li>24 april 2001: added a web page for the SATBIB project.</li>
	<li>28 february 2001: changed a bit SAT Live! design.</li>
	<li>December 2000: updated SAT Live! server. Now the sive is much more stable.</li>
	<li>8 november 2000: Changed a bit the internal design of jsp files to enable as much as
	possible to re-use the files. The hits and promote counters now work with the link id instead of
	the url: if two links were sharing the same url, the first one was getting all the hits :(. It is
	now fixed (it happenned only once). Added the <a
		class="obsolete"
		href="forums.jsp">forums</a> feature.</li>
	<li>25 october 2000: Added a different color for software links. The site is now using a style
	sheet for these colors. If you do not like them, your propositions are welcome ;-=) Also added the
	3 most visited entries of the past month.</li>
	<li>2-3 october 2000: the site was unreachable after the server was rebooted :-(. Sorry for
	that.</li>
	<li>26 setember 2000: changed the <a href="index.jsp">home page</a> of SAT Live!. Now only the
	5 most recent links and the 3 most visited links are displayed. Promote link feature also added.</li>
	<li>12 september 2000: <a href="images/satlive-title.png">logo</a> modified, <a
		href="stats.jsp">stats</a> and this page added.</li>
	<li>8 september 2000: www.satlive.org is launched.</li>
</ul>
</div>

<div class="chapitre">
<h2>FAQ</h2>
<div class="sschapitre">
<h3>SAT Live! should provide up-to-date links for SAT. It just gives access to papers!</h3>
<div class="paragraphe">
<p>SAT Live! manage links, ie an information of the form (title,URL,comment). It is true that
for the moment (3rd october 2K), the links are mainly papers, but there is already one about an
incoming conference, another to a new benchmark, one for a solver, one to a project ... There is no
restriction about the nature of the link.</p>
</div>
</div>

<div class="sschapitre">
<h3>What does the 'hits' column mean?</h3>
<div class="paragraphe">
<p>It is the number of times a given links has been accessed through SAT Live! site or the SAT
Live! newsletter. If you take a look to the URL used in the site or the newsletter, they do not go
directly to the link, but to a hits.jsp file which counts each access. This information is common in
dynamic sites.</p>
</div>
</div>

<div class="sschapitre">
<h3>Is SAT Live! a site dedicated to advertise AI work?</h3>
<div class="paragraphe">
<p>No! SAT Live! has been designed as a way to easily share up-to-date links around the
SATisfaction problem. It has been designed in a pure anarchical mind: everybody can submit a link,
there is no moderator. If you think you have an interesting link to propose, please feel free to
contribute to SAT Live!</p>
<p>By the way, when everything will be setup properly, the site should live by himself, using
agent technology to send new links notification, error management, etc...</p>
<p>If you are interested to create the same kind of site for your own research area, please feel
free to <a href="mailto:daniel@satlive.org">contact me</a>.</p>
</div>
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
