<title>Homewood Game Group</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>





<html>
<head>
<link rel="stylesheet" type="text/css" href="basic.css">

<c:set var="cp"
	value="${pageContext.request.servletContext.contextPath}"
	scope="session" />
<link href="<c:url value="/resources/css/basic.css" />" rel="stylesheet">

<div style="visibility: loginvisible">
	<a href="home">Home</a>&nbsp&nbsp&nbsp <a href="games">Edit Games</a>&nbsp&nbsp&nbsp
	<a href="venues">Edit Venues</a>
</div>
</head>


<body>
	<h1>Event</h1>

	<!-- Edit section -->
	<table>
		<form:form action="${cp}/saveevent" modelAttribute="myEvent">
			<form:input type="hidden" path="id" />
			<tr>
				<td>
					<p>Date</p><p>(YYYY-MM-DD)</p> <form:input type="date" path="date" />
				</td>


				<td>
					<p>Venue</p> <form:select path="venue" items="${venueList}" />
				</td>

				<td>
					<p>Game</p> <form:select path="game" items="${gameList}" />
				</td>
				<td>
					<p>Description</p> <form:input type="text" path="description" />
				</td>
			</tr>
			<tr>
				<td>
					<p>Hold down Ctrl while clicking to select multiple people</p>
					<p>Players</p> <form:select multiple="true" path="players"
						items="${playerList}" />
				</td>
				<td>
					<p>Winner(s)</p> <form:select multiple="true" path="winners"
						items="${playerList}" />
				</td>
				<td></td><td></td>
			<tr>
				<button type="submit">Submit</button>
		</form:form>
	</table>



</body>
</html>