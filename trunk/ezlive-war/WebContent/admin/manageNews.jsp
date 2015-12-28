<%@ taglib
	uri="http://klups.apache.org/"
	prefix="kl"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<div class="chapitre">
<h2>News management</h2>

<c:choose>
	<c:when test="${idEditNews != null}">
		<div class="chapitre">
		<h4>Edit this news</h4>

		<form
			method="post"
			action="ModifyNews">
		<kl:aNews>
			<table>
				<tr>
					<td><img
						src="./images/field/topleft.gif"
						alt="" /></td>
					<td><img
						src="./images/field/top.gif"
						style="height:17px;width:100%"
						alt="" /></td>
					<td><img
						src="./images/field/topright.gif"
						alt="" /></td>
				</tr>
				<tr>
					<td class="field_left"></td>
					<td class="centre">
					<table class="management">
						<tr>
							<th>Title :</th>
							<td><input
								type="text"
								class="saisie"
								name="title"
								value="${title}" /></td>
						</tr>
						<tr>
							<th>URL :</th>
							<td><input
								type="text"
								class="saisie"
								name="url"
								value="${url}" /></td>
						</tr>
						<tr>
							<th>Comment :</th>
							<td><textarea
								name="comment"
								rows="20"
								cols="100">${comment}</textarea></td>
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
					<td><img
						src="./images/field/bottomright.gif"
						alt="" /></td>
				</tr>
			</table>
		</kl:aNews>
		<p><input
			type="submit"
			name="btn"
			value="Edit this news" /><input
			type="submit"
			name="btn"
			value="Cancel" /></p>
		</form>
		</div>
	</c:when>

	<c:when test="${idEditNews == null}">
		<div class="chapitre">
		<h4>Delete or edit some news</h4>

		<kl:initDebutAffichage></kl:initDebutAffichage>
		<p class="centre"><a href="MngPreviousNews"><img
			src="./images/previous.gif"
			alt="PREVIOUS" /></a><a href="MngNextNews"><img
			src="./images/next.gif"
			alt="NEXT" /></a></p>
		<p class="centre">news from n°${debutAfficNews + 1} to n°${debutAfficNews + 50}</p>
		<form
			method="post"
			action="Manage_News">
		<p><input
			type="submit"
			name="btn"
			value="Delete" /><input
			type="submit"
			name="btn"
			value="Edit" /></p>
		<table>
			<tr>
				<td><img
					src="./images/field/topleft.gif"
					alt="" /></td>
				<td><img
					src="./images/field/top.gif"
					style="height:17px;width:100%"
					alt="" /></td>
				<td><img
					src="./images/field/topright.gif"
					alt="" /></td>
			</tr>
			<tr>
				<td class="field_left"></td>
				<td>
				<table class="management">
					<tr class="impaire">
						<th><img
							src="./images/admin/delete.png"
							alt="Del" /></th>
						<th><img
							src="./images/admin/edit.png"
							alt="Edit" /></th>
						<th>ID</th>
						<th>title</th>
						<th>Comment</th>
					</tr>
					<kl:mngNews>
						<tr class="${typeLigne}">
							<td><input
								type="checkbox"
								name="box${id}" /></td>
							<td><input
								type="radio"
								name="radio"
								value="radio${idNews}" /></td>
							<td>${idNews}</td>
							<td>${reference}</td>
							<td>
							<div>${comment}</div>
							</td>
						</tr>
					</kl:mngNews>
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
				<td><img
					src="./images/field/bottomright.gif"
					alt="" /></td>
			</tr>
		</table>
		<p><input
			type="submit"
			name="btn"
			value="Delete" /><input
			type="submit"
			name="btn"
			value="Edit" /></p>
		</form>
		<p class="centre"><a href="MngPreviousNews"><img
			src="./images/previous.gif"
			alt="PREVIOUS" /></a><a href="MngNextNews"><img
			src="./images/next.gif"
			alt="NEXT" /></a></p>
		</div>
	</c:when>
</c:choose></div>
