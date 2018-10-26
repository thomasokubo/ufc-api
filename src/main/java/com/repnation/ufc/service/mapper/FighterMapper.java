package com.repnation.ufc.service.mapper;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.domain.model.vo.FighterVo;

public class FighterMapper {

    private FighterMapper(){
        // Prevents instantiation
    }

    public static FighterVo mapFromDomainToVo(Fighter fighter) {
        return new FighterVo.Builder()
                .withFirsName(fighter.getFirstName())
                .withLastName(fighter.getLastName())
                .withNickname(fighter.getNickname())
                .withHoldsTitle(fighter.isHoldsTitle())
                .withWeightClass(fighter.getWeightClass())
                .withWinnings(fighter.getWinnings())
                .withLosses(fighter.getLosses())
                .withDraws(fighter.getDraws())
                .withAge(fighter.getAge())
                .withHeight(fighter.getHeight())
                .withWeight(fighter.getWeight())
                .withSummary(fighter.getSummary())
                .build();
    }

    public static Fighter mapFromVoToDomain(FighterVo fighterVo) {
        return new Fighter.Builder()
                .withFirsName(fighterVo.getFirstName())
                .withLastName(fighterVo.getLastName())
                .withNickname(fighterVo.getNickname())
                .withHoldsTitle(fighterVo.isHoldsTitle())
                .withWeightClass(fighterVo.getWeightClass())
                .withWinnings(fighterVo.getWinnings())
                .withLosses(fighterVo.getLosses())
                .withDraws(fighterVo.getDraws())
                .withAge(fighterVo.getAge())
                .withHeight(fighterVo.getHeight())
                .withWeight(fighterVo.getWeight())
                .withSummary(fighterVo.getSummary())
                .build();
    }


}
