<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.CustomerService" %>
<%@ page import="com.ehotels.Customer" %>
<%@ page import="com.ehotels.Booking" %>
<%@ page import="com.ehotels.BookingService" %>
<%@ page import="com.ehotels.RoomService" %>
<%@ page import="com.ehotels.Message" %>
<%@ page import="java.util.ArrayList" %>

<%-- this page is the final page for booking action --%>
<%-- if the booking is successful, it show the booking information to the customer --%>
<%-- if it is unsuccessful, it directs customer to "not-found.jsp" page --%>

<%
    //get values
    Boolean done= false;
    Boolean done1 = false;
    Boolean done2 = false;
    String id = request.getParameter("cust_id");
    Integer customer_id = Integer.parseInt(id);
    String fullname = request.getParameter("fullname");
    String address = request.getParameter("address");
    String id_type = request.getParameter("id_type");
    String room_id = request.getParameter("room_id");
    String room_number = request.getParameter("room_number");
    String hotel_name = request.getParameter("hotel_name");

    BookingService bookingservice = new BookingService();
    RoomService roomservice = new RoomService();
    CustomerService customerservice = new CustomerService();
    Customer customer = new Customer(customer_id, fullname, address, id_type, room_id, 0);

    String reference = id+room_number;
    Integer booking_ref = Integer.valueOf(reference);
    Integer r_num = Integer.parseInt(room_number);
    Booking booking = new Booking(booking_ref, room_id, customer_id, r_num);


        done = customerservice.createCustomer(customer);
        done1 = roomservice.bookRoom(room_id);
        done2= bookingservice.createBooking(booking);

%>

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
            background-color: #f0f0f0;
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
            width: 300px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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
    <%
        if(done && done1 && done2){
    %>
    <div class="centered-container">
        <div class="rounded-box">
            <div class="room-info">
                <div class="info-item">
                    <p>Success!</p>
                </div>
                <div class="info-item">
                    <p>Booking Reference: <%=booking_ref%></p>
                </div>
                <div class="info-item">
                    <p>Booked with <%= hotel_name %></p>
                </div>
                <div class="info-item">
                    <p>Room #<%= room_number%></p>
                </div>
            </div>
        </div>
    </div>
    <%
    }else{
       response.sendRedirect("not-found.jsp");
    }
    %>
</body>

</html>