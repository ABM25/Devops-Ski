package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tn.esprit.spring.entities.Piste;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PisteImplTest {

    @Mock
    private IPisteRepository pisteRepository;

    @InjectMocks
    private PisteServicesImpl pisteServices;

    @Test
    @Order(1)
    void testAddPiste() {
        // Create a sample subscription
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
    @Order(2)
    void testRetrieveAllPiste() {
        // Create a list of pistes
        List<Piste> listPiste = pisteServices.retrieveAllPistes();
        assertEquals(0, listPiste.size());
    }


    @Test
    @Order(3)
    void testRemovePiste() {
        Long numPiste = 1L;
        // Mock the behavior of the repository method
        doNothing().when(pisteRepository).deleteById(numPiste);

        // Invoke the method and verify that deleteById was called
        pisteServices.removePiste(numPiste);
        verify(pisteRepository, times(1)).deleteById(numPiste);
    }

    @Test
    @Order(4)
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