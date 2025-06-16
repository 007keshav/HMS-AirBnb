package com.psa.bookingservice.client;


import com.psa.bookingservice.dto.APIResponse;
import com.psa.bookingservice.dto.PropertyDto;
import com.psa.bookingservice.dto.RoomAvailability;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "PROPERTYSERVICE")
public interface PropertyClient {

    @GetMapping("/api/v1/property/property-id")
    public APIResponse<PropertyDto> getPropertyById(@RequestParam long id);

    @GetMapping("/api/v1/property/room-available-room-id")
    public APIResponse<List<RoomAvailability>> getTotalRoomsAvailable(@RequestParam long id);


    @GetMapping("/api/v1/property/room-id")
    public APIResponse<com.psa.bookingservice.dto.Rooms> getRoomType(@RequestParam long id);

    @PutMapping("/api/v1/property/updateRoomCount")
    public APIResponse<Boolean> updateRoomCount(
            @RequestParam("id") long id,
            @RequestParam("date") LocalDate date
    );

}
