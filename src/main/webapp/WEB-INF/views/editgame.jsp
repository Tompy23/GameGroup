<title>Homewood Game Group</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="myGame" scope="request"
	type="net.tompy.gamegroup.spring.model.Game" />
<jsp:useBean id="myGameList" scope="request" type="java.util.List" />
<jsp:useBean id="loginvisible" scope="request" type="java.lang.String" />
<html>
<head>
<spring:url value="/resources/css/basic.css" var="basicCss" />

<link href="${basicCss}" rel="stylesheet" />

<c:set var="cp"
	value="${pageContext.request.servletContext.contextPath}"
	scope="session" />
<link href="<c:url value="/resources/css/basic.css" />" rel="stylesheet">

<div style="visibility: ${loginvisible};">
	<a href="home">Home</a>&nbsp&nbsp&nbsp <a href="venues">Edit Venues</a>&nbsp&nbsp&nbsp
	<a href="newevent">Create an event</a>
</div>
</head>


<body>
	<h1>Edit Games</h1>

	<!-- Edit section -->
	<form action="${cp}/savegame" method="POST">
		<p>Name</p>
		<input type="text" name="gameName" value="${myGame.name}"> <input
			type="hidden" name="gameIdOld" value="${myGame.id}" /> <input
			type="submit" value="Submit">

	</form>



</body>
</html>