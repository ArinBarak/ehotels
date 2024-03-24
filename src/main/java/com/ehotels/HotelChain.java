package com.ehotels;

public class HotelChain{
    private String chain_name; //key
    private String address_of_central;
    private Integer num_of_hotels;
    private String email;
    private String phone_number;


    /**
     * Constructor for Hotel Chain
     *
     * @param chain_name
     * @param address_of_central
     * @param num_of_hotels
     * @param email
     * @param phone_number
     */
    public HotelChain(String chain_name, String address_of_central, Integer num_of_hotels, String email, String phone_number){
     this.chain_name=chain_name;
     this.address_of_central=address_of_central;
     this.num_of_hotels=num_of_hotels;
     this.email=email;
     this.phone_number=phone_number;
    }

    //setters
    public void setChain_name(String chain_name) { this.chain_name = chain_name; }
    public void setAddress_of_central(String address_of_central) { this.address_of_central = address_of_central; }
    public void setNum_of_hotels(Integer num_of_hotels) { this.num_of_hotels = num_of_hotels; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    //getters
    public String getChain_name() { return chain_name; }
    public String getAddress_of_central() { return address_of_central; }
    public Integer getNum_of_hotels() { return num_of_hotels; }
    public String getEmail() { return email; }
    public String getPhone_number() { return phone_number; }
}
