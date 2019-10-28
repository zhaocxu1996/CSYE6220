<%--
  Created by IntelliJ IDEA.
  User: zhaoc
  Date: 2019/10/11
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>part7</title>
</head>
<body>
<c:if test="${name != null && name !='View Cart'}">
    <h1>Shop for ${name}</h1>
    <form method="POST" action="ItemController">
        <input type="submit" name="page" value="book"><br/>
        <input type="submit" name="page" value="music"><br/>
        <input type="submit" name="page" value="computer"><br/>
        <c:forEach var="i" begin="1" end="5">
            <input type="checkbox" name="<c:out value='${name}'/>" value="<c:out value='${name}'/><c:out value='${i}'/>">${name}<c:out value="${i}"/><br/>
        </c:forEach>
        <input type="submit" name="submit" value="submit">
    </form>
</c:if>
<c:if test="${items != null}">
    <h1>The following item has been added to your shopping cart successfully</h1>
    <c:forEach var="item" items="${items}">
        <p>- ${item}</p><br/>
    </c:forEach>
    <form method="GET" action="ItemController">
        <input type="submit" name="page" value="View cart"><br/>
        <input type="submit" name="page" value="book"><br/>
        <input type="submit" name="page" value="music"><br/>
        <input type="submit" name="page" value="computer"><br/>
        <input type='hidden' name='p-number' value='1' />
    </form>
</c:if>
<c:if test="${names != null}">
    <form method="GET" action="ItemController">
        <table>
            <tr>
                <th>Item</th>
                <th>Quantities</th>
            </tr>
            <c:forEach var="n" items="${names}" >
                <tr>
                    <td>${n[0]}</td>
                    <td>${n[1]}</td>
                    <td>
                        <input type="submit" name="${n[0]}" value="delete"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type='hidden' name='p-number' value='2' />
    </form>
</c:if>
</body>
</html>
