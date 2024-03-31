<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>EHotels | Success</title>
    <style>
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
            background-color: #f0f0f0; /* Change to your preferred background color */
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
            width: 300px; /* Adjust as needed */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add a subtle shadow */
        }

        .room-info {
            text-align: center;
        }

        .info-item {
            margin-bottom: 10px;
        }
    </style>

</head>

<body>
    <jsp:include page="navbar.jsp"/>
    <div class="centered-container">
        <div class="rounded-box">
             <div class="room-info">
                 <div class="info-item">
                    <p>Success!</p>
                 </div>
                 <div class="info-item">
                    <p>Customer Checked In!</p>
                 </div>
             </div>
        </div>
    </div>
</body>

</html>