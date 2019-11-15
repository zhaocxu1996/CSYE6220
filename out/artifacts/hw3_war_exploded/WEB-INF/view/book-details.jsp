<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaoc
  Date: 10/21/2019
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part 10 - Enter Book Details</title>
</head>
<body>
<form action="/hw3/part10" method="post">
<table>
    <tr>
        <th>ISBN</th>
        <th>Book Title</th>
        <th>Authors</th>
        <th>Price</th>
    </tr>
    <c:forEach var="i" begin="1" end="${quantity}">
        <tr>
            <td>
                <input type="text" name="isbn${i}">
            </td>
            <td>
                <input type="text" name="title${i}">
            </td>
            <td>
                <input type="text" name="authors${i}">
            </td>
            <td>
                <input type="text" name="price${i}">
            </td>
        </tr>
    </c:forEach>
</table>
<input type="submit" name="add" value="Add Books">
</form>
</body>
</html>
