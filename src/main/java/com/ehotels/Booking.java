package com.ehotels;

public class Booking {

    private Integer booking_ref;
    private String room_id;
    private Integer customer_id;
    private Integer room_number;
    private String check_in_date;
    private String check_out_date;

    /**
     * Constructor for Bookings
     *
     * @param booking_ref booking reference number
     * @param room_id booked room's id
     * @param customer_id id of the customer
     */
    public Booking(Integer booking_ref, String room_id, Integer customer_id, Integer room_number){
        this.booking_ref=booking_ref;
        this.room_id=room_id;
        this.customer_id=customer_id;
        this.room_number=room_number;
        this.check_in_date=null;
        this.check_out_date = null;
    }

    //setters
    public void setBooking_number(Integer booking_ref) { this.booking_ref = booking_ref; }
    public void setRoom_id(String room_id) { this.room_id = room_id; }
    public void setRoom_number(Integer room_number) {this.room_number = room_number;}
    public void setCustomer_id(Integer customer_id) { this.customer_id = customer_id; }

    //getters
    public Integer getBooking_ref() { return booking_ref; }
    public Integer getRoom_number() {return room_number;}
    public String getRoom_id() { return room_id; }
    public Integer getCustomer_id() { return customer_id; }
}
