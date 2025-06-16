package com.psa.bookingservice.repository;

import com.psa.bookingservice.entity.BookingDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDateRepository extends JpaRepository<BookingDate, Long> {

}
