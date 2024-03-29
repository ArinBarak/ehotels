<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.CustomerService" %>
<%@ page import="com.ehotels.Customer" %>
<%@ page import="com.ehotels.Message" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
<head>
    <title>EHotels | Customer</title>

</head>

<body>
    <jsp:include page="main.jsp"/>

    <div class="container">
            <form action="book-with-customer.jsp" method="post">
                <input type="text" name="fullname" placeholder="Enter your full name:">
                <input type="text" name="cust_id" placeholder="Enter your ID:">
                <input type="text" name="id_type" placeholder="Enter your ID type:">
                <input type="text" name="address" placeholder="Enter your address:">
                <input type="hidden" name="room_id" value="<%= request.getParameter("room_id") %>">
                <input type="hidden" name="room_number" value="<%= request.getParameter("room_number") %>">
                <input type="submit" value="Book">
            </form>
    </div>

</body>

</html>