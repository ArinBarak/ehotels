package com.ehotels;

public class Booking {

    private String booking_ref; //key
    private Integer room_id; //key
    private Integer customer_id; //key

    /**
     * Constructor for Bookings
     *
     * @param booking_ref booking reference number
     * @param room_id booked room's id
     * @param customer_id id of the customer
     */
    public Booking(String booking_ref, Integer room_id, Integer customer_id){
        this.booking_ref=booking_ref;
        this.room_id=room_id;
        this.customer_id=customer_id;
    }

    //setters
    public void setBooking_number(String booking_ref) { this.booking_ref = booking_ref; }
    public void setRoom_id(Integer room_id) { this.room_id = room_id; }
    public void setCustomer_id(Integer customer_id) { this.customer_id = customer_id; }

    //getters
    public String getBooking_ref() { return booking_ref; }
    public Integer getRoom_id() { return room_id; }
    public Integer getCustomer_id() { return customer_id; }
}
