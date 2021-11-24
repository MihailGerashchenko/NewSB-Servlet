<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">

<head>
    <title><fmt:message key="messages.login1"/></title>
    <ul>
    </ul>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">

        <div>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=en">English</a>
            &nbsp;|&nbsp;
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=ru">Русский</a>
            &nbsp;|&nbsp;
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=ua">Українська</a>
        </div>
    <h3><fmt:message key="messages.login"/></h3>

    <form method="post" action="/">
        <input class="form-control form-group" type="text" id="login" name="login" placeholder="<fmt:message key="messages.login"/>">
    <input class="form-control form-group" type="password" id="password" name="password" placeholder="<fmt:message key="messages.password"/>">
        <input class="btn btn-primary" type="submit" value="<fmt:message key="messages.login1"/>">
    <ul>
    </ul>
    <p><a href="/signUp"><input class="btn btn-primary" value="<fmt:message key="messages.registration"/>"></a></p>
    </form>
</div>
</body>
</html>