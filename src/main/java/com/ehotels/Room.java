package com.ehotels;

import java.math.BigDecimal;

public class Room {
    private String room_id; //primary key
    private Integer room_number;
    private Integer hotel_id;
    private String price;
    private String capacity;
    private String amenities;
    private String damage;
    private Boolean seaview;
    private Boolean mountview;
    private Boolean extension;
    private Boolean isbooked;
    private String address;

    /**
     * Constructor for room
     * @param room_id
     * @param room_number
     * @param hotel_id
     * @param price
     * @param capacity
     * @param amenities
     * @param damage
     * @param seaview
     * @param mountview
     * @param extension
     * @param isbooked
     * @param address
     */
    public Room(String room_id, Integer room_number,Integer hotel_id, String price, String capacity,
                String amenities, String damage, Boolean seaview, Boolean mountview, Boolean extension, Boolean isbooked,
                String address){
        this.room_id=room_id;
        this.room_number=room_number;
        this.hotel_id=hotel_id;
        this.price=price;
        this.capacity=capacity;
        this.amenities=amenities;
        this.damage=damage;
        this.seaview=seaview;
        this.mountview=mountview;
        this.extension=extension;
        this.isbooked=isbooked;
        this.address=address;
    }

    //setters
    public void setRoom_id(String room_id) { this.room_id = room_id; }
    public void setRoom_number(Integer room_number) { this.room_number = room_number; }
    public void setHotel_name(Integer hotel_id) { this.hotel_id = hotel_id; }
    public void setPrice(String price) { this.price = price; }
    public void setCapacity(String capacity) { this.capacity = capacity; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
    public void setDamage(String damage) { this.damage = damage; }
    public void setSeaview(Boolean seaview) {this.seaview = seaview;}
    public void setMountview(Boolean mountview) {this.mountview = mountview;}
    public void setExtension(Boolean extension) { this.extension = extension; }
    public void setIsbooked(Boolean isbooked) { this.isbooked = isbooked; }
    public void setAddress(String address) { this.address = address; }

    //getters
    public String getRoom_id() { return room_id; }
    public Integer getRoom_number() { return room_number; }
    public Integer getHotel_id() { return hotel_id; }
    public String getPrice() { return price; }
    public String getCapacity() { return capacity; }
    public String getAmenities() { return amenities; }
    public String getDamage() { return damage; }
    public Boolean getSeaview() {return seaview;}
    public Boolean getMountview() {return mountview;}
    public Boolean getExtension() { return extension; }
    public Boolean getIsbooked() { return isbooked; }
    public String getAddress() { return address; }
}
