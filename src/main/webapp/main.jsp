<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
            background-color: #031d59; /* Dark background color */
            overflow: hidden;
        }

        #navbar h1{
            margin-left: 50px;
            color: white;
            font-size: xx-large;
        }
        #navbar ul {
            list-style-type: none; /* Remove bullets */
            margin: 0;
            padding: 0;
            display: flex;
        }

        #navbar li {
            flex: 1;
            text-align: center;
        }

        #navbar li a {
            display: block;
            color: rgb(170, 197, 255);
            padding: 35px 10px; /* Adjust padding as needed */
            text-decoration: none;
        }

        #navbar li a:hover {
            background-color: #555; /* Darker background color on hover */
        }
    </style>
<body>
    <header>
        <nav id="navbar">
            <ul>
            <h1> EHotels</h1>
            <li><a href="main.jsp">Home</a></li>
            <li><a href="searching.jsp">Book</a></li>
            <li><a href="contact.html">Contact</a></li>
            <li><a href="#employeelogin">Employee Login</a></li>
            </ul>
            </nav>
    </header>

</body>
</html>