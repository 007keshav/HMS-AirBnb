package com.psa.propertyservice.entity;


import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@RequestMapping("/api/v1/upload-photos")
public class PropertyPhotos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String url;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

}
