package com.psa.propertyservice.repository;

import com.psa.propertyservice.entity.PinCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PincodeRepository extends JpaRepository<PinCode,Long> {
    PinCode findByPinCode(int value);
}
