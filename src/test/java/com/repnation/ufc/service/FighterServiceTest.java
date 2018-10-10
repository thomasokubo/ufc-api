package com.repnation.ufc.service;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.repository.FighterRepository;
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
public class FighterServiceTest {

    @InjectMocks
    private FighterService fighterService;

    @Mock
    private FighterRepository fighterRepository;

    @Test
    public void whenICallServiceItShouldPerformProperly() {

        List<Fighter> fighters = new ArrayList<>();
        Fighter conorMcGregor = new Fighter();
        conorMcGregor.setNickname("Notorious");
        fighters.add(conorMcGregor);

        when(fighterService.findAll()).thenReturn(fighters);

        List<Fighter> actualFighters = fighterService.findAll();

        assertEquals(fighters, actualFighters);

    }
}
