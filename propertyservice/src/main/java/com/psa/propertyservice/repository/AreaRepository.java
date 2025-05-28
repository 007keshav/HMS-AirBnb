package com.psa.propertyservice.repository;

import com.psa.propertyservice.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AreaRepository extends JpaRepository<Area,Long> {
    Area findByName(String name);
}
