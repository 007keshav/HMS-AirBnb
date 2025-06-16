package com.psa.propertyservice.repository;

import com.psa.propertyservice.entity.RoomAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RoomAvailabilityRepository extends JpaRepository<RoomAvailability,Long> {
    public List<RoomAvailability> findByRoomId(long id);

    @Query("SELECT ra FROM RoomAvailability ra WHERE ra.room.id = :id AND ra.availableDate = :date")
    RoomAvailability findByRoomIdAndAvailableDate(@Param("id") Long id, @Param("date") LocalDate date);


}
