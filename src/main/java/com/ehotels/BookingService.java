package com.ehotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    /**
     * Method to get all bookings from database
     *
     * @return list of all available rooms found in database
     * @throws Exception when trying to connect to database
     */
    public List<Booking> getBookings() throws Exception {

        // sql query
        String sql = "SELECT * FROM booking";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all bookings retrieved from database
        List<Booking> bookings = new ArrayList<Booking>();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new booking object
                Booking booking = new Booking(
                        rs.getInt("booking_number"),
                        rs.getInt("room_id"),
                        rs.getInt("customer_id")
                );
                // append room in rooms list
                bookings.add(booking);
            }

            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();

            // return result
            return bookings;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    /**
     * Method to create a booking in the database
     *
     * @param booking student to be created
     * @return string returned that states if the booking created or not
     * @throws Exception when trying to connect to database
     */
    public String createBooking(Booking booking) throws Exception {
        String message = "";
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();
        System.out.println(booking.getBooking_number());
        System.out.println(booking.getRoom_id());
        System.out.println(booking.getCustomer_id());

        // sql query
        String insertBookingQuery = "INSERT INTO bookings (booking_id, room_id, customer_id) VALUES (?, ?, ?);";

        // try connect to database, catch any exceptions
        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertBookingQuery);

            // set every ? of statement
            stmt.setInt(1, booking.getBooking_number());
            stmt.setInt(2, booking.getRoom_id());
            stmt.setInt(3, booking.getCustomer_id());

            // execute the query
            int output = stmt.executeUpdate();
            System.out.println(output);

            // close the statement
            stmt.close();
            // close the connection
            db.close();
        } catch (Exception e) {
            message = "Error while inserting customer: " + e.getMessage();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "Booking made successfully!";

        }

        // return respective message
        return message;
    }

    /**
     * Method to update student
     *
     * @param student student to be updated
     * @return string returned that states if the grade deleted or not
     * @throws Exception when trying to connect to database
     *//*
    public String updateStudent(Student student) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "UPDATE students SET name=?, surname=?, email=? WHERE id=?;";
//        "UPDATE students SET name=" + student.getName().toString() +", surname=" +

        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try {
            // get connection
            con = db.getConnection();

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // set every ? of statement
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurname());
            stmt.setString(3, student.getEmail());
            stmt.setInt(4, student.getId());

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating student: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Student successfully updated!";
        }

        // return respective message
        return message;
    }
*/
}
