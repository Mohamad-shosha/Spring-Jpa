package com.shosha.springboot.demo.dao.instructorrepository;

import com.shosha.springboot.demo.model.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Instructor entities. This interface
 * extends JpaRepository to leverage basic CRUD operations and support pagination
 * and sorting. It also implements InstructorCustomRepository to allow for custom
 * query methods that are not provided by default.
 */
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String>, InstructorCustomRepository {
    /**
     * Checks if an instructor exists with the given email.
     *
     * @param email the email to check for existence
     * @return true if an instructor exists with the given email, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Retrieves a list of instructors that have the specified first name.
     *
     * @param firstName the first name of the instructors to be retrieved
     * @return a list of instructors with the specified first name
     */
    List<Instructor> findAllByFirstName(String firstName);

    /**
     * Finds an instructor by their email address.
     *
     * @param email the email address of the instructor
     * @return an Optional containing the found Instructor, or an empty Optional if no instructor is found
     */
    Optional<Instructor> findByEmail(String email);

    Optional<Instructor> findByCourseName(String courseName);
}
