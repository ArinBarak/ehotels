<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- this is the navbar of ehotels --%>

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

        /* Navbar styles */
        #navbar {
            background-color: #031d59;
            overflow: hidden;
        }

        #navbar ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
        }

        #eh {
             color: rgb(255, 251, 0);
             padding: 35px 10px;
             text-decoration: none;
             font-weight: bold;
             font-size: 25px;
        }

        #navbar li {
            flex: 1;
            text-align: center;
        }

        #navbar li a {
            display: block;
            color: rgb(199, 209, 255);
            padding: 35px 10px;
            text-decoration: none;
        }

        #navbar li a:hover {
            background-color: #555;
        }
    </style>
<body>
    <header>
        <nav id="navbar">
            <ul>
            <li><a id ="eh" href="main.jsp">EHotels</a></li>
            <li><a href="searching.jsp">Book</a></li>
            <li><a href="contact.jsp">Contact</a></li>
            <li><a href="employee.jsp">Employee Login</a></li>
            </ul>
            </nav>
    </header>
</body>
</html>