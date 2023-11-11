package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.SkierServicesImpl;
import java.util.Optional;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class SkierTest {

    @InjectMocks
    private SkierServicesImpl skierServices;

    @Mock
    private ISkierRepository skierRepository;

    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddSkier() {
        // Créez un objet Skier pour le test
        Skier skier = new Skier();
        skier.setFirstName("Bubu");
        skier.setLastName("Dudu");
        skier.setDateOfBirth(LocalDate.of(1998, 11, 10));

        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.ANNUAL);
        subscription.setStartDate(LocalDate.now());

        skier.setSubscription(subscription);


        when(subscriptionRepository.save(any(Subscription.class))).thenReturn(subscription);
        when(skierRepository.save(any(Skier.class))).thenReturn(skier);

        // Appelez la méthode du service à tester
        Skier result = skierServices.addSkier(skier);

        // Vérifiez les résultats
        assertNotNull(result);
        assertEquals("Bubu", result.getFirstName());
        assertEquals("Dudu", result.getLastName());
        assertNotNull(result.getSubscription());
        assertNotNull(result.getSubscription().getEndDate());

    }


    @Test
    void testRetrieveSkier() {

        Long numSkier = 1L;

        Skier skier = new Skier();
        skier.setFirstName("Alice");
        skier.setLastName("Wonderland");
        skier.setDateOfBirth(LocalDate.of(1995, 10, 15));


        when(skierRepository.findById(numSkier)).thenReturn(Optional.of(skier));

        Skier result = skierServices.retrieveSkier(numSkier);

        assertNotNull(result);
        assertEquals("Alice", result.getFirstName());
        assertEquals("Wonderland", result.getLastName());
        assertEquals(LocalDate.of(1995, 10, 15), result.getDateOfBirth());
    }
}
