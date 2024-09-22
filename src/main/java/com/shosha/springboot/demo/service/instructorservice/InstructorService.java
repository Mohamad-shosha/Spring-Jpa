package com.shosha.springboot.demo.service.instructorservice;

import com.shosha.springboot.demo.error.exception.InstructorNotFoundException;
import com.shosha.springboot.demo.error.exception.SqlConstraintException;
import com.shosha.springboot.demo.model.dto.AddressDto;
import com.shosha.springboot.demo.model.dto.InstructorDto;
import com.shosha.springboot.demo.model.entity.Instructor;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for handling Instructor-related operations.
 */
public interface InstructorService {

    /**
     * Retrieves a list of all instructors.
     *
     * @return a list of InstructorDto objects representing all instructors
     */
    List<InstructorDto> findAll();

    /**
     * Retrieves a list of all instructors whose first name matches the given string.
     *
     * @param firstName the first name to search for among instructors
     * @return a list of InstructorDto objects that match the provided first name
     */
    List<InstructorDto> findAllByFirstName(String firstName);

    /**
     * Retrieves an instructor by their unique identifier.
     *
     * @param id The unique identifier of the instructor to be retrieved.
     * @return The instructor matching the given id.
     * @throws InstructorNotFoundException if no instructor is found with the given id.
     */
    Instructor findById(String id) throws InstructorNotFoundException;

    /**
     * Retrieves the InstructorDto associated with the specified ID.
     *
     * @param id the unique identifier of the instructor
     * @return the InstructorDto corresponding to the given ID
     * @throws InstructorNotFoundException if no instructor is found with the given ID
     */
    InstructorDto getInstructorDtoById(String id) throws InstructorNotFoundException;

    /**
     * Finds the ID of an instructor by their email address.
     *
     * @param email the email address of the instructor
     * @return the ID of the instructor
     * @throws InstructorNotFoundException if no instructor is found with the given email
     */
    String findIdByEmail(String email) throws InstructorNotFoundException;

    /**
     * Finds the course code associated with the instructor identified by the given email.
     *
     * @param email the email address of the instructor whose course code is to be found
     * @return the course code of the instructor
     * @throws InstructorNotFoundException if no instructor is found with the given email
     */
    String findCourseCodeByEmail(String email) throws InstructorNotFoundException;

    /**
     * Finds an instructor by their email address.
     *
     * @param email the email address of the instructor to find
     * @return an Optional containing the found Instructor, or an empty Optional if no instructor is found with the given email
     * @throws InstructorNotFoundException if no instructor with the specified email exists
     */
    Optional<Instructor> findInstructorByEmail(String email) throws InstructorNotFoundException;

    /**
     * Finds the address information of an instructor by their email.
     *
     * @param email the email of the instructor whose address information is to be retrieved
     * @return the address information of the instructor as an AddressDto object
     * @throws InstructorNotFoundException if no instructor is found with the provided email
     */
    AddressDto findAddressByEmail(String email) throws InstructorNotFoundException;

    /**
     * Persists the provided InstructorDto object. This may involve inserting or updating
     * records depending on the state of the provided object.
     *
     * @param instructorDto the instructor DTO containing information to be saved
     * @throws SqlConstraintException if there is a violation of SQL constraints during save
     */
    void save(InstructorDto instructorDto) throws SqlConstraintException;

    /**
     * Updates the details of an existing instructor identified by the provided id.
     *
     * @param instructorDto the data transfer object containing the updated details of the instructor
     * @param id the unique identifier of the instructor to be updated
     * @throws InstructorNotFoundException if no instructor is found with the provided id
     */
    void update(InstructorDto instructorDto, String id) throws InstructorNotFoundException;

    /**
     * Deletes the instructor with the specified unique identifier.
     *
     * @param id The unique identifier of the instructor to be deleted.
     * @throws InstructorNotFoundException if no instructor is found with the given id.
     */
    void delete(String id) throws InstructorNotFoundException;

    /**
     * Finds the address information associated with the instructor of the given course name.
     *
     * @param courseName the name of the course for which the associated instructor's address is to be found
     * @return the address information of the instructor as an AddressDto object
     * @throws InstructorNotFoundException if no instructor is found for the provided course name
     */
    AddressDto findAddressByCourseName(String courseName) throws InstructorNotFoundException;
}
