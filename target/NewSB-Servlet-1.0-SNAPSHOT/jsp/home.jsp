<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11.11.2021
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>

<%--<span style="color: ${cookie.color.value}">Hello</span>--%>

<%--<form method="post" action="/home">--%>
<%--    <label form="color">--%>
<%--        <select name="color" id="color">--%>
<%--            <option value="red">Red</option>--%>
<%--            <option value="black">Black</option>--%>
<%--            <option value="pink">Pink</option>--%>
<%--        </select>--%>
<%--    </label>--%>
<%--    <input type="submit" value="Color send">--%>
<%--</form>--%>


<div class="container">
<%--    <h1><spring:message code="messages.yourlogin"/> ${login}, <spring:message code="messages.role"/></h1>--%>
<%--    <c:forEach var="s" items="${roles}">--%>
<%--        <h3><c:out value="${s}"/></h3>--%>
<%--    </c:forEach>--%>

<%--    <c:if test="${admin}">--%>
<%--        <c:url value="/admin" var="adminUrl"/>--%>
<%--        <p><a input type="submit" class="btn btn-primary" href="${adminUrl}"><spring:message--%>
<%--                code="messages.adminpagebutton"/></a></p>--%>
<%--    </c:if>--%>

<%--    <c:url value="/update" var="updateUrl"/>--%>
    <form action="/home" method="POST">
<%--        <form action="${updateUrl}" method="post">--%>
<%--        <c:forEach items="${customer}" var="customer">--%>
<%--            <input class="form-control form-group" type="text" name="email" value="${customer.email}" placeholder=>--%>
<%--            <input class="form-control form-group" type="text" name="phone" value="${customer.phone}" placeholder=>--%>
<%--            <input class="form-control form-group" type="text" name="address" value="${customer.address}" placeholder=>--%>
    <input class="form-control form-group" type="text" name="email" id="email" placeholder=>
    <input class="form-control form-group" type="text" name="phone" id="phone" placeholder=>
    <input class="form-control form-group" type="text" name="address" id="address" placeholder=>
            <input type="submit" class="btn btn-primary" value=>
<%--        </c:forEach>--%>
    </form>

    <c:url value="/logout" var="logoutUrl"/>
    <p><a input type="submit" class="btn btn-primary" href="${logoutUrl}"><spring:message
            code="messages.logoutbutton"/></a></p>
</div>
<div class="container-fluid" style="margin: 3px auto">
    <div class="container">
        <div style="height: auto; margin:auto 3%;text-align:center">
            <nav class="navbar navbar-light bg-light">
<%--                <div class="container-fluid">--%>
<%--                    <a class="navbar-brand"><spring:message code="messages.searchbysubject"/></a>--%>
<%--                    <form method="get" action="/" class="d-flex">--%>
<%--                        <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search"--%>
<%--                               name="filter" value="${filter}">--%>
<%--                        <button class="btn btn-outline-success" type="submit"><spring:message--%>
<%--                                code="messages.buttonsearch"/></button>--%>
<%--                    </form>--%>
<%--                </div>--%>


<%--                <nav aria-label="Page navigation">--%>
<%--                    <ul class="pagination">--%>
<%--                        <c:forEach var="i" begin="1" end="${list.getTotalPages()}">--%>
<%--                            <li><a href="/?page=<c:out value="${i - 1}"/>&size=${itemPerPage}"><c:out value="${i}"/></a>--%>
<%--                            </li>--%>
<%--                        </c:forEach>--%>
<%--                    </ul>--%>
<%--                </nav>--%>

            </nav>

            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>Subject</th>
                    <th>Question1</th>
                    <th>Question2</th>
                    <th>Question3</th>
                    <th>Time</th>
                    <th>Degree</th>
                    <th>Customer</th>
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
