package com.ehotels;

public class Employee {

    private Integer employee_id;
    private String full_name;
    private String address;
    private String ssn_sin;
    private String hotel_id;

    /**
     * Constructor for employee
     * @param employee_id
     * @param full_name
     * @param address
     * @param ssn_sin
     * @param hotel_id
     */
    public Employee(Integer employee_id, String full_name, String address,
                    String ssn_sin,String hotel_id){
        this.employee_id=employee_id; //key
        this.full_name=full_name;
        this.address=address;
        this.ssn_sin=ssn_sin;
        this.hotel_id=hotel_id;
    }

    //setters
    public void setEmployee_id(Integer employee_id) { this.employee_id = employee_id; }
    public void setFull_name(String full_name) { this.full_name = full_name; }
    public void setAddress(String address) { this.address = address; }
    public void setHotel_id(String hotel_id) { this.hotel_id = hotel_id; }
    public void setSsn_sin(String ssn_sin) { this.ssn_sin = ssn_sin; }

    //getters
    public Integer getEmployee_id() { return employee_id; }
    public String getFull_name() { return full_name; }
    public String getAddress() { return address; }
    public String getHotel_id() { return hotel_id; }
    public String getSsn_sin() { return ssn_sin; }
}
