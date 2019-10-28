<%--
  Created by IntelliJ IDEA.
  User: zhaoc
  Date: 2019/10/11
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="edu.neu.csye.model.User" scope="request"/>
<html>
<head>
    <title>part8</title>
</head>
<body>
    <jsp:setProperty name="user" property="*"/>
    <table>
        <tr>
            <th>Parameter Name</th>
            <th>User Input</th>
        </tr>
        <tr>
            <td>Email</td>
            <td><jsp:getProperty name="user" property="email"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><jsp:getProperty name="user" property="password"/></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><jsp:getProperty name="user" property="confirm"/></td>
        </tr>
        <tr>
            <td>Picture</td>
            <td><jsp:getProperty name="user" property="upload"/></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><jsp:getProperty name="user" property="gender"/></td>
        </tr>
        <tr>
            <td>Country</td>
            <td><jsp:getProperty name="user" property="country"/></td>
        </tr>
        <tr>
            <td>Hobby</td>
            <td><jsp:getProperty name="user" property="hobby"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><jsp:getProperty name="user" property="address"/></td>
        </tr>
    </table>
</body>
</html>
