<%--
  Created by IntelliJ IDEA.
  User: zhaoc
  Date: 10/21/2019
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Part 9 - Search</title>
</head>
<body>
<p>You searched for "${keyword}"</p>
<b><u>Here are the search results</u></b><br/>
<c:forEach var="map" items="${search}">
    <b>Movie Title: </b> ${map["title"]}<br/>
    <b>Lead Actor: </b> ${map["actor"]}<br/>
    <b>Lead Actress: </b> ${map["actress"]}<br/>
    <b>Genre: </b> ${map["genre"]}<br/>
    <b>Year: </b> ${map["year"]}<br/><br/>
</c:forEach>
<a href="/hw3/part9.html">Click here to go back to the main page</a>
</body>
</html>
