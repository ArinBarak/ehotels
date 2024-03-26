package com.ehotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    /**
     * Method to get all available rooms
     *
     * @return
     * @throws Exception
     */
    public List<Room> getAllRooms() throws Exception {

        // sql query
        String sql = "SELECT * FROM room";
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
                if(!rs.getBoolean("isbooked")) {

                    Room room = new Room(
                            rs.getString("room_id"),
                            rs.getInt("room_number"),
                            rs.getString("hotel_name"),
                            rs.getInt("price"),
                            rs.getString("capacity"),
                            rs.getString("amenities"),
                            rs.getString("damage"),
                            rs.getString("view"),
                            rs.getBoolean("extension"),
                            rs.getBoolean("isbooked")
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
        String sql = "SELECT * FROM room";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all searched rooms retrieved from database
        List<Room> rooms = new ArrayList<Room>();
        HotelService hs = new HotelService();
        List<String> hotelsInLoc = hs.getHotelsByLocation(location);

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {

                if(hotelsInLoc.contains(rs.getString("hotel_name")) &&
                        capacity==(rs.getString("capacity"))) {

                    Room room = new Room(
                            rs.getString("room_id"),
                            rs.getInt("room_number"),
                            rs.getString("hotel_name"),
                            rs.getInt("price"),
                            rs.getString("capacity"),
                            rs.getString("amenities"),
                            rs.getString("damage"),
                            rs.getString("view"),
                            rs.getBoolean("extension"),
                            rs.getBoolean("isbooked")
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
    public String bookRoom(String room_id) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "UPDATE room SET isbooked=? WHERE id=?;";

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

            // close the statement
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating rooms: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Room successfully booked!";
        }

        // return respective message
        return message;
    }
}
