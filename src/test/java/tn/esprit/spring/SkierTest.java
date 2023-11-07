package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.SkierServicesImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SkierTest {

    @MockBean
    private ISkierRepository skierRepository;

    @InjectMocks
    private SkierServicesImpl skierServices;

    Skier skier = new Skier(Long.valueOf(1),"Sinko","Kiko", LocalDate.of(1999,6,9),"Tunis", new Subscription(),null,null);

    List<Skier> liste= new ArrayList<Skier>(){
        {
            add( new Skier(Long.valueOf(2),"Bubu","Dudu", LocalDate.of(2007,2,14),"Tunis", new Subscription(),null,null));
            add( new Skier(Long.valueOf(3),"Qoobe","kawéb", LocalDate.of(2004,9,10),"Tunis", new Subscription(),null,null));

        }

    };
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveSkier() {
        // Arrange
        Long skierId = 1L;
        Skier skier = new Skier();
        when(skierRepository.findById(skierId)).thenReturn(Optional.of(skier));

        // Act
        Skier retrievedSkier = skierServices.retrieveSkier(skierId);

        // Assert
        assertEquals(skier, retrievedSkier);
        verify(skierRepository, times(1)).findById(skierId);
    }

    @Test
    void testRemoveSkier() {
        // Arrange
        Long skierId = 1L;

        // Act
        skierServices.removeSkier(skierId);

        // Assert
        verify(skierRepository, times(1)).deleteById(skierId);
    }
}