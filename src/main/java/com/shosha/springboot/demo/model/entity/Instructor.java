package com.shosha.springboot.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "instructor")
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @Column(name = "instructor_id", nullable = false)
    private String id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private String birthDate;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "address_id")
    private String addressId;

    @Column(name = "course_id")
    private String courseId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @Override
    public String toString() {
        return "Instructor{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", addressId='" + addressId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }

}
