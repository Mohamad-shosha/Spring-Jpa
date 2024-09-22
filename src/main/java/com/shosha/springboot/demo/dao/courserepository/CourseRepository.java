package com.shosha.springboot.demo.dao.courserepository;

import com.shosha.springboot.demo.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for managing Course entities.
 *
 * Provides CRUD operations and additional methods for managing
 * courses in the system.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    /**
     * Checks if a course exists by its name and code.
     *
     * @param name the name of the course
     * @param code the code of the course
     * @return true if a course with the given name and code exists, false otherwise
     */
    boolean existsByNameAndCode(String name, String code);
}
