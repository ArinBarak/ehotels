package com.ehotels;

public class Employee {

    private Integer employee_id;
    private String full_name;
    private String address;
    private String role_title;
    private Integer role_salary;
    private String hotel_id;

    /**
     * Constructor for Employee
     *
     * @param employee_id
     * @param full_name
     * @param address
     * @param role_title
     * @param role_salary
     * @param hotel_id
     */

    public Employee(Integer employee_id, String full_name, String address,
                    String role_title, Integer role_salary, String hotel_id){
        this.employee_id=employee_id; //key
        this.full_name=full_name;
        this.address=address;
        this.role_title=role_title;
        this.role_salary=role_salary;
        this.hotel_id=hotel_id;
    }

    //setters
    public void setEmployee_id(Integer employee_id) { this.employee_id = employee_id; }
    public void setFull_name(String full_name) { this.full_name = full_name; }
    public void setAddress(String address) { this.address = address; }
    public void setRole_title(String role_title) { this.role_title = role_title; }
    public void setRole_salary(Integer role_salary) { this.role_salary = role_salary; }
    public void setHotel_id(String hotel_id) { this.hotel_id = hotel_id; }

    //getters
    public Integer getEmployee_id() { return employee_id; }
    public String getFull_name() { return full_name; }
    public String getAddress() { return address; }
    public String getRole_title() { return role_title; }
    public Integer getRole_salary() { return role_salary; }
    public String getHotel_id() { return hotel_id; }
}
