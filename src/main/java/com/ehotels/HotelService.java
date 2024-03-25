package com.ehotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelService {

    /**
     * method to get hotels by location
     *
     * @param location
     * @return
     * @throws Exception
     */
    public List<String> getHotelsByLocation(String location) throws Exception {

        // sql query
        String sql = "SELECT * FROM hotel";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to get hotels by location from database
        List<String> hotels = new ArrayList<String>();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new student object
                if(location == rs.getString("address")) {
/*
                    Hotel hotel = new Hotel(
                            rs.getString("hotel_id"),
                            rs.getString("chain_name"),
                            rs.getString("address"),
                            rs.getInt("num_of_rooms"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getInt("rating")
                    );*/
                    // append room in rooms list
                    hotels.add(rs.getString("hotel_id"));
                }
            }

            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();

            // return result
            return hotels;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
