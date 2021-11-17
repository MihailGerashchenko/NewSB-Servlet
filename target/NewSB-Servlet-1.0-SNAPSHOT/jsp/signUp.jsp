<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11.11.2021
  Time: 13:08
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
<div class="container">

<form method="post" action="/signUp">
<%--    <label for="name">User name--%>
<%--        <input type="text" id="name" name="name"></label>--%>


    <input class="form-control form-group" type="text" id="login" name="login" placeholder="Login">
<%--    <input class="form-control form-group" type="text" id="birthDate" name="birthDate" placeholder="Birth date">--%>
    <input class="form-control form-group" type="password" id="password" name="password" placeholder="Password">
    <input class="form-control form-group" type="text" id="email" name="email" placeholder="Email">
    <input class="form-control form-group" type="text" id="phone" name="phone" placeholder="Phone">
    <input class="form-control form-group" type="text" id="address" name="address" placeholder="Address">
    <input type="submit" class="btn btn-primary" value="Sign up">
<%--    <label for="birthDate">Birth date--%>
<%--        <input type="text" id="birthDate" name="birthDate"></label>--%>
<%--    <label for="password">Password--%>
<%--        <input type="password" id="password" name="password"></label>--%>

</form>
</div>


<table>
    <tr>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>phone</th>
        <th>address</th>
    </tr>
    <c:forEach items="${allUsers}" var="user">
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
