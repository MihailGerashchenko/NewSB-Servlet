<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <input class="form-control form-group" type="login" id="login" name="login" required
               placeholder="<fmt:message key="messages.addlogin"/>">
        <small id="passwordHelpBlock" class="form-text text-muted">
            <fmt:message key="messages.passwordRequirement"/>
        </small>
        <input class="form-control form-group" type="password" id="password" name="password"
               aria-describedby="passwordHelpBlock" required placeholder="<fmt:message key="messages.addpassword"/>">
        <input class="form-control form-group" type="email" id="email" name="email" required
               placeholder="<fmt:message key="messages.addemail"/>">
        <small id="passwordHelp" class="form-text text-muted">
            <fmt:message key="messages.phoneFormat"/>
        </small>
        <input class="form-control form-group" type="phone" id="phone" name="phone" aria-describedby="passwordHelp"
               pattern="?<=(^|\n)(38)?)(039|067|068|096|097|098|050|066|095|099|063|093)\d{7}(?=\r?\n|$" required
               placeholder="<fmt:message key="messages.addphone"/>">
        <%--    h2>Phone Number Validation</h2>--%>
        <%--    <label for="phonenum">Phone Number (format: +380673512849):</label><br/>--%>
        <%--    <input id="phonenum" type="tel" pattern="^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$" required >--%>

        <input class="form-control form-group" type="address" id="address" name="address" required
               placeholder="<fmt:message key="messages.addaddress"/>">
        <input type="submit" class="btn btn-primary" value="<fmt:message key="messages.add"/>">
        <ul>
        </ul>
        <p><a type="submit" class="btn btn-primary" href="/login"><fmt:message key="messages.turnback"/></a></p>

    </form>
</div>
</body>
</html>
