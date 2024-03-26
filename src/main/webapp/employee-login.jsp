<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.demo.Employee" %>
<%@ page import="com.demo.EmpoyeeService" %>
<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    Integer e_id = request.getParameter("e_id");
    EmployeeService employeeservice = new EmployeeService();
    Boolean isEmployee;

    try {
        isEmployee = employeeservice.isAnEmployee(e_id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    if (isEmployee){
        response.sendRedirect("employee-check-in-customer.jsp");
    }
    else{
        response.redirect("not-found.jsp");
    }

%>
