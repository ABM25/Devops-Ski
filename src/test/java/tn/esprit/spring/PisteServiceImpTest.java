package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class PisteServiceImpTest {

    @Mock
    private IPisteRepository pisteRepository;

    @InjectMocks
    private PisteServicesImpl pisteServices;

    @Test
    void testAddPiste(){
        Piste piste = new Piste();
        when(pisteRepository.save(piste)).thenReturn(piste);

        Piste addedPiste = pisteServices.addPiste(piste);
        assertEquals(piste, addedPiste);

        verify(pisteRepository, times(1)).save(piste);
    }


@Test
    void testRetrievePisteById(){
        Long PisteId = 1L;

        Piste piste = new Piste();
        when(pisteRepository.findById(PisteId)).thenReturn(Optional.of(piste));
        Piste retrievedPiste = pisteServices.retrievePiste(PisteId);
        assertEquals(piste, retrievedPiste);
        verify(pisteRepository, times(1)).findById(PisteId);


}

@Test
    void testRetrieveAllPiste(){
        Piste piste = new Piste();
        when(pisteRepository.findAll()).thenReturn((List<Piste>) piste);
        List<Piste> retrieveAllPistes = pisteServices.retrieveAllPistes();
        assertEquals(piste, retrieveAllPistes);
        verify(pisteRepository).findAll();
}

@Test
    void testRemovePiste(){
        Long PisteId = 1L;
        pisteServices.removePiste(PisteId);
        verify(pisteRepository, times(1)).deleteById(PisteId);
}

}