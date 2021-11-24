<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="messages.testcreation"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <form action="/createTest" method="post">
        <h3><fmt:message key="messages.testcreation"/></h3>

        <input class="form-control form-group" type="text" id="subject" name="subject" required placeholder="<fmt:message key="messages.subject"/>">
        <input class="form-control form-group" type="text" id="question1" name="question1" required placeholder="<fmt:message key="messages.question1"/>">
        <input class="form-control form-group" type="text" id="question2" name="question2" required placeholder="<fmt:message key="messages.question2"/>">
        <input class="form-control form-group" type="text" id="question3" name="question3" required placeholder="<fmt:message key="messages.question3"/>">
        <small id="passwordHelpBlock" class="form-text text-muted">
            <fmt:message key="messages.timeProposal"/>
        </small>
        <input class="form-control form-group" type="text" id="time" name="time"
               aria-describedby="passwordHelpBlock" required placeholder="<fmt:message key="messages.time"/>">
<%--        <input class="form-control form-group" type="text" id="time" name="time" required placeholder="<fmt:message key="messages.time"/>">--%>
        <input class="form-control form-group" type="text" id="degree" name="degree" aria-describedby="passwordHelp"
               pattern="[ABCD]" required
               placeholder="<fmt:message key="messages.degree"/>">
        <input type="submit" class="btn btn-primary" value="<fmt:message key="messages.add"/>">
    </form>
</div>

</body>
</html>
