package com.repnation.ufc.factory;

import com.repnation.ufc.domain.model.Fighter;

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
}
