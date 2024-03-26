<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.demo.Customer" %>
<%@ page import="com.demo.CustomerService" %>

<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    String booking_ref = request.getParameter("booking_reference");
    BookingService bookingservice = new BookingService();
    CustomerService customerservice = new CustomerService();
    Boolean isAnExistingBooking;

    try {
        isAnExistingBooking = bookingservice.foundBooking(booking_ref);
    } catch (Exception e) {
        e.printStackTrace();
    }
    if (isAnExistingBooking){
        Integer c_id = bookingservice.getCustomerIdFromBooking(booking_ref);
        Boolean checkingIn = customerservice.checkInCustomer(c_id);
        response.sendRedirect("success.jsp");
    }
    else{
        response.redirect("not-found.jsp");
    }

%>