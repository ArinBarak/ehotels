<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.CustomerService" %>
<%@ page import="com.ehotels.Customer" %>
<%@ page import="com.ehotels.Booking" %>
<%@ page import="com.ehotels.BookingService" %>
<%@ page import="com.ehotels.RoomService" %>
<%@ page import="com.ehotels.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    //get values
    String id = request.getParameter("cust_id");
    String fullname = request.getParameter("fullname");
    String address = request.getParameter("address");
    String id_type = request.getParameter("id_type");
    String registration_date = request.getParameter("registration_date");
    String room_id = request.getParameter("room_id");

    BookingService bookingservice = new BookingService();
    RoomService roomservice = new RoomService();
    CustomerService customerservice = new CustomerService();
    Customer customer = new Customer(id, fullname, address, id_type, registration_date, room_id, false);

    String reference = id+"-"+room_id+"-"+fullname;
    Booking booking = new Booking(reference, room_id, id);

    try{
        String value = customerservice.createCustomer(customer);
        String value2 = roomservice.bookRoom(room_id);
        String value3 = bookingservice.createBooking(booking);

    }catch (Exception e) {
             e.printStackTrace();
    }

    response.sendRedirect("success.jsp");

%>