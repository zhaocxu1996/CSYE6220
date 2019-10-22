<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaoc
  Date: 10/21/2019
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part 8</title>
</head>
<body>
<table>
<c:forEach var="map" items="${table2}">
    <tr>
        <c:forEach var="data" items="${map}">
            <td><c:out value="${data}"/></td>
        </c:forEach>
    </tr>
</c:forEach>
</table>
</body>
</html>
