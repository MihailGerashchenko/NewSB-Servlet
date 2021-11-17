<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <ul>
    </ul>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<%--    <div class="container">--%>
        <div>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=en">English</a>
            &nbsp;|&nbsp;
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=ru">Русский</a>
            &nbsp;|&nbsp;
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=ua">Українська</a>
        </div>
    <ul>
    </ul>
    <form method="post" action="/">
<%--        <label for="name">User name--%>
<%--            <input class="input-field" type="text" id="name" name="name">--%>
<%--        </label>--%>
        <input class="form-control form-group" type="text" id="login" name="login" placeholder="Login">
    <input class="form-control form-group" type="password" id="password" name="password" placeholder="Password">

<%--        <label for="password">Password--%>
<%--            <input class="input-field" type="password" id="password" name="password">--%>
<%--        </label>--%>
        <input class="btn btn-primary" type="submit" value="Sign Up">
    <p><a href="/signUp"><input class="btn btn-primary" value="Register"></a></p>
    </form>
</div>
</body>
</html>