package com.psa.propertyservice.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psa.propertyservice.dto.APIResponse;
import com.psa.propertyservice.dto.PropertyDto;
import com.psa.propertyservice.entity.Property;
import com.psa.propertyservice.entity.RoomAvailability;
import com.psa.propertyservice.entity.Rooms;
import com.psa.propertyservice.repository.RoomAvailabilityRepository;
import com.psa.propertyservice.service.PropertyService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService ;

    @Autowired
    private RoomAvailabilityRepository roomAvailabilityRepository;
    //private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @PostMapping(
            value = "/add-property",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,  // Ensures the endpoint accepts multipart/form-data
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<APIResponse> addProperty(
            @RequestParam("property") String propertyJson,                  // Use RequestParam to get the property as a raw JSON string
            @RequestParam("files") MultipartFile[] files) {  // Use RequestParam to handle files

        // Log the multipart parts
//        logger.info("Property JSON: " + propertyJson);
//        logger.info("Number of files uploaded: " + (files != null ? files.length : 0));

        // Parse the property JSON into PropertyDto
        ObjectMapper objectMapper = new ObjectMapper();
        PropertyDto dto = null;
        try {
            dto = objectMapper.readValue(propertyJson, PropertyDto.class);  // Convert JSON string to PropertyDto
        } catch (JsonProcessingException e) {
           // logger.error("Error parsing property JSON", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Handle bad JSON
        }

        // Process the property and files
        Property property = propertyService.addProperty(dto, files);

        // Create response object
        APIResponse<Property> response = new APIResponse<>();
        response.setMessage("Property added");
        response.setStatus(201);
        response.setData(property);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/search-property")
    public APIResponse searchProperty(
            @RequestParam String name,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        APIResponse response = propertyService.searchProperty(name, date);
        return response;
    }

    @GetMapping("/property-id")
    public APIResponse<PropertyDto> getPropertyById(@RequestParam long id){
        APIResponse<PropertyDto> response = propertyService.findPropertyById(id);
        return response;
    }

    @GetMapping("/room-available-room-id")
    public APIResponse<List<RoomAvailability>> getTotalRoomsAvailable(@RequestParam long id){
        List<RoomAvailability> totalRooms = propertyService.getTotalRoomsAvailable(id);

        APIResponse<List<RoomAvailability>> response = new APIResponse<>();
        response.setMessage("Total rooms");
        response.setStatus(200);
        response.setData(totalRooms);
        return response;
    }

    @GetMapping("/room-id")
    public APIResponse<Rooms> getRoomType(@RequestParam long id){
        Rooms room = propertyService.getRoomById(id);

        APIResponse<Rooms> response = new APIResponse<>();
        response.setMessage("Total rooms");
        response.setStatus(200);
        response.setData(room);
        return response;
    }
    @PutMapping("/updateRoomCount")
    public APIResponse<Boolean> updateRoomCount(
            @RequestParam long id,
            @RequestParam  LocalDate date
    ) {
        RoomAvailability roomsAvailable = roomAvailabilityRepository.findByRoomIdAndAvailableDate(id,date);
        APIResponse<Boolean> response = new APIResponse<>();
        if (roomsAvailable == null) {
            response.setMessage("Room availability record not found");
            response.setStatus(404);
            response.setData(false);
            return response;
        }

        int count = roomsAvailable.getAvailableCount();
        if(count > 0) {
            roomsAvailable.setAvailableCount(count - 1);
            roomAvailabilityRepository.save(roomsAvailable);
            response.setMessage("updated");
            response.setStatus(200);
            response.setData(true);
            return response;
        }
        else {
            response.setMessage("no availability");
            response.setStatus(500);
            response.setData(false);
            return response;
        }

    }



}
