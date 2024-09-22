package com.shosha.springboot.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "course_id", nullable = false)
    private String id;

    @Column(name = "course_name", unique = true, nullable = false)
    private String name;

    @Column(name = "course_code", unique = true, nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "course")
    private List<Instructor> instructors;
}
