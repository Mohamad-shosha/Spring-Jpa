package com.shosha.springboot.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDto {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private AddressDto address;
    private CourseDto course;
}
