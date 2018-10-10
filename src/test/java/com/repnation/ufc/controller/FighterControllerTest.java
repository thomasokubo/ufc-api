package com.repnation.ufc.controller;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.service.FighterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
        Fighter conorMcGregor = new Fighter();
        conorMcGregor.setNickname("Notorious");
        fighters.add(conorMcGregor);

        when(fighterService.findAll()).thenReturn(fighters);

        List<Fighter> actualFighters = fighterController.getFighters();

        assertEquals(fighters, actualFighters);
        assertEquals(Integer.parseInt("1"), actualFighters.size());;
    }
}
