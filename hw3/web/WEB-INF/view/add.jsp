<%--
  Created by IntelliJ IDEA.
  User: zhaoc
  Date: 10/21/2019
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part 9 - Add Movie</title>
</head>
<body>
<h1>Please enter the details below:</h1>
<form action="/hw3/part9" method="post">
    Movie Title: <input type="text" name="title"/><br/>
    Lead Actor: <input type="text" name="actor"/><br/>
    Lead Actress: <input type="text" name="actress"/><br/>
    Genre: <input type="text" name="genre"/><br/>
    Year: <input type="text" name="year"/><br/>
    <input type="submit" name="add" value="Add Movie">
</form>
</body>
</html>
