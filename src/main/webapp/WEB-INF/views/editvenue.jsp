

<title>Homewood Venue Group</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="myVenue" scope="request" type="net.tompy.gamegroup.spring.model.Venue"/>
<jsp:useBean id="myVenueList" scope="request" type="java.util.List" />
<jsp:useBean id="loginvisible" scope="request" type="java.lang.String" />
<html>
<head>
<link rel="stylesheet" type="text/css" href="basic.css">

<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="session" />
<link href="<c:url value="/resources/css/basic.css" />" rel="stylesheet">

<div style="visibility: ${loginvisible};">
<a href="home">Home</a>&nbsp&nbsp&nbsp <a href="venues">Edit Venues</a>&nbsp&nbsp&nbsp <a href="newevent">Create an event</a>
</div>
</head>


<body>
	<h1>Edit Venues</h1>
	
	<!-- Edit section -->
	<form action="savevenue" method="POST">
	<p>Name</p>
	<input type="text" name="venueName" value="${myVenue.name}">
	<input type="hidden" name="venueIdOld" value="${myVenue.id}"/>
	<input type="submit" value="Submit">
	
	</form>
	


</body>
</html>