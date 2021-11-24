<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="messages.adminpage"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1><fmt:message key="messages.adminpage"/></h1>
    <ul>
    </ul>
</div>
<div class="container-fluid" style="margin: 3px auto">
    <div class="container">
        <nav class="navbar navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand"></a>
                <form method="get" action="/admin" class="d-flex">
                    <input class="form-control me-2" type="text" placeholder="Search"
                           aria-label="<fmt:message key="messages.searchbylogin"/>"
                           name="login" id="login">
                    <button class="btn btn-outline-success" type="submit"></button>
                </form>
            </div>

            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach var="i" begin="1" end="${numberOfPages}">
                        <li><a href="/admin?page=<c:out value="${i}"/>&size=${6}"><c:out value="${i}"/></a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>

        </nav>

        <div style="height: auto; margin:auto 3%;text-align:center">
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>Delete</th>
                    <th><fmt:message key="messages.customerjust"/></th>
                    <th><fmt:message key="messages.addemail"/></th>
                    <th><fmt:message key="messages.addphone"/></th>
                    <th><fmt:message key="messages.addaddress"/></th>
                    <th><fmt:message key="messages.rolejust"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${AllCustomers}">
                    <td><a class="btn btn-primary" id="${user.id}"
                           onclick="deleteRequest(id)">
                        Delete
                    </a></td>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.phone}"/></td>
                    <td><c:out value="${user.address}"/></td>
                    <td><c:out value="${user.role}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <button type="button" class="btn btn-primary" id="add_user"><fmt:message
                    key="messages.registration"/></button>
            <p><a type="submit" class="btn btn-primary" href="/homeAdmin"><fmt:message key="messages.turnback"/></a></p>
            <c:url value="/logout" var="logoutUrl"/>
            <p><a type="submit" class="btn btn-primary" a href="${logoutUrl}"><fmt:message
                    key="messages.logoutbutton"/></a></p>
            <p><a href="/createTest"><input class="btn btn-primary" value=<fmt:message
                    key="messages.testcreation"/>></a></p>
        </div>
    </div>
</div>
<script>
    $('#add_user').click(function () {
        window.location.href = "/signUp";
    });
</script>
<script>
    function deleteRequest(id) {
        $.ajax({
            url: '/admin?id=' + id,
            type: 'delete',
            success: function (data) {
                console.log(data);
                // document.location.reload();
            }
        });
    }
</script>
</body>
</html>