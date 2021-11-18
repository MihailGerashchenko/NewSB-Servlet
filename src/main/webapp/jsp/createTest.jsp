<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 18.11.2021
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <form action="/createTest" method="post">
        <h3>Create test</h3>

        <input class="form-control form-group" type="text" id="subject" name="subject" placeholder="Subject">
        <input class="form-control form-group" type="text" id="question1" name="question1" placeholder="Question1">
        <input class="form-control form-group" type="text" id="question2" name="question2" placeholder="Question2">
        <input class="form-control form-group" type="text" id="question3" name="question3" placeholder="Question3">
        <input class="form-control form-group" type="text" id="time" name="time" placeholder="Time">
        <input class="form-control form-group" type="text" id="degree" name="degree" placeholder="Degree">
        <input type="submit" class="btn btn-primary" value="Create">
    </form>
</div>

</body>
</html>
