<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.demo.RoomService" %>
<%@ page import="com.demo.Room" %>
<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
       // get all available rooms from database
       RoomService roomService = new RoomService();
       List<Rooms> rooms = null;
       try {
           rooms = roomService.getRooms();
       } catch (Exception e) {
           e.printStackTrace();
       }
%>


<!DOCTYPE html>
<html>
<head>
    <title>EHotels | Books</title>

</head>

<body>
    <jsp:include page="main.jsp"/>


</body>

</html>