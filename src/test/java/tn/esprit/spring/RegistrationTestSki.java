
package tn.esprit.spring;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Registration;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.repositories.IRegistrationRepository;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.RegistrationServicesImpl;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RegistrationTestSki {
    @Mock
    private IRegistrationRepository registrationRepository;
    @Mock
    private ISkierRepository skierRepository;
    @InjectMocks
private RegistrationServicesImpl registrationServices;
    @Test
    public void testAddRegistrationAndAssignToSkier() {
        Skier skier = new Skier();
        skier.setNumSkier(123456L);
        when(skierRepository.findById(123456L)).thenReturn(Optional.of(skier));
        Registration registration = new Registration();
        registration.setSkier(null);
        when(registrationRepository.save(registration)).thenReturn(registration);
        Registration result = registrationServices.addRegistrationAndAssignToSkier(registration, 123456L);
        verify(skierRepository).findById(123456L);
        assertEquals(skier, registration.getSkier());
        verify(registrationRepository).save(registration);
        assertEquals(result, registration);
    }
    @Test
    public void testAssignRegistration() {
        Skier skier = new Skier();
        skier.setNumSkier(123456L);
        Course course = new Course();
        course.setNumCourse(123456L);
        Registration registration = new Registration();
        registration.setSkier(null);
        registration.setCourse(null);
        when(registrationRepository.save(any(Registration.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Registration result = registrationServices.assignRegistration(registration,skier,course);
        assertEquals(skier, registration.getSkier());
        assertEquals(course, registration.getCourse());
        verify(registrationRepository).save(registration);
         assertEquals(result, registration);
    }
}

