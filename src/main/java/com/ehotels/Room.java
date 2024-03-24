package com.ehotels;

public class Room {
    private Integer room_id; //primary key
    private Integer room_number;
    private String hotel_name;
    private Integer price;
    private String capacity;
    private String amenities;
    private String damage;
    private String view;
    private Boolean extension;
    private Boolean isbooked;


    /**
     * Constructor for Room
     *
     * @param room_id
     * @param room_number
     * @param hotel_name
     * @param price
     * @param capacity
     * @param amenities
     * @param damage
     * @param view
     * @param extension
     * @param isbooked
     */
    public Room(Integer room_id, Integer room_number,String hotel_name, Integer price, String capacity,
                String amenities, String damage, String view, Boolean extension, Boolean isbooked){
        this.room_id=room_id;
        this.room_number=room_number;
        this.hotel_name=hotel_name;
        this.price=price;
        this.capacity=capacity;
        this.amenities=amenities;
        this.damage=damage;
        this.view=view;
        this.extension=extension;
        this.isbooked=isbooked;
    }

    //setters
    public void setRoom_id(Integer room_id) { this.room_id = room_id; }
    public void setRoom_number(Integer room_number) { this.room_number = room_number; }
    public void setHotel_name(String hotel_name) { this.hotel_name = hotel_name; }
    public void setPrice(Integer price) { this.price = price; }
    public void setCapacity(String capacity) { this.capacity = capacity; }
    public void setAmenities(String amenities) { this.amenities = amenities; }
    public void setDamage(String damage) { this.damage = damage; }
    public void setView(String view) { this.view = view; }
    public void setExtension(Boolean extension) { this.extension = extension; }
    public void setIsbooked(Boolean isbooked) { this.isbooked = isbooked; }

    //getters
    public Integer getRoom_id() { return room_id; }
    public Integer getRoom_number() { return room_number; }
    public String getHotel_name() { return hotel_name; }
    public Integer getPrice() { return price; }
    public String getCapacity() { return capacity; }
    public String getAmenities() { return amenities; }
    public String getDamage() { return damage; }
    public String getView() { return view; }
    public Boolean getExtension() { return extension; }
    public Boolean getIsbooked() { return isbooked; }
}
