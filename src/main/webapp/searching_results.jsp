<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.RoomService" %>
<%@ page import="com.ehotels.Room" %>
<%@ page import="com.ehotels.Message" %>
<%@ page import="com.ehotels.HotelService" %>
<%@ page import="java.util.ArrayList" %>

<%-- this page shows the available rooms to the customer filtered by their search --%>

<%
       String location = request.getParameter("location");
       String capacity = request.getParameter("capacity");
       // get all available rooms from database
       RoomService roomService = new RoomService();
       HotelService hotelservice = new HotelService();
       List<Integer> test = hotelservice.getHotelsByLocation(location);
       List<Room> rooms = new ArrayList<Room>();
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        #h2{
            text-align: center;
            margin-left: 20px;
        }
        .rounded-box {
            border-radius: 15px;
            border: 1px solid #ced4da;
            box-shadow: 0px 0px 20px rgba(184, 184, 255, 0.98);
            padding: 10px;
            margin-bottom: 20px;
            margin-left: 10px;
            width: 1500px;
        }

        .room-info {
            display: flex;
            flex-wrap: wrap;
        }

        .info-item {
            flex: 1 1 50px;
            margin-right: 3px;
        }
        .btn-submit-custom {
            border-radius: 15px;
            padding: 10px 10px;
            box-shadow: 0px 0px 5px rgba(0, 0, 110, 0.8);
            background-color: rgb(0, 0, 110);
            color: white;
            text-align:center;
            line-height: 10px;
            width: 60px;
            height: 30px;
        }
    </style>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <h2>List of Rooms</h2>
    <div>
        <%
            if (rooms != null && !rooms.isEmpty()) {
                for (Room room : rooms) {
                    String h_name = hotelservice.getHotelNameById(room.getHotel_id());
        %>
        <div class="rounded-box">
            <div class="room-info">
                <div class="info-item">
                    <p><%= h_name %></p>
                </div>
                <div class="info-item">
                    <p><%= room.getCapacity() %> Room</p>
                </div>
                <div class="info-item">
                    <p>Room #<%= room.getRoom_number() %></p>
                </div>
                <%
                    String viewstr;
                    if(room.getSeaview() && room.getMountview()){
                        viewstr = "Sea & Mountain View";
                    }else if(room.getSeaview()){
                        viewstr = "Sea View";
                    }else if(room.getSeaview()){
                        viewstr = "Mountain View";
                    }else {
                        viewstr="No View";
                    }
                %>
                <div class="info-item">
                    <p><%=viewstr%></p>
                </div>
                <div class="info-item">
                    <p>Amenities:<%= room.getAmenities() %></p>
                </div>
                <div class="info-item">
                    <p>Damage: <%= room.getDamage() %></p>
                </div>
                <div class="info-item">
                    <p>Extension: <%= room.getExtension() %></p>
                </div>
                <div class="info-item">
                    <p>Price per night ($): <%= room.getPrice() %></p>

                </div>
                <form action="book-room-customer-info.jsp" method="post">
                    <input type="hidden" name="room_id" value="<%= room.getRoom_id() %>">
                    <input type="hidden" name="hotel_name" value="<%= h_name %>">
                    <input type="hidden" name="room_number" value="<%= room.getRoom_number() %>">
                    <input type="submit" class="btn btn-primary btn-submit-custom" value="Book">
                </form>
            </div>
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