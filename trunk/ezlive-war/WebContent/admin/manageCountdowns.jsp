<%@ taglib
	uri="http://klups.apache.org/"
	prefix="kl"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<div class="chapitre">
<h2>Countdowns management</h2>

<c:choose>
	<c:when test="${idEditEvent != null}">
		<div class="chapitre">
		<h4>Edit this countdown</h4>
		<form
			method="post"
			action="ModifyEvent">
		<kl:anEvent>
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
						<tr>
							<th>Name</th>
							<td><input
								type="text"
								class="saisie"
								name="name"
								value="${name}" /></td>
						</tr>
						<tr>
							<th>URL</th>
							<td><input
								type="text"
								class="saisie"
								name="url"
								value="${url}" /></td>
						</tr>
						<tr>
							<th>Date</th>
							<td><input
								type="text"
								class="saisie"
								name="date"
								value="${date}" /></td>
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
		</kl:anEvent>
		<p><input
			name="btn"
			type="submit"
			value="Modify this countdown" /><input
			name="btn"
			type="submit"
			value="Cancel" /></p>
		</form>
		</div>
	</c:when>
	<c:when test="${idEditEvent == null}">
		<div class="chapitre">
		<h4>Delete or edit some countdowns</h4>
		<form
			method="post"
			action="Manage_Events">
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
					<tr>
						<th><img
							src="./images/admin/delete.png"
							alt="Del" /></th>
						<th><img
							src="./images/admin/edit.png"
							alt="Edit" /></th>
						<th>ID</th>
						<th>Name</th>
						<th>URL</th>
						<th>Date</th>
					</tr>
					<kl:mngEvents>
						<tr class="${typeLigne}">
							<td><input
								type="checkbox"
								name="box${idEvent}" /></td>
							<td><input
								type="radio"
								name="radio"
								value="radio${idEvent}" /></td>
							<td>${idEvent}</td>
							<td>${name}</td>
							<td>${url}</td>
							<td>${date}</td>
						</tr>
						<td class="field_right"></td>
					</kl:mngEvents>
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

		<div class="chapitre">
		<h4>Add a new countdown</h4>
		<form
			method="post"
			action="AddEvent">
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
						<th>Name</th>
						<td>
						<p><input
							class="saisie"
							type="text"
							name="name" /></p>
						</td>
					</tr>
					<tr class="paire">
						<th>URL</th>
						<td>
						<p><input
							class="saisie"
							type="text"
							name="url" /></p>
						</td>
					</tr>
					<tr class="paire">
						<th>Date</th>
						<td>
						<p><input
							class="saisie"
							type="text"
							name="date" /></p>
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
