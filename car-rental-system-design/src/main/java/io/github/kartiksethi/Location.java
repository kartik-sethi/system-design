package io.github.kartiksethi;

public class Location {
    private final int id;
    private final String address;
    private final String city;
    private final String state;
    private final String zipCode;

    public Location(int id, String address, String city, String state, String zipCode) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
}
