<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.demo.CustomerService" %>
<%@ page import="com.demo.Customer" %>
<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    String room_id = request.getParameter("room_id");
%>

<!DOCTYPE html>
<html>
<head>
    <title>EHotels | Customer</title>

</head>

<body>
    <jsp:include page="main.jsp"/>

    <div class="container">
            <form action="book-room-customer-controller-info.jsp" method="post">
                <input type="text" name="fullname" placeholder="Enter your full name:">
                <input type="text" name="cust_id" placeholder="Enter your ID:">
                <input type="text" name="id_type" placeholder="Enter your ID type:">
                <input type="text" name="address" placeholder="Enter your address:">
                <input type="text" name="registration_date" placeholder="Enter your registration date:">
                <input type="hidden" name="room_id" value="<% room_id %>">
                <input type="submit" value="Book">
            </form>
    </div>

</body>

</html>