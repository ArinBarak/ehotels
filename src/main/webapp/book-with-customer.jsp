<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.demo.CustomerService" %>
<%@ page import="com.demo.Customer" %>
<%@ page import="com.demo.RoomService" %>
<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    //get values
    String id = request.getParameter("cust_id");
    String fullname = request.getParameter("fullname");
    String address = request.getParameter("address");
    String id_type = request.getParameter("id_type");
    String registration_date = request.getParameter("registration_date");
    String room_id = request.getParameter("room_id");

    RoomService roomservice = new RoomService();
    CustomerService customerservice = new CustomerService();
    Customer customer = new Customer(id, fullname, address, id_type, registration_date, room_id, false);

    try{
        String value = customerservice.createCustomer(customer);
        String value2 = roomservice.bookRoom(room_id);
    }

%>


<%


    Message msg;
    // try to create a new student
    try {

        String value = studentService.createStudent(student);
        // if the value contains error/Error then this is an error message
        if (value.contains("Error") || value.contains("error")) msg = new Message("error", value);
        // else the student was successfully created
        else msg = new Message("success", value);
    } catch (Exception e) {
        e.printStackTrace();
        msg = new Message("error", "Something went wrong!");
    }
    response.sendRedirect("index.jsp");
%>