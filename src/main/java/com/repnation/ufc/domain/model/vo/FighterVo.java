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

    private FighterVo(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.nickname = builder.nickname;
        this.holdsTitle = builder.holdsTitle;
        this.weightClass = builder.weightClass;
        this.winnings = builder.winnings;
        this.losses = builder.losses;
        this.draws = builder.draws;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
        this.summary = builder.summary;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String nickname;
        private boolean holdsTitle;
        private String weightClass;
        private int winnings;
        private int losses;
        private int draws;
        private int age;
        private String height;
        private String weight;
        private String summary;

        public Builder() {
        }

        public Builder withFirsName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder withHoldsTitle(Boolean holdsTitle) {
            this.holdsTitle = holdsTitle;
            return this;
        }

        public Builder withWeightClass(String weightClass) {
            this.weightClass = weightClass;
            return this;
        }

        public Builder withWinnings(Integer winnings) {
            this.winnings = winnings;
            return this;
        }

        public Builder withLosses(Integer losses) {
            this.losses = losses;
            return this;
        }

        public Builder withDraws(Integer draws) {
            this.draws = draws;
            return this;
        }

        public Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder withHeight(String height) {
            this.height = height;
            return this;
        }

        public Builder withWeight(String weight) {
            this.weight = weight;
            return this;
        }

        public Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public FighterVo build() {
            return new FighterVo(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isHoldsTitle() {
        return holdsTitle;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public int getWinnings() {
        return winnings;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getAge() {
        return age;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getSummary() {
        return summary;
    }
}
