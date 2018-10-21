package com.repnation.ufc.domain.jsonapi;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseJsonModel {
    @JsonIgnore
    private Long Id;

    public BaseJsonModel() {
    }

    public abstract Long getId();
}
