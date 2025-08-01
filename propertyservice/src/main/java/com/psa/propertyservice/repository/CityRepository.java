package com.psa.propertyservice.repository;

import com.psa.propertyservice.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
    City findByName(String area);
}
