package com.psa.propertyservice.dto;

import java.util.List;

public class PropertyDto {
    private long id;

    private String name;

    private int numberOfBeds;

    private int numberOfRooms;

    private int numberOfBathrooms;

    private int numberOfGuestAllowed;

    private String city;

    private String area;

    private int pinCode;

    private String state;

    private List<RoomsDto> rooms;

    private List<String> imageUrls;





    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getNumberOfBeds() {
        return numberOfBeds;
    }
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }
    public int getNumberOfGuestAllowed() {
        return numberOfGuestAllowed;
    }
    public int getPinCode() {
        return pinCode;
    }
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }
    public String getArea() {
        return area;
    }
    public String getState() {
        return state;
    }
    public List<RoomsDto> getRooms() {
        return rooms;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PropertyDto(long id, String name, int numberOfBeds, int numberOfRooms, int numberOfBathrooms, int numberOfGuestAllowed, String city, String area, int pinCode, String state, List<RoomsDto> rooms, List<String> imageUrls) {
        this.id = id;
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfGuestAllowed = numberOfGuestAllowed;
        this.city = city;
        this.area = area;
        this.pinCode = pinCode;
        this.state = state;
        this.rooms = rooms;
        this.imageUrls = imageUrls;
    }

    public PropertyDto() {
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }
    public void setNumberOfGuestAllowed(int numberOfGuestAllowed) {
        this.numberOfGuestAllowed = numberOfGuestAllowed;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setRooms(List<RoomsDto> rooms) {
        this.rooms = rooms;
    }
    public List<String> getImageUrls() {
        return imageUrls;
    }
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
