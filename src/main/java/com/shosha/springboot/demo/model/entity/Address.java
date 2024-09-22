package com.shosha.springboot.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "address_id", nullable = false)
    private String id;

    @Column(name = "street_address", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "postal_code", nullable = false)
    private String zipCode;

    @Column(name = "country", nullable = false)
    private String country;

    @OneToMany(mappedBy = "address")
    private List<Instructor> instructors;

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", instructors=" + (instructors != null ? instructors.size() : "null") +
                '}';
    }
}
