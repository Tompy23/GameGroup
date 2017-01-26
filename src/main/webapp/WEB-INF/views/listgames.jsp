

<title>Homewood Game Group</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="myGameList" scope="request" type="java.util.List" />
<jsp:useBean id="loginvisible" scope="request" type="java.lang.String" />
<html>
<head>
<c:set var="cp"
	value="${pageContext.request.servletContext.contextPath}"
	scope="application" />
<link href="<c:url value="/resources/style/css/basic.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/sorttable.js"/>"></script>


<div style="visibility: ${loginvisible};">
	<a href="home">Home</a>&nbsp&nbsp&nbsp <a href="venues">Edit Venues</a>&nbsp&nbsp&nbsp
	<a href="newevent">Create an event</a>
</div>
</head>


<body>
	<h1>Games</h1>

	<!-- Edit section -->
	<form action="${cp}/newgame">
		<input type="submit" value="Add Game">
	</form>

	<table class="sortable">
		<tr>
			<th>Game</th>
			<th class="sorttable_nosort"></th>
			<th class="sorttable_nosort"></th>
		</tr>
		<c:forEach items="${myGameList}" var="game">

			<tr>


				<td>
					<p>${game.name}</p>
				</td>
				<td>
					<form action="${cp}/editgame" method="POST">
						<input type="submit" value="Edit"> <input type="hidden"
							name="gameId" value="${game.id}">

					</form>
				</td>
				<td>
					<div class="delete_button">
						<form action="${cp}/deletegame" method="POST">
							<input type="hidden" name="gameIdToDelete" value="${game.id}" />
							<input type="submit" value="Delete">
						</form>
					</div>
				</td>

			</tr>

		</c:forEach>
	</table>

</body>
</html>