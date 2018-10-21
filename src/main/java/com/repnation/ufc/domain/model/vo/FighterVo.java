package com.repnation.ufc.domain.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FighterVo {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String nickname;
    @JsonProperty("holds_title")
    private boolean holdsTitle;
    @JsonProperty("weight_class")
    private String weightClass;
    private int winnings;
    private int losses;
    private int draws;
    private int age;
    private String height;
    private String weight;
    private String summary;

}
