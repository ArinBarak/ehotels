<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- this page is the page where the employee enters the bookig reference to check in a customer --%>

<!DOCTYPE HTML>
<html lan"en">
<head>
    <meta charset="UTF-8">
    <title>EHotels | Check In</title>
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
        <form action="employee-check-in-customer-controller.jsp" method="GET">
                 <input type="text" name="booking_reference" placeholder="Enter Booking Reference" class="rounded-input">
                 <input type="submit" value="Check In" class="rounded-submit"/>
              </form>
    </div>
</body>