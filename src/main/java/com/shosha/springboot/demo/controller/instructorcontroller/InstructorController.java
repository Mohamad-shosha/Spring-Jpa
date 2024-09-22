package com.shosha.springboot.demo.controller.instructorcontroller;

import com.shosha.springboot.demo.dao.addressrepository.AddressRepository;
import com.shosha.springboot.demo.dao.courserepository.CourseRepository;
import com.shosha.springboot.demo.error.exception.InstructorNotFoundException;
import com.shosha.springboot.demo.error.exception.SqlConstraintException;
import com.shosha.springboot.demo.model.dto.AddressDto;
import com.shosha.springboot.demo.model.dto.InstructorDto;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService,
                                AddressRepository addressRepository, CourseRepository courseRepository) {
        this.instructorService = instructorService;
    }

    @PostMapping("SaveInstructor")
    public void saveStudent(@RequestBody InstructorDto instructorDto) throws SqlConstraintException {
        instructorService.save(instructorDto);
    }

    @GetMapping("GetInstructors")
    public List<InstructorDto> getStudents() {
        return instructorService.findAll();
    }

    @GetMapping("GetInstructorByFirstName/{firstName}")
    public List<InstructorDto> getInstructorByFirstName(@PathVariable String firstName) {
        return instructorService.findAllByFirstName(firstName);
    }

    @PutMapping("UpdateInstructor/{id}")
    public void updateInstructor(@RequestBody InstructorDto instructorDto,
                                 @PathVariable String id) throws InstructorNotFoundException {
        instructorService.update(instructorDto, id);
    }

    @GetMapping("GetInstructor/{id}")
    public InstructorDto getInstructor(@PathVariable String id) {
        return instructorService.getInstructorDtoById(id);
    }

/*    @GetMapping("GetId/{email}")
    public String getIdOfTheInstructor(@PathVariable String email) {
        return instructorService.findIdByEmail(email);
    }*/

    @GetMapping("GetCourseCode/{email}")
    public String getCourseCodeOfTheInstructor(@PathVariable String email) {
        return instructorService.findCourseCodeByEmail(email);
    }

    @GetMapping("GetAddress/{email}")
    public AddressDto getAddressOfTheInstructor(@PathVariable String email) {
        return instructorService.findAddressByEmail(email);
    }

    @DeleteMapping("DeleteInstructor/{id}")
    public void deleteInstructorById(@PathVariable String id) {
        instructorService.delete(id);
    }

    @GetMapping("GetAddressByCourseName/{courseName}")
    public AddressDto getAddressByCourseName(@PathVariable String courseName) {
        return instructorService.findAddressByCourseName(courseName);
    }

}
