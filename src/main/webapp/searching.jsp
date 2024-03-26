<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.RoomService" %>
<%@ page import="com.ehotels.Room" %>
<%@ page import="com.ehotels.Message" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <title>EHotels | Search</title>

</head>

<body>
    <jsp:include page="main.jsp"/>

    <div class="container">
        <div class="row" id="row">
            <div class="col-md-12">
                <form class="form-horizontal" name="searching" action="searching-results.jsp" method="POST">
                    <div class="form-group col-sm-6">
                        <label for="location">Location</label>
                        <input type="text" class="form-control" name="location" placeholder="Location">
                    </div>
                    <div class="form-group col-sm-6">
                        <label for="capacity">Capacity</label>
                        <input type="text" class="form-control" name="capacity" placeholder="Choose Room Capacity">
                    </div>
                    <div class="form-group col-sm-12">
                        <button type="submit" class="btn btn-primary btn-submit-custom">Search</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>

</html>