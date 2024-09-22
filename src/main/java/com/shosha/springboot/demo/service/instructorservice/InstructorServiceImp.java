package com.shosha.springboot.demo.service.instructorservice;

import com.shosha.springboot.demo.dao.courserepository.CourseRepository;
import com.shosha.springboot.demo.dao.instructorrepository.InstructorRepository;
import com.shosha.springboot.demo.error.exception.InstructorNotFoundException;
import com.shosha.springboot.demo.error.exception.SqlConstraintException;
import com.shosha.springboot.demo.model.dto.AddressDto;
import com.shosha.springboot.demo.model.dto.InstructorDto;
import com.shosha.springboot.demo.model.entity.Instructor;
import com.shosha.springboot.demo.util.transformation.AddressTransformation;
import com.shosha.springboot.demo.util.transformation.InstructorTransformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InstructorServiceImp implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public InstructorServiceImp(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<InstructorDto> findAll() {
        List<Instructor> instructors = instructorRepository.findAll();
        log.info("The list of instructors is {}", instructors);
        return instructors.stream().map(InstructorTransformation::transformToInstructorDto).toList();
    }

    @Override
    public List<InstructorDto> findAllByFirstName(String firstName) {
        List<Instructor> instructors = instructorRepository.findAllByFirstName(firstName);
        log.info("The list of instructors is {}, where first name is {}", instructors, firstName);
        return instructors.stream().map(InstructorTransformation::transformToInstructorDto).toList();
    }

    @Override
    public Instructor findById(String id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        if (!instructor.isPresent()) {
            log.error("Could not find instructor with id {}", id);
            throw new InstructorNotFoundException("Instructor not found with id : " + id);
        } else {
            log.info("The instructor is {}, with is {}", instructor.get(), instructor.get().getId());
            return instructor.get();
        }
    }

    @Override
    public InstructorDto getInstructorDtoById(String id) throws InstructorNotFoundException {
        return InstructorTransformation.transformToInstructorDto(findById(id));
    }

    @Override
    public String findIdByEmail(String email) throws InstructorNotFoundException {
        String id = instructorRepository.getIdByEmail(email);
        log.info("The id is {},Where email is {}", id, email);
        return id;
    }

    @Override
    public String findCourseCodeByEmail(String email) throws InstructorNotFoundException {
        String codeOfCourse = instructorRepository.getCourseCodeByEmail(email);
        log.info("The code is {},Where email is {}", codeOfCourse, email);
        return codeOfCourse;
    }

    @Override
    public Optional<Instructor> findInstructorByEmail(String email) throws InstructorNotFoundException {
        Optional<Instructor> instructor = instructorRepository.findByEmail(email);
        if (!instructor.isPresent()) {
            log.error("Instructor not found with email {}", email);
            throw new InstructorNotFoundException("Instructor not found with email : " + email);
        } else {
            log.info("The instructor is {},Where email is {}", instructor.get(), email);
            return instructor;
        }
    }

    @Override
    public void save(InstructorDto instructorDto) throws SqlConstraintException {
        Instructor instructor = InstructorTransformation.transformToStudent(instructorDto);
        if (instructorRepository.existsByEmail(instructorDto.getEmail()) ||
                courseRepository.existsByNameAndCode(instructor.getCourse().getName(),
                        instructorDto.getCourse().getCode())) {
            log.error("Duplicated data with email '{}' or course name '{}' or course code '{}' ",
                    instructorDto.getEmail(),
                    instructorDto.getCourse().getName(),
                    instructorDto.getCourse().getCode());
            throw new SqlConstraintException("Duplicate data entry doesn't allowed");
        }
        log.info("Saving new instructor {}", instructor);
        instructorRepository.save(instructor);
    }

    @Override
    public void update(InstructorDto instructorDto, String id) throws InstructorNotFoundException {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        if (instructor.isPresent()) {
            Instructor updatedInstructor = instructor.get();
            updatedInstructor.setFirstName(instructorDto.getFirstName());
            updatedInstructor.setLastName(instructorDto.getLastName());
            updatedInstructor.setEmail(instructorDto.getEmail());
            updatedInstructor.setBirthDate(instructorDto.getBirthDate());
            updatedInstructor.setAddress(updatedInstructor.getAddress());
            updatedInstructor.setCourse(updatedInstructor.getCourse());
            log.info("Updating instructor {}", updatedInstructor);
            instructorRepository.save(updatedInstructor);
        } else {
            log.error("Could not find instructor to update with id {}", id);
            throw new InstructorNotFoundException("Instructor not found with id : " + id);
        }

    }

    @Override
    public void delete(String id) throws InstructorNotFoundException {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        if (!instructor.isPresent()) {
            log.error("Could not find instructor to delete with id {}", id);
            throw new InstructorNotFoundException("Instructor not found with id : " + id);
        } else {
            log.info("Deleting instructor {}", instructor.get());
            instructorRepository.delete(instructor.get());
        }

    }

    @Override
    public AddressDto findAddressByEmail(String email) throws InstructorNotFoundException {
        Optional<Instructor> instructor = instructorRepository.findByEmail(email);
        if (!instructor.isPresent()) {
            log.error("Could not find instructor with email {}", email);
            throw new InstructorNotFoundException("Instructor not found with email : " + email);
        }
        log.info("Found address of the instructor {} whose address is {}", instructor.get(),
                instructor.get().getAddress());
        return AddressTransformation.transformToAddressDto(instructorRepository.getAddressByEmail(email));
    }

    public AddressDto findAddressByCourseName(String courseName) {
        Optional<Instructor> instructor = instructorRepository.findByCourseName(courseName);
        if (!instructor.isPresent()) {
            log.error("Could not find instructor with course name {}", courseName);
            throw new InstructorNotFoundException("Instructor not found with course name : " + courseName);
        }
        return AddressTransformation.transformToAddressDto(instructorRepository.
                getAddressByCourseName(courseName));
    }
}
