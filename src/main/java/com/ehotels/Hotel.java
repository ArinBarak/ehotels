package com.ehotels;

public class Hotel {

    private String hotel_id;
    private String chain_name;
    private Integer num_of_rooms;
    private String email;
    private String phone_number;
    private Integer rating; //aka category


    /**
     * Constructor for Hotel
     *
     * @param hotel_id
     * @param chain_name
     * @param num_of_rooms
     * @param email
     * @param phone_number
     * @param rating
     */
    public Hotel(String hotel_id, String chain_name, Integer num_of_rooms,
                 String email, String phone_number, Integer rating){
        this.hotel_id=hotel_id; //key
        this.chain_name=chain_name;
        this.num_of_rooms=num_of_rooms;
        this.email=email;
        this.phone_number=phone_number;
        this.rating=rating;
    }

    //setters
    public void setHotel_id(String hotel_id) { this.hotel_id = hotel_id; }
    public void setChain_name(String chain_name) { this.chain_name = chain_name; }
    public void setNum_of_rooms(Integer num_of_rooms) { this.num_of_rooms = num_of_rooms; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }
    public void setRating(Integer rating) { this.rating = rating; }

    //getters
    public String getHotel_id() { return hotel_id; }
    public String getChain_name() { return chain_name; }
    public Integer getNum_of_rooms() { return num_of_rooms; }
    public String getEmail() { return email; }
    public String getPhone_number() { return phone_number; }
    public Integer getRating() { return rating; }
}
