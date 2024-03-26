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
                        rs.getString("booking_ref"),
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
     * @param booking booking to be created
     * @return string returned that states if the booking created or not
     * @throws Exception when trying to connect to database
     */
    public String createBooking(Booking booking) throws Exception {
        String message = "";
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();
        System.out.println(booking.getBooking_ref());
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
            stmt.setString(1, booking.getBooking_ref());
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
     * Method for employees to check if the booking_ref entered is an existing booking
     *
     * @param booking_ref
     * @return
     * @throws Exception
     */
    public Boolean foundBooking(String booking_ref) throws Exception {

        Boolean result = false;

        // sql query
        String sql = "SELECT * FROM booking";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                if (booking_ref==rs.getString("booking_ref")){
                    result = true;
                    break;
                }
            }


            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();

            // return result
            return result;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method toget the customers id by their booking
     *
     * @param booking_ref
     * @return
     * @throws Exception
     */
    public Integer getCustomerIdFromBooking(String booking_ref) throws Exception {

        Integer cust_id = 0;

        // sql query
        String sql = "SELECT * FROM booking";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                if (booking_ref==rs.getString("booking_ref")){
                    cust_id = rs.getInt("customer_id");
                    break;
                }
            }


            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();

            // return result
            return cust_id;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
