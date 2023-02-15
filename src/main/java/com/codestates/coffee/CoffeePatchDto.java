package com.codestates.coffee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeePatchDto {
    private long coffeeId;

    private String korName;

    private String engName;

    private long price;
}
