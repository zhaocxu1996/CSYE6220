<%--
  Created by IntelliJ IDEA.
  User: zhaoc
  Date: 2019/10/11
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>part6</title>
</head>
<body>
<c:set var="String" value="Welcome to javatpoint"/>
<c:if test="${fn:contains(String, 'javatpoint')}">
<p>Found javatpoint string<p>
    </c:if>

    <c:set var="str1" value="Welcome to JSP        programming         "/>
<p>String-1 Length is : ${fn:length(str1)}</p>
<c:set var="str2" value="${fn:trim(str1)}" />
<p>String-2 Length is : ${fn:length(str2)}</p>
<p>Final value of string is : ${str2}</p>

<c:set var="string" value="This is the first string."/>
${fn:substring(string, 5, 17)}<br>

<c:set var="str" value="<%=new java.util.Date()%>" />
<table border="2" width="100%">
    <tr>
        <td width="100%" colspan="2" bgcolor="#FF7F50">
            <p align="center">
                <b>
                    <font color="#000000" size="6">Formatting:
                        <fmt:formatDate value="${str}" type="both"
                                        timeStyle="long" dateStyle="long" />
                    </font>
                </b>
            </p>
        </td>
    </tr>

    <c:forEach var="zone"
               items="<%=java.util.TimeZone.getAvailableIDs()%>">
        <tr>
            <td width="50%"  bgcolor="#C0C0C0">
                <c:out value="${zone}" />
            </td>
            <td width="50%" bgcolor="#FFEBCD">
                <fmt:timeZone value="${zone}">
                    <fmt:formatDate value="${str}" timeZone="${zn}"
                                    type="both"/>
                </fmt:timeZone>
            </td>
        </tr>
    </c:forEach>
</table>

<c:set var="Amount" value="786.970" />

<fmt:parseNumber var="j" type="number" value="${Amount}" />
<p><i>Amount is:</i>  <c:out value="${j}" /></p>

<c:set var="book">
    <books>
        <book>
            <name>Three mistakes of my life</name>
            <author>Chetan Bhagat</author>
            <price>200</price>
        </book>
        <book>
            <name>Tomorrow land</name>
            <author>Brad Bird</author>
            <price>2000</price>
        </book>
    </books>
</c:set>
<x:parse xml="${book}" var="output"/>
<x:set var="fragment" select="$output/books/book[2]/price"/>
<b>The price of the Tomorrow land book</b>:
<x:out select="$fragment" />

  <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                     url="jdbc:mysql://localhost:3306/test"
                     user="root"  password="root"/>

  <sql:query dataSource="${db}" var="rs">
    SELECT * from t_user;
  </sql:query>

  <table border="2" width="100%">
    <tr>
      <th>username</th>
      <th>password</th>
    </tr>
    <c:forEach var="table" items="${rs.rows}">
      <tr>
        <td><c:out value="${table.username}"/></td>
        <td><c:out value="${table.password}"/></td>
      </tr>
    </c:forEach>
  </table>

</body>
</html>