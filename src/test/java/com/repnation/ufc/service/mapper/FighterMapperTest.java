package com.repnation.ufc.service.mapper;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.domain.model.vo.FighterVo;
import com.repnation.ufc.factory.FighterFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FighterMapperTest {

    @Test
    public void whenIMapFighterFromDomainToVoItShouldMapCorrectly() {
        Fighter fighter = FighterFactory.getFighter();
        FighterVo fighterVo = FighterMapper.mapFromDomainToVo(fighter);
        verifyFighter(fighter, fighterVo);
    }

    @Test
    public void whenIMapFighterFromVoToDomainItShouldMapCorrectly() {
        FighterVo fighterVo = FighterFactory.getFighterVo();
        Fighter fighter = FighterMapper.mapFromVoToDomain(fighterVo);
        verifyFighter(fighter, fighterVo);
    }

    private void verifyFighter(Fighter fighter, FighterVo fighterVo) {
        assertNotNull(fighter);
        assertNotNull(fighterVo);

        assertEquals(fighter.getFirstName(), fighterVo.getFirstName());
        assertEquals(fighter.getLastName(), fighterVo.getLastName());
        assertEquals(fighter.getNickname(), fighterVo.getNickname());
        assertEquals(fighter.getWeightClass(), fighterVo.getWeightClass());
        assertEquals(fighter.isTitleHolder(), fighterVo.isTitleHolder());
        assertEquals(fighter.getWinnings(), fighterVo.getWinnings());
        assertEquals(fighter.getLosses(), fighterVo.getLosses());
        assertEquals(fighter.getDraws(), fighterVo.getDraws());
        assertEquals(fighter.getAge(), fighterVo.getAge());
        assertEquals(fighter.getHeight(), fighterVo.getHeight());
        assertEquals(fighter.getSummary(), fighterVo.getSummary());
    }
}
