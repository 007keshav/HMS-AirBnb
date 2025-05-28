package com.psa.propertyservice.repository;

import com.psa.propertyservice.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Rooms,Long> {

}
