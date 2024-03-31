<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- this page shows the hotel chains contact informations --%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> eHotels | Contact </title> </head>
<style>
    body {
           margin: 0;
           font-family: Arial, sans-serif;
       }

       #hotels {
           display: flex;
           flex-wrap: wrap;
           justify-content: center;
           padding: 10px;
       }

       .hotel {
           width: 45%;
           margin: 10px;
           padding: 20px;
           border: 2px solid #031d59;
           border-radius: 2px;
           box-sizing: border-box;
       }

       .hotel h2 {
           color: #000000;
       }

       .hotel p {
           margin: 10px 0px;
       }


</style>
<body>
<header>
    <jsp:include page="navbar.jsp"/>
</header>
<section id="hotels">
    <div class="hotel">
        <h2>Emerald Escapes Hotels</h2>
        <p><strong>Phone:</strong> +1 (418)933-8879</p>
        <p><strong>Address:</strong> Vancouver</p>
        <p><strong>Email:</strong><a href="mailto:emeraldehotels@hotels.ca"></strong>emeraldehotels@hotels.ca</a></p>
    </div>

    <div class="hotel">
        <h2>Harmony Resorts</h2>
        <p><strong>Phone:</strong> +1 (613)725-8976</p>
        <p><strong>Address:</strong> Ottawa</p>
        <p><strong>Email:</strong><a href="mailto:harmonyresorts@hotels.ca"></strong>harmonyresorts@hotels.ca</a></p>
    </div>

    <div class="hotel">
        <h2>Sunlight Tourism</h2>
        <p><strong>Phone:</strong> +1 (416)561-4623</p>
        <p><strong>Address:</strong> Montreal</p>
        <p><strong>Email:</strong><a href="mailto:sunlightourism@hotels.ca"></strong>sunlightourism@hotels.ca</a></p>
    </div>

    <div class="hotel">
        <h2>Zenith Hotel&Spa</h2>
        <p><strong>Phone:</strong> +1 (519)342-9621</p>
        <p><strong>Address:</strong> Toronto</p>
        <p><strong>Email:</strong><a href="mailto:zenithhotelspa@hotels.ca"></strong>zenithhotelspa@hotels.ca</a></p>
    </div>

    <div class="hotel">
        <h2>Crystal Lillies Resorts</h2>
        <p><strong>Phone:</strong> +1 (519) 796-2942</p>
        <p><strong>Address:</strong> Ottawa</p>
        <p><strong>Email:</strong><a href="mailto:crystallilliesresorts@hotels.ca"></strong>crystallilliesresorts@hotels.ca</a></p>
    </div>
</section>

</body>
</html>