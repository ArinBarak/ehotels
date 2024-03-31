<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- this is the main page of ehotels --%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> eHotels | Find Your Hotel </title> </head>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }
       .centered-container {
           position: absolute;
           top: 50%;
           left: 50%;
           transform: translate(-50%, -50%);
           display: flex;
           flex-direction: column;
           align-items: center;
       }

       .rounded-box {
           background-color: #f0f0f0;
           border-radius: 10px;
           padding: 20px;
           margin-bottom: 20px;
           width: 500px;
           box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
       }

       .room-info {
           text-align: center;
       }

       .info-item {
           margin-bottom: 10px;
       }

    </style>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="centered-container">
        <div class="rounded-box">
            <div class="room-info">
                <div class="info-item">
                    <p>Welcome to EHotels!</p>
                </div>
                <div class="info-item">
                    <p>To book a room, please go to the booking page.</p>
                </div>
                <div class="info-item">
                    <p>To get contact informations of Hotel Chains, please go to the contact page.</p>
                </div>
                <div class="info-item">
                    <p>If you are an employee please log in.</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>