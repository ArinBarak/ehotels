<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html lan"en">

<head>
    <meta charset="UTF-8">
    <title>EHotels | Check In</title>
</head>
<body>
    <jsp:include page="main.jsp"/>
    <div class="container">
        <form action="employee-check-in-customer-controller.jsp" method="GET">
                 Enter Booking Reference: <input type = "text" name = "booking_reference">
                 <input type = "submit" value = "Check In" />
              </form>
    </div>
</body>