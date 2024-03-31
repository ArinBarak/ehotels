<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.Employee" %>
<%@ page import="com.ehotels.EmployeeService" %>
<%@ page import="java.util.ArrayList" %>

<%-- this is a page to check if the employee exists --%>
<%-- if true, it redirects to "employee-check-in-customer.jsp" page --%>
<%-- if false, it redirects to "not-found.jsp" page --%>

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
