<%--
  Created by IntelliJ IDEA.
  User: zhaoc
  Date: 2019/10/21
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Part 6</title>
</head>
<body>
<table>
<c:forEach var="map" items="${list}">
    <tr>
    <c:forEach var="data" items="${map}">
        <td><c:out value="${data}"/></td>
    </c:forEach>
    </tr>
</c:forEach>
</table>
</body>
</html>
