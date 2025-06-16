package com.psa.bookingservice.repository;

import com.psa.bookingservice.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Bookings, Long> {
}
