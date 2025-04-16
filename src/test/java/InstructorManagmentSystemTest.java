import com.shosha.springboot.demo.Main;
import com.shosha.springboot.demo.dao.instructorrepository.InstructorRepository;
import com.shosha.springboot.demo.model.entity.Instructor;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = Main.class)
public class InstructorManagmentSystemTest {

    private static MockHttpServletRequest request;

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorService instructorService;


    @BeforeEach
    public void setUp() {
        jdbc.execute("insert into instructor(instructor_id, first_name, last_name, date_of_birth, email, address_id, course_id) " +
                "VALUES ('12345678-xyzv-1234-efgh-123456789abc', 'John', 'Doe', '1990-05-15', 'john.doe@example.com', NULL, NULL);");
    }

    @Test
    @Order(1)
    public void isInstructorNullCheck() {
        assertTrue(instructorService.isNullOrNot("6bd15419-2bc6-42da-adcc-4c61e361b861"));
        assertFalse(instructorService.isNullOrNot("ea7ccec0-a718-4c43-888e-f5da2e66a39b"));
    }

    @Test
    @Order(5)
    public void testListInstructorViewMvc() throws Exception {
        Instructor instructor1 = Instructor.builder()
                .id("12345678-xyzv-1234-aawe-123456789abc")
                .firstName("Ramy")
                .lastName("Elazab")
                .birthDate("10/10/2010")
                .email("ramy124@gmail.com")
                .build();

        Instructor instructor2 = Instructor.builder()
                .id("23456789-xyzv-1234-bbwe-234567890abc")
                .firstName("Sara")
                .lastName("Smith")
                .birthDate("05/15/1985")
                .email("sara.smith@example.com")
                .build();

        Instructor instructor3 = Instructor.builder()
                .id("34567890-xyzv-1234-ccwe-345678901abc")
                .firstName("John")
                .lastName("Doe")
                .birthDate("02/20/1990")
                .email("john.doe@example.com")
                .build();
        ArrayList<Instructor> instructors = new ArrayList<>();
        instructors.add(instructor1);
        instructors.add(instructor2);
        instructors.add(instructor3);

        when(instructorService.findAllInstructors()).thenReturn(instructors);

        Assertions.assertIterableEquals(instructors, instructorService.findAllInstructors());

    }


    @Test
    @Order(2)
    public void getInstructorsSizeInDatabase() {
        List<Instructor> instructors = instructorService.findAllInstructors();
        assertEquals(10, instructors.size());
    }

    @Test
    @Order(3)
    public void getSpecificInstructor() {
        assertTrue(instructorService.isNullOrNot("12345678-xyzv-1234-efgh-123456789abc"));
    }

    @AfterEach
    public void tearDown() {
        jdbc.execute("DELETE FROM instructor WHERE instructor_id = '12345678-xyzv-1234-efgh-123456789abc';");
    }

}
