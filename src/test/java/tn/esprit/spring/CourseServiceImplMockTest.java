package tn.esprit.spring;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.services.CourseServicesImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)

public class CourseServiceImplMockTest {

    @Mock
    ICourseRepository cr;

    @InjectMocks
    CourseServicesImpl cs;

    Course course = new Course(1L, 1, TypeCourse.COLLECTIVE_CHILDREN, Support.SKI, 0.0f, 1, new HashSet<>());

    List<Course> liste = new ArrayList<Course>() {
        {
            add(new Course(2L, 2, TypeCourse.COLLECTIVE_CHILDREN, Support.SNOWBOARD, 0.0f, 2, null));
            add(new Course(3L, 3, TypeCourse.COLLECTIVE_CHILDREN, Support.SNOWBOARD, 0.0f, 3, null));
        }
    };

    @Test
    public void testupdateCourse() {
        Course updatedCourse = new Course();
        Mockito.when(cr.save(updatedCourse)).thenReturn(updatedCourse);
        Course result = cs.updateCourse(updatedCourse);
        assertNotNull(result);
    }

    @Test
    public void testaddCourse() {
        Course course1 = new Course();
        Mockito.when(cr.save(course1)).thenReturn(course1);
        Course result = cs.addCourse(course1);
        assertNotNull(result);
    }
}
