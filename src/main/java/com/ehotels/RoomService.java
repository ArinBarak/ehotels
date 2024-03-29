package com.ehotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class RoomService {

    /**
     * Method to get all available rooms
     *
     * @return
     * @throws Exception
     */
    public List<Room> getAllRooms() throws Exception {

        // sql query
        String sql = "SELECT * FROM \"eHotels\".room WHERE isbooked= ' false' " ;
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all available rooms retrieved from database
        List<Room> rooms = new ArrayList<Room>();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new room object
                //if(!rs.getBoolean("isbooked")) {
                    try {
                        Room room = new Room(
                                rs.getString("room_id"),
                                rs.getInt("room_num"),
                                rs.getInt("hotel_id"),
                                rs.getBigDecimal("price").toString(),
                                rs.getString("capacity"),
                                rs.getString("amenities"),
                                rs.getString("damage"),
                                rs.getBoolean("sea_view"),
                                rs.getBoolean("mount_view"),
                                rs.getBoolean("extension"),
                                rs.getBoolean("isbooked"),
                                rs.getString("address")
                        );
                        // append room in rooms list
                        rooms.add(room);
                    }
                    catch (SQLException e) {
                        // Handle any SQLExceptions that occur while retrieving data from the ResultSet
                        // Print error message or log it for debugging
                        System.err.println("Error while processing ResultSet: " + e.getMessage());
                    }
                //}
            }

            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();
            // return result
            return rooms;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * method to get rooms by search
     * @param location
     * @return
     * @throws Exception
     */
    public List<Room> getSearchedRooms(String location, String capacity) throws Exception {

        // sql query
        String sql = "SELECT * FROM \"eHotels\".room WHERE isbooked=' false' and capacity=?; ";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all searched rooms retrieved from database
        List<Room> rooms = new ArrayList<Room>();
        HotelService hs = new HotelService();
        List<Integer> hotelsInLoc = hs.getHotelsByLocation(location);

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, capacity);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                //try {
                    if (hotelsInLoc.contains(rs.getInt("hotel_id"))) {

                        Room room = new Room(
                                rs.getString("room_id"),
                                rs.getInt("room_num"),
                                rs.getInt("hotel_id"),
                                rs.getBigDecimal("price").toString(),
                                rs.getString("capacity"),
                                rs.getString("amenities"),
                                rs.getString("damage"),
                                rs.getBoolean("sea_view"),
                                rs.getBoolean("mount_view"),
                                rs.getBoolean("extension"),
                                rs.getBoolean("isbooked"),
                                rs.getString("address")
                        );
                        // append room in rooms list
                        rooms.add(room);
                    }
                //} catch (SQLException e) {
                    // Handle any SQLExceptions that occur while retrieving data from the ResultSet
                    // Print error message or log it for debugging
                //    System.err.println("Error while processing ResultSet: " + e.getMessage());
                //}
            }

            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();

            // return result
            return rooms;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method for booking the room by updating the "isbooked" variable of the room
     *
     * @param room_id
     * @return
     * @throws Exception
     */
    public Boolean bookRoom(String room_id) throws Exception {
        Connection con = null;
        Boolean result = false;

        // sql query
        String sql = "UPDATE \"eHotels\".room SET isbooked=? WHERE room_id=?;";

        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try {
            // get connection
            con = db.getConnection();

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // set every ? of statement
            stmt.setBoolean(1, true);
            stmt.setString(2, room_id);

            // execute the query
            stmt.executeUpdate();
            result = true;

            // close the statement
            stmt.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (con != null) con.close();
        }

        // return respective message
        return result;
    }
}
