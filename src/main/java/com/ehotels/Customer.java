package com.ehotels;

import java.sql.Date;
import java.time.LocalDate;

public class Customer {

    private Integer id;
    private String fullname;
    private String address;
    private String id_type;
    private Date registration_date;
    private String room_id;
    private Integer isCheckedIn; // 0 if not checked in, 1 if ischeckedin

    /**
     * Constructor
     *
     * @param id
     * @param fullname
     * @param address
     * @param id_type
     * @param room_id
     * @param isCheckedIn
     */
    public Customer(Integer id, String fullname, String address, String id_type,
                    String room_id, Integer isCheckedIn){
        this.id= id; //key
        this.fullname=fullname;
        this.address=address;
        this.id_type=id_type;
        this.room_id=room_id;
        this.isCheckedIn=isCheckedIn;

        LocalDate currentDate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
        this.registration_date=sqlDate;
    }

    //getters

    public Integer getId() { return id; }
    public String getFullname() { return fullname; }
    public String getAddress() { return address; }
    public String getId_type() { return id_type; }
    public Date getRegistration_date() { return registration_date; }
    public String getRoom_number() { return room_id; }
    public void setCheckedIn(Integer checkedIn) { isCheckedIn = checkedIn; }

    //setters
    public void setId(Integer id) { this.id = id; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public void setAddress(String address) { this.address = address; }
    public void setId_type(String id_type) { this.id_type = id_type; }
    public void setRegistration_date(Date registration_date) { this.registration_date = registration_date; }
    public void setRoom_number(String room_number) {this.room_id = room_number; }
    public Integer getCheckedIn() { return isCheckedIn; }
}


