package com.repnation.ufc.domain.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class FighterVo {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String nickname;
    @JsonProperty("holds_title")
    private Boolean holdsTitle;
    @JsonProperty("weight_class")
    private String weightClass;
    private Integer winnings;
    private Integer losses;
    private Integer draws;
    private Integer age;
    private String height;
    private String weight;
    private String summary;

    public FighterVo() {
    }

    private FighterVo(Builder builder) {
        Optional.ofNullable(builder.firstName).ifPresent(this::setFirstName);
        Optional.ofNullable(builder.lastName).ifPresent(this::setLastName);
        Optional.ofNullable(builder.nickname).ifPresent(this::setNickname);
        Optional.ofNullable(builder.holdsTitle).ifPresent(this::setHoldsTitle);
        Optional.ofNullable(builder.weightClass).ifPresent(this::setWeightClass);
        Optional.ofNullable(builder.winnings).ifPresent(this::setWinnings);
        Optional.ofNullable(builder.losses).ifPresent(this::setLosses);
        Optional.ofNullable(builder.draws).ifPresent(this::setDraws);
        Optional.ofNullable(builder.age).ifPresent(this::setAge);
        Optional.ofNullable(builder.height).ifPresent(this::setHeight);
        Optional.ofNullable(builder.weight).ifPresent(this::setWeight);
        Optional.ofNullable(builder.summary).ifPresent(this::setSummary);
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String nickname;
        private Boolean holdsTitle;
        private String weightClass;
        private Integer winnings;
        private Integer losses;
        private Integer draws;
        private Integer age;
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

    public Boolean isTitleHolder() {
        return holdsTitle;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public Integer getWinnings() {
        return winnings;
    }

    public Integer getLosses() {
        return losses;
    }

    public Integer getDraws() {
        return draws;
    }

    public Integer getAge() {
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setHoldsTitle(Boolean holdsTitle) {
        this.holdsTitle = holdsTitle;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public void setWinnings(Integer winnings) {
        this.winnings = winnings;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
