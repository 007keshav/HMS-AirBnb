package com.psa.propertyservice.repository;

import com.psa.propertyservice.entity.PropertyPhotos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyPhotosRepository extends JpaRepository<PropertyPhotos,Long> {
}
