package com.psa.propertyservice.repository;

import com.psa.propertyservice.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Long> {
    State findByName(String name);
}
