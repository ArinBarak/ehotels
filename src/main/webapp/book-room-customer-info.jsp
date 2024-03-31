<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.CustomerService" %>
<%@ page import="com.ehotels.Customer" %>
<%@ page import="com.ehotels.Message" %>
<%@ page import="java.util.ArrayList" %>

<%-- this is the page where enters their information after they have choose the room they want to book --%>


<!DOCTYPE html>
<html>
<head>
    <title>EHotels | Customer</title>
    <style>
        .container {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 300px;
            margin: 0 auto;
        }

        .rounded-input {
            border-radius: 5px;
            padding: 15px;
            margin-bottom: 10px;
            width: 100%;
            box-sizing: border-box;
        }

        .rounded-submit {
            border-radius: 5px;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            width: 100%;
            box-sizing: border-box;
        }

        .rounded-submit:hover {
            background-color: #0056b3;
        }
    </style>

</head>

<body>
    <jsp:include page="navbar.jsp"/>

    <div class="container">
        <form action="book-with-customer.jsp" method="post">
            <input type="text" name="fullname" placeholder="Enter your full name:" class="rounded-input">
            <input type="text" name="cust_id" placeholder="Enter your ID:" class="rounded-input">
            <input type="text" name="id_type" placeholder="Enter your ID type:" class="rounded-input">
            <input type="text" name="address" placeholder="Enter your address:" class="rounded-input">
            <input type="hidden" name="room_id" value="<%= request.getParameter("room_id") %>">
            <input type="hidden" name="room_number" value="<%= request.getParameter("room_number") %>">
            <input type="hidden" name="hotel_name" value="<%= request.getParameter("hotel_name") %>">
            <input type="submit" value="Book" class="rounded-submit">
        </form>
    </div>

</body>

</html>