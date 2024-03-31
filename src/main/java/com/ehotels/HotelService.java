package com.ehotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class HotelService {

    /**
     * Method to get hotels filtered by entered location(city)
     * @param location
     * @return
     * @throws Exception
     */
    public List<Integer> getHotelsByLocation(String location) throws Exception {

        // sql query
        String sql =  "SELECT * FROM \"eHotels\".hotel WHERE city=?;";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to get hotels by location from database
        List<Integer> hotels = new ArrayList<Integer>();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);
            String selectedcity = "'"+location+"'";
            stmt.setString(1, location);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // append hotel_id in hotels list
                hotels.add(rs.getInt("hotel_id"));
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
            throw new Exception();
        }
    }

    public String getHotelNameById(Integer hotel_id) throws Exception {

        // sql query
        String sql = "SELECT * FROM \"eHotels\".hotel WHERE hotel_id=?";
        // connection object
        ConnectionDB db = new ConnectionDB();
        String result;

        // data structure to get hotels by location from database
        List<String> hotels = new ArrayList<String>();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, hotel_id);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                try {
                    if (hotel_id == rs.getInt("hotel_id")) {
                        // append hotel_id in hotels list
                        result = rs.getString("hotel_name");
                        return result;
                    }
                }
                catch (SQLException e) {
                    throw new SQLException();
                }
            }

            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();
            return null;
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
