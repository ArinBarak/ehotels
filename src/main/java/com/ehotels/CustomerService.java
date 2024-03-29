package com.ehotels;

import java.time.LocalDate;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    /**
     * Method to get all customers from database
     *
     * @return list of all available customers found in database
     * @throws Exception when trying to connect to database
     */
    public List<Customer> getCustomers() throws Exception {

        // sql query
        String sql = "SELECT * FROM \"eHotels\".customer";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all customers retrieved from database
        List<Customer> customers = new ArrayList<Customer>();
        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);


        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new customer object
                Customer customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("full_name"),
                        rs.getString("address"),
                        rs.getString("id_type"),
                        rs.getString( "room_number"),
                        rs.getInt("ischeckedin")
                );
                // append customer in customers list
                customers.add(customer);
            }


            // close result set
            rs.close();
            // close statement
            stmt.close();
            con.close();
            db.close();

            // return result
            return customers;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method for inserting a customer to database
     *
     * @param customer
     * @return
     * @throws Exception
     */
    public Boolean createCustomer(Customer customer) throws Exception {
        Boolean result = false;
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();
        System.out.println(customer.getId());
        System.out.println(customer.getFullname());
        System.out.println(customer.getRoom_number());

        // sql query
        String insertCustomerQuery =
                "INSERT INTO \"eHotels\".customer (customer_id, full_name, address, id_type, reg_date, room_num, ischeckedin) VALUES (?, ?, ?, ?, ?, ?, ?);";

        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
        // try connect to database, catch any exceptions
        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertCustomerQuery);

            // set every ? of statement
            stmt.setInt(1, customer.getId());
            stmt.setString(2, customer.getFullname());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getId_type());
            stmt.setDate(5, sqlDate);
            stmt.setString(6, customer.getRoom_number());
            stmt.setInt(7, customer.getCheckedIn());

            // execute the query
            int output = stmt.executeUpdate();
            System.out.println(output);
            result = true;

            // close the statement
            stmt.close();
            // close the connection
            db.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
        }

        // return respective message
        return result;
    }

    /**
     * Method to check in a customer (only employees will use this function)
     *
     * @param customer_id
     * @return
     * @throws Exception
     */
    public Boolean checkInCustomer(Integer customer_id) throws Exception {
        Connection con = null;
        String message = "";

        Boolean result;

        // sql query
        String sql = "UPDATE \"eHotels\".customer SET ischeckedin=? WHERE customer_id=?;";

        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try {
            // get connection
            con = db.getConnection();

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // set every ? of statement
            stmt.setInt(1, 1);
            stmt.setInt(2, customer_id);

            // execute the query
            stmt.executeUpdate();
            result = true;

            // close the statement
            stmt.close();

        } catch (Exception e) {
            result = false;
            message = "Error while updating student: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) {
                result = true;
                message = "Customer checked in successfully!";
            }
        }

        // return respective message
        return result;
    }


}
