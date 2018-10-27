package com.repnation.ufc.controller;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.domain.model.vo.FighterVo;
import com.repnation.ufc.factory.FighterFactory;
import com.repnation.ufc.service.FighterService;
import com.repnation.ufc.service.mapper.FighterMapper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FighterControllerTest {

    @InjectMocks
    private FighterController fighterController;

    @Mock
    private FighterService fighterService;

    @Test
    public void whenIRequestForAllFightersItShouldPerformProperly() {
        List<Fighter> fighters = new ArrayList<>();
        Fighter fighter = FighterFactory.getFighter();
        fighters.add(fighter);

        when(fighterService.findAll()).thenReturn(fighters);
        List<FighterVo> actualFighters = fighterController.getFighters();

        verify(fighterService).findAll();
        assertEquals(Integer.parseInt("1"), actualFighters.size());
    }

    @Test
    public void whenIRequestFighterByIdShouldPerformProperly() throws Exception{
        String firstName = "Anderson";
        String lastName = "Silva";
        String nickname = "The Spider";
        Fighter expectedFighter = FighterFactory.getFighter();

        when(fighterService.findById(any())).thenReturn(expectedFighter);
        FighterVo actualFighter = fighterController.getFighterById(1L);

        verify(fighterService).findById(1L);
        assertEquals(actualFighter.getFirstName(), firstName);
        assertEquals(actualFighter.getLastName(), lastName);
        assertEquals(actualFighter.getNickname(), nickname);
    }

    @Test(expected = NotFoundException.class)
    public void whenIRequestForAnInvalidFighterShouldThrowException() throws Exception{
        when(fighterService.findById(any())).thenThrow(new NotFoundException("Fighter Not Found"));
        fighterController.getFighterById(1L);
    }

    @Test
    public void whenICallPostFighterItShouldPerformProperly() {
        Fighter fighter = FighterFactory.getFighter();
        FighterVo fighterVo = FighterFactory.getFighterVo();
        when(fighterService.save(any())).thenReturn(fighter);

        FighterVo actualFighter = fighterController.saveFighter(fighterVo);
        assertEquals(actualFighter.getFirstName(), fighterVo.getFirstName());
    }

    @Test
    public void whenICallPatchFighterItShouldPerformProperly() throws Exception {
        FighterVo fighterVo = FighterFactory.getFighterVo();
        Fighter fighter = FighterFactory.getFighter();
        Fighter updatedFighter = FighterFactory.getFighter();
        Integer winnings = updatedFighter.getWinnings() + 1;
        updatedFighter.setWinnings(winnings);
        when(fighterService.findById(any())).thenReturn(fighter);
        when(fighterService.save(any())).thenReturn(updatedFighter);

        FighterVo actualFighterVo = fighterController.updateFighter(1L, fighterVo);
        assertEquals(winnings, actualFighterVo.getWinnings());
    }
}
