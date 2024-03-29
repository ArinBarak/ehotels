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

    /*try{
        null;
    }catch (Exception e) {
             e.printStackTrace();
    }*/

    if(done2){
        response.sendRedirect("success.jsp");
    }else{
        response.sendRedirect("not-found.jsp");
    }

%>