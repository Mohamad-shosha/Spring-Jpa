package com.shosha.springboot.demo.util.transformation;

import com.shosha.springboot.demo.model.dto.CourseDto;
import com.shosha.springboot.demo.model.entity.Course;
import com.shosha.springboot.demo.util.randomids.RandomValues;

/**
 * Utility class providing methods to transform between Course entity and CourseDto.
 */
public class CourseTransformation {

    private CourseTransformation() {

    }

    /**
     * Transforms a Course entity into a CourseDto.
     *
     * @param course the Course entity to be transformed
     * @return the transformed CourseDto
     */
    public static CourseDto transformToCourseDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setName(course.getName());
        courseDto.setCode(course.getCode());
        courseDto.setDescription(course.getDescription());
        return courseDto;
    }

    /**
     * Transforms a CourseDto object to a Course entity object.
     *
     * @param courseDto the CourseDto object that needs to be transformed
     * @return the transformed Course entity object with a newly generated ID,
     *         and the same name, code, and description as the input CourseDto
     */
    public static Course transformToCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setId(RandomValues.randomNumbersForId());
        course.setName(courseDto.getName());
        course.setCode(courseDto.getCode());
        course.setDescription(courseDto.getDescription());
        return course;
    }
}
