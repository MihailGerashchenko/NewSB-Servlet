<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="messages.registration"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form method="post" action="/signUp">

    <h3><fmt:message key="messages.registration"/></h3>

    <input class="form-control form-group" type="login" id="login" name="login" placeholder="<fmt:message key="messages.addlogin"/>">
    <input class="form-control form-group" type="password" id="password" name="password" placeholder="<fmt:message key="messages.addpassword"/>">
    <input class="form-control form-group" type="email" id="email" name="email" placeholder="<fmt:message key="messages.addemail"/>">
    <input class="form-control form-group" type="phone" id="phone" name="phone" placeholder="<fmt:message key="messages.addphone"/>">
    <input class="form-control form-group" type="address" id="address" name="address" placeholder="<fmt:message key="messages.addaddress"/>">
    <input type="submit" class="btn btn-primary" value="<fmt:message key="messages.add"/>">
    <ul>
    </ul>
    <p><a type="submit" class="btn btn-primary" href="/login"><fmt:message key="messages.turnback"/></a></p>

</form>
</div>
</body>
</html>
