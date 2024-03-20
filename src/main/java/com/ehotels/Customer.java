package com.ehotels;

public class Customer {

    private Integer id;
    private String fullname;
    private String address;
    private String id_type;
    private String registration_date;
    private String room_number;

    /**
     * Constructor to save Customer's data
     *
     * @param id identification of customer
     * @param fullname name and surname of customer
     * @param address city of customer
     * @param id_type identification type of customer
     * @param registration_date registration date of customer
     * @param room_number room number which the customer reserved
     */
    public Customer(Integer id, String fullname, String address, String id_type, String registration_date, String room_number){
        this.id= id;
        this.fullname=fullname;
        this.address=address;
        this.id_type=id_type;
        this.registration_date=registration_date;
        this.room_number=room_number;
    }

    //getters

    public Integer getId() { return id; }
    public String getFullname() { return fullname; }
    public String getAddress() { return address; }
    public String getId_type() { return id_type; }
    public String getRegistration_date() { return registration_date; }
    public String getRoom_number() { return room_number; }

    //setters
    public void setId(Integer id) { this.id = id; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public void setAddress(String address) { this.address = address; }
    public void setId_type(String id_type) { this.id_type = id_type; }
    public void setRegistration_date(String registration_date) { this.registration_date = registration_date; }
    public void setRoom_number(String room_number) {this.room_number = room_number; }
}


