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



    public PropertyPhotos() {
    }

    public PropertyPhotos(long id, String url, Property property) {
        this.id = id;
        this.url = url;
        this.property = property;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
