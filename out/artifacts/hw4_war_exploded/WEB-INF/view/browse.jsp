<%--
  Created by IntelliJ IDEA.
  User: zhaoc
  Date: 10/21/2019
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part 9 - Browse Movies</title>
</head>
<body>
<h1>Searching Movies</h1>
<form action="/hw4/part9" method="post">
    Keyword: <input type="text" name="keyword"/><br/>
    <input type="radio" name="option" value="title">Search By Title<br/>
    <input type="radio" name="option" value="actor">Search By Actor<br/>
    <input type="radio" name="option" value="actress">Search By Actress<br/>
    <input type="submit" name="search" value="Search Movies">
</form>
</body>
</html>
