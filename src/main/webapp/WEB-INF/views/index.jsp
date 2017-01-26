<title>Homewood Game Group</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="myEventList" scope="request" type="java.util.List" />
<jsp:useBean id="loginvisible" scope="request" type="java.lang.String" />
<html>
<head>
<c:set var="cp"
	value="${pageContext.request.servletContext.contextPath}"
	scope="application" />
<link href="<c:url value="/resources/style/css/basic.css" />" rel="stylesheet">

<!-- Add buttons to "Add Game", "Add Venu", "Create Event" -->
<div style="visibility: ${loginvisible};">
	<a href="games">Edit Games</a>&nbsp&nbsp&nbsp <a href="venues">Edit
		Venues</a>&nbsp&nbsp&nbsp <a href="newevent">Create an event</a>
</div>
<script src="<c:url value="/resources/js/sorttable.js"/>"></script>
</head>


<body>
	<h1>Homewood Game Group</h1>
	<div>
		<table class="sortable">
			<thead>
				<tr>
					<th>Venue</th>
					<th>Date</th>
					<th class="sorttable_nosort">Players</th>
					<th>Game</th>
					<th class="sorttable_nosort">Description</th>
					<th class="sorttable_nosort"></th>
					<th class="sorttable_nosort"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${myEventList}" var="event">
					<tr>
						<td>${event.venue.name}</td>
						<td>${event.date}</td>
						<td>
							<table style="border: 0px;">
								<tr style="border: 0px;">
									<td><c:forEach items="${event.eventPlayer}" var="ePlayer">
											<div class="${ePlayer.win}win">
												${ePlayer.player.name} <br>
											</div>
										</c:forEach></td>
								</tr>
							</table>
						<td>${event.game.name}</td>
						<td>${event.description}</td>

						<td>
							<form action="${cp}/editevent" method="POST">
								<input type="hidden" name="eventIdToEdit" value="${event.id}" />
								<input type="submit" value="Edit">
							</form>
						</td>

						<td>
							<div class="delete_button">
								<form action="/deleteevent" method="POST">
									<input type="hidden" name="eventIdToDelete" value="${event.id}" />
									<input type="submit" value="Delete">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>