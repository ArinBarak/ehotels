package com.ehotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class RoomService {

    /**
     * Method for getting all non-booked (available) rooms
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
                        throw  new SQLException();
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
            throw new Exception(;
        }
    }

    /**
     * Method for getting all non-booked rooms filtered by the entered location(city) and capacity
     * @param location
     * @param capacity
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
        //creating a list to have hotels in the entered location
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
                //checking if the room is in the desired location
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
            throw new Exception();
        }
    }

    /**
     * Method for booking a room
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
            throw new Exception();
        } finally {
            if (con != null) con.close();
        }

        // return respective message
        return result;
    }
}
