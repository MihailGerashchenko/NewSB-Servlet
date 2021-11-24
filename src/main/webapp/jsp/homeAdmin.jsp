<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>

<div class="container">

<%--    <h1>Your login is ${customer.login}, your role is</h1>--%>
<%--    <c:forEach var="s" items="${customer.role}">--%>
<%--        <h3><c:out value="${s}"/></h3>--%>
<%--    </c:forEach>--%>

    <%--    <c:if test="${customer.role.ADMIN}">--%>
    <c:url value="/admin" var="adminUrl"/>
    <p><a input type="submit" class="btn btn-primary" href="${adminUrl}"><fmt:message key="messages.adminpage"/></a></p>

    <form action="<c:url value='/homeAdmin'/>" method="POST">

        <input class="form-control form-group" type="text" id="login" name="login" required placeholder="<fmt:message key="messages.login"/>">
        <input class="form-control form-group" type="text" id="email" name="email" required value="${email}" placeholder="<fmt:message key="messages.addpassword"/>">
        <input class="form-control form-group" type="text" id="phone" name="phone" required value="${phone}" placeholder="<fmt:message key="messages.addphone"/>">
        <input class="form-control form-group" type="text" id="address" name="address" required value="${address}" placeholder="<fmt:message key="messages.addaddress"/>">
        <input type="submit" class="btn btn-primary" value="<fmt:message key="messages.update"/>">

    </form>
    <p><a type="submit" class="btn btn-primary" href="/login"><fmt:message key="messages.turnback"/></a></p>

</div>

<div class="container-fluid" style="margin: 3px auto">
    <div class="container">
        <div style="height: auto; margin:auto 3%;text-align:center">
            <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand"></a>
                    <form method="get" action="/homeAdmin" class="d-flex">
                        <input class="form-control me-2" type="text" placeholder="<fmt:message key="messages.searchbysubject"/>" aria-label="Search"
                               name="subject" id="subject">
                        <button class="btn btn-outline-success" type="submit"></button>
                    </form>
                </div>

                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:forEach var="i" begin="1" end="${numberOfPages}">
                            <li><a href="/homeAdmin?page=<c:out value="${i}"/>&size=${6}"><c:out value="${i}"/></a>
                            </li>
                        </c:forEach>
                    </ul>
                </nav>

            </nav>

            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th><fmt:message key="messages.subject"/></th>
                    <th><fmt:message key="messages.question1"/></th>
                    <th><fmt:message key="messages.question2"/></th>
                    <th><fmt:message key="messages.question3"/></th>
                    <th><fmt:message key="messages.time"/></th>
                    <th><fmt:message key="messages.degree"/></th>
                    <th><fmt:message key="messages.customerjust"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="test" items="${AllTests}">
                    <tr>
                        <td><c:out value="${test.subject}"/></td>
                        <td><c:out value="${test.question1}"/></td>
                        <td><c:out value="${test.question2}"/></td>
                        <td><c:out value="${test.question3}"/></td>
                        <td><c:out value="${test.time}"/></td>
                        <td><c:out value="${test.degree.toString()}"/></td>
                        <td><c:out value="${test.customer.getLogin()}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
