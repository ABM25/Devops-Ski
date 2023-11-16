package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.ICourseServices;

import java.util.HashSet;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseServiceImplTest {

    @Autowired
    private ICourseRepository cr;

    @Autowired
    private ICourseServices cs;

    Course c = new Course(Long.valueOf(1), 1, TypeCourse.COLLECTIVE_CHILDREN, Support.SKI, new Float(0), 1, new HashSet<Registration>());

    @AfterEach
    public void tearDown() {
        // Clean up the database if needed
        cr.deleteAll();
    }

    @Test
    @Order(1)
    public void testaddCourse() {
        Course result = cs.addCourse(c);
        Assertions.assertNotNull(result);
    }

    @Test
    @Order(3)
    public void testupdateCourse() {
        Course result = cs.updateCourse(c);
        Assertions.assertNotNull(result);
    }
}
