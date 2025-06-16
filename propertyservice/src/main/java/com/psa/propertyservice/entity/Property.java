package com.psa.propertyservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "number_of_beds")
    private int numberOfBeds;

    @Column(name="number_of_rooms")
    private int numberOfRooms;

    @Column(name="number_of_bathrooms")
    private int numberOfBathrooms;
    @Column(name="number_of_guests_allowed")
    private int numberOfGuestAllowed;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name="area_id")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne
    @JoinColumn(name="pincode_id")
    private PinCode pinCode;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JsonBackReference
    private List<Rooms> rooms = new ArrayList<>();


    public int getNumberOfGuestAllowed() {
        return numberOfGuestAllowed;
    }

    public void setNumberOfGuestAllowed(int numberOfGuestAllowed) {
        this.numberOfGuestAllowed = numberOfGuestAllowed;
    }

    public Property() {
    }

    public Property(long id, String name, int numberOfBeds, int numberOfRooms, int numberOfBathrooms, City city, Area area, State state, PinCode pinCode, List<Rooms> rooms) {
        this.id = id;
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.city = city;
        this.area = area;
        this.state = state;
        this.pinCode = pinCode;
        this.rooms = rooms;
    }

    public Property(long id, String name, int numberOfBeds, int numberOfRooms, int numberOfBathrooms, City city, Area area, State state, List<Rooms> rooms) {
        this.id = id;
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.city = city;
        this.area = area;
        this.state = state;
        this.rooms = rooms;
    }

    public PinCode getPinCode() {
        return pinCode;
    }

    public void setPinCode(PinCode pinCode) {
        this.pinCode = pinCode;
    }

    public Property(String name, int numberOfBeds, int numberOfRooms, int numberOfBathrooms, City city, Area area, State state, List<Rooms> rooms) {
        this.name = name;
        this.numberOfBeds = numberOfBeds;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.city = city;
        this.area = area;
        this.state = state;
        this.rooms = rooms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }

}
