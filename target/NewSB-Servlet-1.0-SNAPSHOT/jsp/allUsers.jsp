<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 16.11.2021
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<body>
<table>
    <tr>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>phone</th>
        <th>address</th>
    </tr>
    <c:forEach items="${usersFromServer}" var="user">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
