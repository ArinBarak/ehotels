package com.ehotels;

public class Hotel {

    private Integer hotel_id;
    private String hotel_name;
    private String chain_name;
    private String address;
    private String city;
    private Integer num_of_rooms;
    private String email;
    private String phone_number;
    private Integer rating; //aka category


    /**
     * Constructor for Hotel
     * @param hotel_id
     * @param chain_name
     * @param city
     * @param num_of_rooms
     * @param email
     * @param phone_number
     * @param rating
     * @param hotel_name
     * @param address
     */
    public Hotel(Integer hotel_id, String chain_name, String city, Integer num_of_rooms,
                 String email, String phone_number, Integer rating, String hotel_name, String address){
        this.hotel_id=hotel_id; //key
        this.chain_name=chain_name;
        this.city=city;
        this.num_of_rooms=num_of_rooms;
        this.email=email;
        this.phone_number=phone_number;
        this.rating=rating;
        this.address=address;
        this.hotel_name=hotel_name;
    }

    //setters
    public void setHotel_id(Integer hotel_id) { this.hotel_id = hotel_id; }
    public void setChain_name(String chain_name) { this.chain_name = chain_name; }
    public void setcity(String address) { this.city = address; }
    public void setNum_of_rooms(Integer num_of_rooms) { this.num_of_rooms = num_of_rooms; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }
    public void setRating(Integer rating) { this.rating = rating; }
    public void setHotel_name(String hotel_name) { this.hotel_name = hotel_name; }
    public void setAddress(String address) { this.address = address; }

    //getters
    public Integer getHotel_id() { return hotel_id; }
    public String getChain_name() { return chain_name; }
    public String getCity() { return city; }
    public Integer getNum_of_rooms() { return num_of_rooms; }
    public String getEmail() { return email; }
    public String getPhone_number() { return phone_number; }
    public Integer getRating() { return rating; }
    public String getHotel_name() { return hotel_name; }
    public String getAddress() { return address; }
}
