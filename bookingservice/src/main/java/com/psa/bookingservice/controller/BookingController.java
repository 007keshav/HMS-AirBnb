package com.psa.bookingservice.controller;

import com.psa.bookingservice.client.PropertyClient;
import com.psa.bookingservice.dto.*;
import com.psa.bookingservice.entity.BookingDate;
import com.psa.bookingservice.entity.Bookings;
import com.psa.bookingservice.repository.BookingDateRepository;
import com.psa.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {


    @Autowired
    private PropertyClient propertyClient;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingDateRepository bookingDateRepository;


    @PostMapping("/add-to-cart")
    public APIResponse<List<String>> cart(@RequestBody BookingDto bookingDto) {

        Optional<RoomAvailability> matchedRoom = java.util.Optional.empty();

        APIResponse<List<String>> apiResponse = new APIResponse<>();

        List<String> messages = new ArrayList<>();

        APIResponse<PropertyDto> response = propertyClient.getPropertyById(bookingDto.getPropertyId());

        APIResponse<Rooms> roomType = propertyClient.getRoomType(bookingDto.getRoomId());

        APIResponse<List<RoomAvailability>> totalRoomsAvailable = propertyClient.getTotalRoomsAvailable(bookingDto.getRoomId());

        List<RoomAvailability> availableRooms = totalRoomsAvailable.getData();

        //Logic to check available rooms based on date and count
        for(LocalDate date: bookingDto.getDate()) {
            boolean isAvailable = availableRooms.stream()
                    .anyMatch(ra -> ra.getAvailableDate().equals(date) && ra.getAvailableCount()>0);


            System.out.println("Date " + date + " available: " + isAvailable);

            if (!isAvailable) {
                messages.add("Room not available on: " + date);
                apiResponse.setMessage("Sold Out");
                apiResponse.setStatus(500);
                apiResponse.setData(messages);
                return apiResponse;
            }

            matchedRoom = availableRooms.stream()
                    .filter(ra -> ra.getAvailableDate().equals(date) && ra.getAvailableCount() >0)
                    .findFirst();

            if(matchedRoom.isPresent()){
                Long id = matchedRoom.get().getId();
            }
        }
        //Save it to Booking Table with status pending
        Bookings bookings = new Bookings();
        bookings.setName(bookingDto.getName());
        bookings.setEmail(bookingDto.getEmail());
        bookings.setMobile(bookingDto.getMobile());
        bookings.setPropertyName(response.getData().getName());
        bookings.setStatus("pending");
        bookings.setTotalPrice(roomType.getData().getBasePrice()*bookingDto.getTotalNigths());
        Bookings savedBooking = bookingRepository.save(bookings);

        for(LocalDate date: bookingDto.getDate()) {
            BookingDate bookingDate = new BookingDate();
            bookingDate.setDate(date);
            bookingDate.setBookings(savedBooking);
            BookingDate savedBookingDate =  bookingDateRepository.save(bookingDate);

            propertyClient.updateRoomCount(matchedRoom.get().getRoom().getId(), date);
        }
        return null;
    }




}
