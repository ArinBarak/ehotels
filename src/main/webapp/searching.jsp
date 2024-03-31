<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.RoomService" %>
<%@ page import="com.ehotels.Room" %>
<%@ page import="java.util.ArrayList" %>

<%-- this the searching/book page --%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EHotels | Search</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body, html {
                margin: 0;
                font-family: Arial, sans-serif;
            }

            body {
                background-color: #f8f9fa;
            }

            .container {
                position: absolute;
                top: 50%;
                left: 60%;
                transform: translate(-50%, -50%);
            }

            .rounded-box {
                border-radius: 50px;
                padding: 10px;
                width: 1000px;
                height: 300px;

            }

            .form-control {
                border-radius: 15px;
                border: 1px solid #ced4da;
                box-shadow: 0px 0px 20px rgba(173, 179, 255, 0.729);
                width: 300px;
                height: 60px;
            }

            .btn-submit-custom {
                border-radius: 15px;
                padding: 10px 10px;
                box-shadow: 0px 0px 20px rgba(173, 179, 255, 0.729);
                width: 120px;
                height: 60px;
            }

            #container2{
                position: absolute;
                top: 70%;
            }
        </style>
</head>

<body>
    <jsp:include page="navbar.jsp"/>

    <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <form class="form-horizontal rounded-box" name="searching" action="searching_results.jsp" method="POST">
                        <div class="form-row align-items-center">
                            <div class="form-group col">
                                    <select id="selectOption" class="form-control" name="location" placeholder="Location">
                                        <option value="Ottawa">Ottawa</option>
                                        <option value="Toronto">Toronto</option>
                                        <option value="Vancouver">Vancouver</option>
                                        <option value="Montreal">Montreal</option>
                                        <option value="Edmonton">Edmonton</option>
                                        <option value="Quebec City">Quebec City</option>
                                        <option value="Halifax">Halifax</option>
                                    </select>
                            </div>
                            <div class="form-group col">
                                <select id="selectOption" class="form-control" name="capacity" placeholder="Location">
                                        <option value="Single">Single Room</option>
                                        <option value="Double">Double Room</option>
                                        <option value="Triple">Triple Room</option>
                                        <option value="Quad">Quad Room</option>
                                        <option value="Suite">Suite</option>
                                        <option value="Family">Family Suite</option>
                                        <option value="Executive">Executive Suite</option>
                                </select>
                            </div>
                            <div class="form-group col">
                                <button type="submit" class="btn btn-primary btn-submit-custom">Search</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container" id="container2">
            <div class="row">
                <div class="col-md-12">
                    <div class="room-descriptions">
                        <h2>Room Descriptions</h2>
                        <p><strong>Single Room:</strong> Typically accommodates one guest with a single bed.</p>
                        <p><strong>Double Room:</strong> Accommodates two guests with either a double bed or two twin beds.</p>
                        <p><strong>Triple Room:</strong> Designed to accommodate three guests, usually with three single beds or one double bed and one single bed.</p>
                        <p><strong>Quad Room:</strong> Intended for four guests, typically with two double beds or one double bed and two single beds.</p>
                        <p><strong>Suite:</strong> A spacious accommodation with separate living and sleeping areas, suitable for various capacities depending on the suite's size and configuration.</p>
                        <p><strong>Family Suite:</strong> Can accommodate a family with multiple beds or separate sleeping areas, suitable for four or more guests.</p>
                        <p><strong>Executive Suite:</strong> A spacious room or set of rooms with additional amenities and space, ideal for business travelers or guests seeking luxury accommodations.</p>
                    </div>
                </div>
            </div>
        </div>


</body>

</html>