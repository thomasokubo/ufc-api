package com.repnation.ufc.service;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.exception.NotFoundException;
import com.repnation.ufc.factory.FighterFactory;
import com.repnation.ufc.repository.FighterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FighterServiceTest {

    @InjectMocks
    private FighterService fighterService;

    @Mock
    private FighterRepository fighterRepository;

    @Test
    public void whenICallServiceItShouldPerformProperly() {
        List<Fighter> fighters = FighterFactory.getFighters();
        when(fighterService.findAll()).thenReturn(fighters);

        List<Fighter> actualFighters = fighterService.findAll();

        assertEquals(fighters, actualFighters);
    }

    @Test
    public void whenIRequestFighterByIdShouldPerformProperly() {
        Fighter expectedFighter = FighterFactory.getFighter();

        when(fighterRepository.findById(any())).thenReturn(Optional.of(expectedFighter));
        Optional<Fighter> response = fighterRepository.findById(1L);

        Fighter actualFighter = response.orElseGet(Fighter::new);
        assertEquals(expectedFighter, actualFighter);
    }

    @Test
    public void whenISaveNewFighterItShouldPerformProperly() {
        Fighter fighter = FighterFactory.getFighter();
        when(fighterRepository.save(any())).thenReturn(fighter);
        Fighter actualFighter = fighterService.save(fighter);
        assertEquals(fighter, actualFighter);
    }

    @Test
    public void whenIDeleteValidFighterItShouldPerformProperly() throws RuntimeException {
        Fighter fighter = FighterFactory.getFighter();
        when(fighterRepository.findById(any())).thenReturn(Optional.of(fighter));
        doNothing().when(fighterRepository).delete(any());
        fighterService.delete(fighter.getId());
        verify(fighterRepository).delete(any());
    }

    @Test(expected = NotFoundException.class)
    public void whenITryToDeleteInvalidFighterItShouldThrowException() throws RuntimeException {
        when(fighterRepository.findById(any())).thenReturn(Optional.empty());
        fighterService.delete(any());
    }

}
