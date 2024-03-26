<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html lan"en">

<head>
    <meta charset="UTF-8">
    <title>EHotels | Employee</title>
</head>
<body>
    <jsp:include page="main.jsp"/>
    <div class="container">
        <form action="employee-login.jsp" method="GET">
                 Employee ID: <input type = "text" name = "e_id">
                 <input type = "submit" value = "Login" />
              </form>
    </div>
</body>