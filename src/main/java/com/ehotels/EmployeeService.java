package com.ehotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeService {

    /**
     *Method to check if the employee id appears in employee
     *
     * @param e_id
     * @return
     * @throws Exception
     */
    public Boolean isAnEmployee(Integer e_id) throws Exception {

        Boolean result = false;

        // sql query
        String sql = "SELECT * FROM employee";
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
                if (e_id==rs.getInt("employee_id")){
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
}
