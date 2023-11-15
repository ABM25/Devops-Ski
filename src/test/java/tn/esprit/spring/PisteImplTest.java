package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PisteImplTest {

    @Mock
    private IPisteRepository pisteRepository;

    @InjectMocks
    private PisteServicesImpl pisteServices;

    @Test
    void testAddPiste() {
        // Create a sample piste
        Piste piste = new Piste();
        // Mock the behavior of the repository method
        when(pisteRepository.save(piste)).thenReturn(piste);

        // Invoke the method and verify the result
        Piste addedPiste = pisteServices.addPiste(piste);
        assertEquals(piste, addedPiste);

        // Verify that save method of pisteRepository was called once
        verify(pisteRepository, times(1)).save(piste);
    }

    @Test
    void testRetrievePiste() {
        Long numPiste = 1L;
        Piste piste = new Piste();

        // Mock the behavior of the repository method
        when(pisteRepository.findById(numPiste)).thenReturn(Optional.of(piste));

        // Invoke the method and verify the result
        Piste retrievedPiste = pisteServices.retrievePiste(numPiste);
        assertEquals(piste, retrievedPiste);

        // Verify that findById method of pisteRepository was called once
        verify(pisteRepository, times(1)).findById(numPiste);
    }
}
