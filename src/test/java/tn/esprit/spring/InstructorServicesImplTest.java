package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.IInstructorRepository;
import tn.esprit.spring.services.InstructorServicesImpl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class InstructorServicesImplTest {


    @Mock
    private IInstructorRepository instructorRepository;

    @InjectMocks
    private InstructorServicesImpl instructorServices;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testretrieveAllInstructors(){
        List<Instructor> listInstructor = instructorServices.retrieveAllInstructors();
        assertEquals(0,listInstructor.size());
    }

    @Test
    void testAddInstructor() {
        Instructor instructor = new Instructor();
        instructor.setFirstName("John");
        instructor.setLastName("Doe");
        instructor.setDateOfHire(LocalDate.now());

        Set<Course> courses = new HashSet<>();
        instructor.setCourses(courses);

        when(instructorRepository.save(any(Instructor.class))).thenReturn(instructor);

        Instructor savedInstructor = instructorServices.addInstructor(instructor);

        assertNull(savedInstructor.getNumInstructor());
        assertEquals("John", savedInstructor.getFirstName());
        assertEquals("Doe", savedInstructor.getLastName());
    }



}