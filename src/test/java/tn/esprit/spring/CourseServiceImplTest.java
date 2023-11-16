package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;
import tn.esprit.spring.services.ICourseServices;

import java.util.HashSet;
import java.util.List;

import static tn.esprit.spring.entities.Support.SKI;
import static tn.esprit.spring.entities.TypeCourse.COLLECTIVE_CHILDREN;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseServiceImplTest {

    @Autowired
    private ICourseRepository cr;
    @Autowired
    ICourseServices cs;

    Course c=new Course(2,COLLECTIVE_CHILDREN,SKI, 12F,2);

    @AfterEach
    public void tearDown() {
        // Clean up the database if needed
        cr.deleteAll();
    }

    @Test
    @Order(1)
    public void testaddCourse(){
        Course result=cs.addCourse(c);
        Assertions.assertNotNull(result);
    }

    @Test
    @Order(2)
    public void testretrieveAllCourses(){
        List<Course> result=cs.retrieveAllCourses();
        Assertions.assertNotNull(result);
    }

    @Test
    @Order(3)
    public void testupdateCourse(){
        Course result=cs.updateCourse(c);
        Assertions.assertNotNull(result);
    }

    @Test
    @Order(4)
    public void testretrieveCourse(){
        c = cs.addCourse(c);
        Course result=cs.retrieveCourse(c.getNumCourse());
        Assertions.assertNotNull(result);
    }
}
