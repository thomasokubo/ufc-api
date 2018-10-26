package com.repnation.ufc.domain.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "fighter")
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated fighter ID")
    private Long Id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String nickname;
    @Column(name = "holds_title")
    private Boolean holdsTitle;
    @Column(name = "weight_class")
    private String weightClass;
    private Integer winnings;
    private Integer losses;
    private Integer draws;
    private Integer age;
    private String height;
    private String weight;
    @ApiModelProperty(notes = "The description of the skills given by the fighters")
    private String summary;

    public Fighter() {
    }

    private Fighter(Builder builder) {
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

        public Fighter build(){
            return new Fighter(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isHoldsTitle() {
        return holdsTitle;
    }

    public void setHoldsTitle(Boolean holdsTitle) {
        this.holdsTitle = holdsTitle;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(Integer winnings) {
        this.winnings = winnings;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
