<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.RoomService" %>
<%@ page import="com.ehotels.Room" %>
<%@ page import="com.ehotels.Message" %>
<%@ page import="java.util.ArrayList" %>


<%
       String location = request.getParameter("location");
       String capacity = request.getParameter("capacity");
       // get all available rooms from database
       RoomService roomService = new RoomService();
       List<Rooms> rooms = null;
       try {
           rooms = roomService.getSearchedRooms(location, capacity);
       } catch (Exception e) {
           e.printStackTrace();
       }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Rooms</title>

</head>
<body>
    <jsp:include page="main.jsp"/>
    <h2>List of Rooms</h2>
    <div>
        <%
            if (rooms != null && !rooms.isEmpty()) {
                for (Room room : rooms) {
        %>
        <div>
            <p>Room ID: <%= room.getRoom_id() %></p>
            <p>Hotel Name: <%= room.getHotel_name() %></p>
            <p>Capacity: <%= room.getCapacity() %></p>
            <p>View: <%= room.getView() %></p>
            <p>Room Number: <%= room.getRoom_number() %></p>
            <p>Amenities: <%= room.getAmenities() %></p>
            <p>Price: <%= room.getPrice() %></p>
            <form action="book-room-customer-info.jsp" method="post">
                <input type="hidden" name="room_id" value="<%= room.getId() %>">
                <input type="hidden" name="room_number" value="<% room.getRoom_number() %>">
                <input type="submit" value="Book">
            </form>
        </div>
        <%
                }
            } else {
        %>
        <p>No rooms found.</p>
        <%
            }
        %>
    </div>
</body>
</html>