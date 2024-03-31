package com.ehotels;

import java.time.LocalDate;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    /**
     * Method for getting all bookings
     *
     * @return
     * @throws Exception
     */
    public List<Booking> getBookings() throws Exception {

        // sql query
        String sql = "SELECT * FROM \"eHotels\".booking";
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
                        rs.getInt("booking_id"),
                        rs.getString("room_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("room_num")
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
            throw new Exception();
        }
    }


    /**
     * Method for inserting a booking into the database
     * @param booking
     * @return
     * @throws Exception
     */
    public Boolean createBooking(Booking booking) throws Exception {
        Boolean result = false;
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();
        System.out.println(booking.getBooking_ref());
        System.out.println(booking.getRoom_id());
        System.out.println(booking.getCustomer_id());
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

        // sql query
        String insertBookingQuery = "INSERT INTO \"eHotels\".booking (booking_id, customer_id, room_num, check_in_date, check_out_date, room_id) VALUES (?, ?, ?, ?, ?, ?);";

        // try connect to database, catch any exceptions
        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertBookingQuery);

            // set every ? of statement
            stmt.setInt(1, booking.getBooking_ref());
            stmt.setInt(2, booking.getCustomer_id());
            stmt.setInt(3, booking.getRoom_number());
            stmt.setDate(4, sqlDate);
            stmt.setDate(5, null);
            stmt.setString(6, booking.getRoom_id());



            // execute the query
            int output = stmt.executeUpdate();
            System.out.println(output);
            result = true;
            // close the statement
            stmt.close();
            // close the connection
            db.close();
        } catch (Exception e) {
            throw new Exception();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
        }

        // return respective message
        return result;
    }

    /**
     * Method for checking if the booking exists
     * @param booking_ref
     * @return
     * @throws Exception
     */
    public Boolean foundBooking(Integer booking_ref) throws Exception {

        Boolean result = false;

        // sql query
        String sql = "SELECT * FROM \"eHotels\".booking";
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
                if (booking_ref==rs.getInt("booking_id")){
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
            throw new Exception();
        }
    }

    /**
     * Method to get the customers id by their booking
     *
     * @param booking_ref
     * @return
     * @throws Exception
     */
    public Integer getCustomerIdFromBooking(Integer booking_ref) throws Exception {

        Integer cust_id = 0;

        // sql query
        String sql = "SELECT * FROM \"eHotels\".booking";
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
                if (booking_ref==rs.getInt("booking_id")){
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
            throw new Exception();
        }
    }
}
