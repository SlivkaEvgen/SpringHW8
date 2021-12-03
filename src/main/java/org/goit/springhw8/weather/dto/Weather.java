package org.goit.springhw8.weather.dto;

import lombok.Data;

@Data
public class Weather {

    public Integer id;
    public String main;
    public String description;

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public String icon;
}
