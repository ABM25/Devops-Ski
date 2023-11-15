package tn.esprit.spring;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
@SpringBootTest
class InstructorServicesImplJunitTest {

    @Autowired
    IInstructorRepository instructorRepository;
    @Autowired
    InstructorServicesImpl instructorServices;
    @Test
    @Order(1)
    public void testAddInstructor() {
        Instructor instructor = new Instructor();
        instructor.setFirstName("Ahmed");
        instructor.setLastName("Ayari");
        instructor.setDateOfHire(LocalDate.now());

        Set<Course> courses = new HashSet<>();
        // Ajoutez des cours au set courses si nécessaire

        instructor.setCourses(courses);

        Instructor savedInstructor = instructorRepository.save(instructor);

        assertNotNull(savedInstructor.getNumInstructor());
        assertEquals("Ahmed", savedInstructor.getFirstName());
        assertEquals("Ayari", savedInstructor.getLastName());
        // Vérifiez d'autres attributs si nécessaire
    }


}