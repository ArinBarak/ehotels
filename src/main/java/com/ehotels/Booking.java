package com.ehotels;

public class Booking {

    private Integer booking_number;
    private Integer room_id;
    private Integer customer_id;

    /**
     * Constructor for Bookings
     *
     * @param booking_number booking reference number
     * @param room_id booked room's id
     * @param customer_id id of the customer
     */
    public Booking(Integer booking_number, Integer room_id, Integer customer_id){
        this.booking_number=booking_number;
        this.room_id=room_id;
        this.customer_id=customer_id;
    }

    //setters
    public void setBooking_number(Integer booking_number) { this.booking_number = booking_number; }
    public void setRoom_id(Integer room_id) { this.room_id = room_id; }
    public void setCustomer_id(Integer customer_id) { this.customer_id = customer_id; }

    //getters
    public Integer getBooking_number() { return booking_number; }
    public Integer getRoom_id() { return room_id; }
    public Integer getCustomer_id() { return customer_id; }
}
