<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.Employee" %>
<%@ page import="com.ehotels.EmployeeService" %>
<%@ page import="com.ehotels.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    String em_id = request.getParameter("e_id");
    Integer e_id = Integer.parseInt(em_id);
    EmployeeService employeeservice = new EmployeeService();

    try {
        if (employeeservice.isAnEmployee(e_id)){
            response.sendRedirect("employee-check-in-customer.jsp");
        }else{
            response.sendRedirect("not-found.jsp");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

%>
