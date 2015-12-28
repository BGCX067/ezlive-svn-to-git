<%@ taglib
	uri="http://klups.apache.org/"
	prefix="kl"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<div class="chapitre">
<h2>Users management</h2>

<c:choose>
	<c:when test="${idEditUser == null}">
		<div class="chapitre">
		<h4>Delete or edit some users</h4>

		<kl:initDebutAffichage></kl:initDebutAffichage>
		<div class="centre"><a href="MngPrevious"><img
			src="./images/previous.gif"
			alt="PREVIOUS" /></a><a href="MngNext"><img
			src="./images/next.gif"
			alt="NEXT" /></a></div>
		<p class="centre">Users from n°${debutAfficUsers + 1} to n°${debutAfficUsers + 50}</p>
		<form
			method="post"
			action="Manage_Users">
		<p><input
			name="btn"
			class="bouton"
			type="submit"
			value="Delete" /> <input
			name="btn"
			class="bouton"
			type="submit"
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
						<th><span>Name</span></th>
						<th><span>Mail</span></th>
						<th><span>Affiliation</span></th>
					</tr>
					<kl:mngPeople>
						<tr class="${typeLigne}">
							<td><input
								type="checkbox"
								name="box${id}" /></td>
							<td><input
								type="radio"
								name="radio"
								value="radio${idPeople}" /></td>
							<td>${idPeople}</td>
							<td>${name}</td>
							<td>${mail}</td>
							<td>${affiliation}</td>
						</tr>
					</kl:mngPeople>
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
			name="btn"
			class="bouton"
			type="submit"
			value="Delete" /> <input
			name="btn"
			class="bouton"
			type="submit"
			value="Edit" /></p>
		</form>
		<div class="centre"><a href="MngPrevious"><img
			src="./images/previous.gif"
			alt="PREVIOUS" /></a><a href="MngNext"><img
			src="./images/next.gif"
			alt="NEXT" /></a></div>
		</div>

		<div class="chapitre">
		<h4>Add a new user</h4>
		<form
			method="post"
			action="AddUser">

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
				<table class="management">
					<tr>
						<th><span>Name</span></th>
						<td>
						<p><input
							type="text"
							class="saisie"
							name="name" /></p>
						</td>
					</tr>
					<tr>
						<th><span>Mail</span></th>
						<td>
						<p><input
							type="text"
							class="saisie"
							name="mail" /></p>
						</td>
					</tr>
					<tr>
						<th><span>URL</span></th>
						<td>
						<p><input
							type="text"
							class="saisie"
							name="url" /></p>
						</td>
					</tr>
					<tr>
						<th><span>Affiliation</span></th>
						<td>
						<p><input
							type="text"
							class="saisie"
							name="affiliation" /></p>
						</td>
					</tr>
					<tr>
						<th><span>Pays</span></th>
						<td>
						<p><select name="pays">
							<kl:countries selected="${id}">
								<option
									value="${id}"${selected}>${pays}</option>
							</kl:countries>
						</select></p>
						</td>
					</tr>
					<tr>
						<th><span>Display</span></th>
						<td><input
							type="checkbox"
							name="display"
							checked="checked" /></td>
					</tr>
					<tr>
						<th><span>Info</span></th>
						<td><input
							type="checkbox"
							name="info"
							checked="checked" /></td>
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
			value="Add this user" /></p>
		</form>
		</div>
	</c:when>
	<c:when test="${idEditUser != null}">
		<div class="chapitre">
		<h4>Edit this user</h4>
		<form
			method="post"
			action="ModifyUser">
		<kl:anUser>
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
							<th>Mail</th>
							<td><input
								type="text"
								class="saisie"
								name="mail"
								value="${mail}" /></td>
						</tr>
						<tr>
							<th>Affiliation</th>
							<td><input
								type="text"
								class="saisie"
								name="affiliation"
								value="${affiliation}" /></td>
						</tr>
						<tr>
							<th>Homepage</th>
							<td><input
								type="text"
								class="saisie"
								name="homepage"
								value="${homepage}" /></td>
						</tr>
						<tr>
							<th>Country</th>
							<td>
							<p><select name="pays">
								<kl:countries selected="${country}">
									<option
										value="${id}"${selected}>${pays}</option>
								</kl:countries>
							</select>Originally ${country}</p>
							</td>
						</tr>
						<tr>
							<th>Display</th>
							<td><input
								type="checkbox"
								name="display" ${display} /></td>
						</tr>
						<tr>
							<th>Info</th>
							<td><input
								type="checkbox"
								name="info" ${info} /></td>
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
		</kl:anUser>
		<p><input
			name="btn"
			type="submit"
			value="Modify this user" /><input
			name="btn"
			type="submit"
			value="Cancel" /></p>
		</form>
		</div>
	</c:when>
</c:choose></div>

