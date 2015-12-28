<%@ taglib
	uri="http://klups.apache.org/"
	prefix="kl"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>

<div class="chapitre">
<h2>Keywords management</h2>

<c:choose>
	<c:when test="${idEditKeyword != null}">
		<div class="chapitre">
		<h4>Edit this keyword</h4>
		<form
			method="post"
			action="ModifyKeyword">
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
				<td class="fond_vert"><kl:aKeyword>
					<table class="management">
						<tr>
							<td>Keyword</td>
							<td>
							<p><input
								type="text"
								class="saisie"
								name="word"
								value="${word}" /></p>
							</td>
						</tr>
					</table>
				</kl:aKeyword></td>
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
			value="Edit this keyword" /><input
			type="submit"
			name="btn"
			value="Cancel" /></p>
		</form>
		</div>
	</c:when>

	<c:when test="${idEditKeyword == null}">
		<div class="chapitre">
		<h4>Delete or edit keywords</h4>
		<div>
		<form
			method="post"
			action="Manage_Keywords">
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
				<td class="fond_vert">
				<table>
					<tr class="impaire">
						<th><img
							src="./images/admin/delete.png"
							alt="Del" /></th>
						<th><img
							src="./images/admin/edit.png"
							alt="Edit" /></th>
						<th>ID</th>
						<th>word</th>
					</tr>
					<kl:mngKeywords>
						<tr class="${typeLigne}">
							<td width="10%"><input
								type="checkbox"
								name="box${idKey}" /></td>
							<td width="10%"><input
								type="radio"
								name="radio"
								value="radio${idKey}" /></td>
							<td width="10%">${idKey}</td>
							<td>${keyword}</td>
						</tr>
					</kl:mngKeywords>
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
		</div>
		</div>

		<div class="chapitre">
		<form
			method="post"
			action="AddKeyword">
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
					<tr class="paire">
						<th>Keyword</th>
						<td>
						<p><input
							class="saisie"
							type="text"
							name="word" /></p>
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
				<td><img
					src="./images/field/bottomright.gif"
					alt="" /></td>
			</tr>
		</table>
		<p><input
			type="submit"
			value="Add" /></p>
		</form>
		</div>
	</c:when>
</c:choose></div>
