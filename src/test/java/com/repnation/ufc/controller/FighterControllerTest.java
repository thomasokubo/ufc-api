package com.repnation.ufc.controller;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.domain.model.vo.FighterVo;
import com.repnation.ufc.service.FighterService;
import com.repnation.ufc.service.mapper.FighterMapper;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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
        Fighter fighter = new Fighter.Builder()
                .withFirsName("Conor")
                .withLastName("McGregor")
                .withNickname("Notorious")
                .build();
        fighters.add(fighter);

        List<FighterVo> fightersVo = new ArrayList<>();
        FighterVo expectedFighterVo = new FighterVo.Builder()
                .withFirsName("Conor")
                .withLastName("McGregor")
                .withNickname("Notorious")
                .build();
        fightersVo.add(expectedFighterVo);

        when(fighterService.findAll()).thenReturn(fighters);
        when(FighterMapper.mapFromDomainToVo(any())).thenReturn(expectedFighterVo);

        List<FighterVo> actualFighters = fighterController.getFighters();

        assertEquals(fightersVo, actualFighters);
        assertEquals(Integer.parseInt("1"), actualFighters.size());;
    }

    @Test
    public void whenIRequestFighterByIdShouldPerformProperly() throws Exception{
        Fighter expectedFighter = new Fighter.Builder()
                .withFirsName("Anderson")
                .withLastName("Silva")
                .withNickname("Spider")
                .build();

        FighterVo expectedFighterVo= new FighterVo.Builder()
                .withFirsName("Anderson")
                .withLastName("Silva")
                .withNickname("Spider")
                .build();

        when(fighterService.findById(any())).thenReturn(expectedFighter);
        when(FighterMapper.mapFromDomainToVo(any())).thenReturn(expectedFighterVo);

        FighterVo actualFighter = fighterController.getFighterById(Long.valueOf(1));

        assertEquals(expectedFighter, actualFighter);
    }

    @Test(expected = NotFoundException.class)
    public void whenIRequestForAnInvalidFighterShouldThrowException() throws Exception{
        when(fighterService.findById(any())).thenThrow(new NotFoundException("Fighter Not Found"));
        FighterVo actualFighter = fighterController.getFighterById(Long.valueOf(1));
    }
}
