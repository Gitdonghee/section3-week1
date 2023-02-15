package com.codestates;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class WorldTime {
    private String datetime;
    private String timezone;
    private int day_of_week;
    /*
    public String getDatetime(){
        return datetime;
    }

    public String getTimezone(){
        return timezone;
    }

    public int getDay_of_week(){
        return day_of_week;
    }

    */
}
