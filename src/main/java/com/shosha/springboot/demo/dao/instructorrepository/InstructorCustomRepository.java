package com.shosha.springboot.demo.dao.instructorrepository;

import com.shosha.springboot.demo.model.entity.Address;
import com.shosha.springboot.demo.model.entity.Instructor;

/**
 * The InstructorCustomRepository interface provides custom methods for querying
 * instructor-related data.
 */
public interface InstructorCustomRepository {
    /**
     * Retrieves the ID of an instructor based on their email address.
     *
     * @param email the email address of the instructor
     * @return the ID of the instructor associated with the given email address,
     * or null if no instructor is found with that email
     */
    String getIdByEmail(String email);

    /**
     * Retrieves the course code associated with the given instructor's email address.
     *
     * @param email the email address of the instructor
     * @return the course code associated with the given email address, or null if no course is found for that email
     */
    String getCourseCodeByEmail(String email);

    /**
     * Retrieves the address associated with the given instructor's email address.
     *
     * @param email the email address of the instructor
     * @return the Address associated with the given email address,
     * or null if no address is found for that email
     */
    Address getAddressByEmail(String email);

    /**
     * Retrieves the address associated with the given course name.
     *
     * @param courseName the name of the course
     * @return the Address associated with the given course name,
     * or null if no address is found for that course name
     */
    Address getAddressByCourseName(String courseName);

    /**
     * Retrieves the address associated with the given instructor.
     *
     * @param instructor the instructor whose address needs to be retrieved
     * @return the address of the instructor, or null if no address is found
     */
    Address getAddressFromInstructor(Instructor instructor);
}
