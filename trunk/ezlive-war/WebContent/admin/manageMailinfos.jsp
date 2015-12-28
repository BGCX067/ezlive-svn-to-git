<%@ taglib
	uri="http://klups.apache.org/"
	prefix="kl"%>
<div class="chapitre">
<h4>Broadcast a mail</h4>
<p>In this section, you can broadcast a mail including latest news to people who have wanted to
be notified</p>
<kl:prepareMail></kl:prepareMail>
<form
	method="post"
	action="BroadcastMail">
<div><textarea
	name="content"
	rows="40"
	cols="140">${content}</textarea></div>
<div>
<p>Here are people who will receive your mail</p>
<textarea
	name="destinataires"
	rows="20"
	cols="140">${mailingList}</textarea></div>
<p><input
	type="submit"
	value="Send mail" /></p>
</form>
</div>
