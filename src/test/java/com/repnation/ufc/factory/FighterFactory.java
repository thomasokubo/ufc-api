package com.repnation.ufc.factory;

import com.repnation.ufc.domain.model.Fighter;

import java.util.ArrayList;
import java.util.List;

public class FighterFactory {

    public static Fighter getFighter() {
        return new Fighter.Builder()
                .withFirsName("Anderson")
                .withLastName("Silva")
                .withNickname("The Spider")
                .withHoldsTitle(false)
                .withWeightClass("Light Heavyweight")
                .withWinnings(34)
                .withLosses(8)
                .withDraws(0)
                .withAge(43)
                .withHeight("187cm")
                .withWeight("85kg")
                .withSummary("very well-rounded, phenomenal, striker, speed")
                .build();
    }

    public static List<Fighter> getFighters() {
        Fighter fighter1 =  new Fighter.Builder()
                .withFirsName("Anderson")
                .withLastName("Silva")
                .withNickname("The Spider")
                .withHoldsTitle(false)
                .withWeightClass("Light Heavyweight")
                .withWinnings(34)
                .withLosses(8)
                .withDraws(0)
                .withAge(43)
                .withHeight("187cm")
                .withWeight("85kg")
                .withSummary("very well-rounded, phenomenal, striker, speed")
                .build();

        Fighter fighter2 =  new Fighter.Builder()
                .withFirsName("Jon")
                .withLastName("Jones")
                .withNickname("Bones")
                .withHoldsTitle(false)
                .withWeightClass("Heavyweight")
                .withWinnings(23)
                .withLosses(1)
                .withDraws(0)
                .withAge(31)
                .withHeight("193cm")
                .withWeight("93kg")
                .withSummary("wrestling, jiu-jutsu, may thai")
                .build();

        List<Fighter> fighters = new ArrayList<>();
        fighters.add(fighter1);
        fighters.add(fighter2);
        return fighters;
    }
}
