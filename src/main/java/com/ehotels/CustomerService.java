package com.ehotels;

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
        String sql = "SELECT * FROM customer";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all customers retrieved from database
        List<Customer> customers = new ArrayList<Customer>();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new booking object
                Customer customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getString("address"),
                        rs.getString("id_type"),
                        rs.getString("registration_date"),
                        rs.getString( "room_number"),
                        rs.getBoolean("isCheckedIn")
                );
                // append room in rooms list
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
     * Method for creating a customer to database
     *
     * @param customer
     * @return
     * @throws Exception
     */
    public String createCustomer(Customer customer) throws Exception {
        String message = "";
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();
        System.out.println(customer.getId());
        System.out.println(customer.getFullname());
        System.out.println(customer.getRoom_number());

        // sql query
        String insertCustomerQuery =
                "INSERT INTO customer (id, full_name, address, id_type, registration_date, room_number, isCheckedIn) VALUES (?, ?, ?, ?, ?, ?, ?);";

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
            stmt.setString(5, customer.getRegistration_date());
            stmt.setString(6, customer.getRoom_number());
            stmt.setBoolean(7, customer.getCheckedIn());

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
            if (message.equals("")) message = "Customer added successfully!";

        }

        // return respective message
        return message;
    }

    /**
     * Method to check in a customer (employees will use this function)
     *
     * @param customer
     * @return
     * @throws Exception
     */
    public String checkInCustomer(Customer customer) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "UPDATE customer SET isCheckedIn=? WHERE id=?;";

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
            stmt.setInt(2, customer.getId());

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating student: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Customer checked in successfully!";
        }

        // return respective message
        return message;
    }
}
