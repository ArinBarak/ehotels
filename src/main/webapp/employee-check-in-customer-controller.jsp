<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.Customer" %>
<%@ page import="com.ehotels.CustomerService" %>
<%@ page import="com.ehotels.BookingService" %>
<%@ page import="com.ehotels.Message" %>
<%@ page import="java.util.ArrayList" %>

<%-- this is the final action page for checking in a customer --%>
<%-- if successful, it redirects to "success.jsp" page --%>
<%-- if not, it redirects to "not-found.jsp" page --%>

<%
    String booking_ref = request.getParameter("booking_reference");
    Integer b_id = Integer.parseInt(booking_ref);
    BookingService bookingservice = new BookingService();
    CustomerService customerservice = new CustomerService();
    Boolean isAnExistingBooking = false;

    try {
        isAnExistingBooking = bookingservice.foundBooking(b_id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    if (isAnExistingBooking){
        Integer c_id = bookingservice.getCustomerIdFromBooking(b_id);
        Boolean checkingIn = customerservice.checkInCustomer(c_id);
        response.sendRedirect("success.jsp");
    }
    else{
        response.sendRedirect("not-found.jsp");
    }

%>
