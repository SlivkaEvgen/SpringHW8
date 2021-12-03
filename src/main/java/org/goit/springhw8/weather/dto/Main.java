package org.goit.springhw8.weather.dto;

import lombok.Data;

@Data
public class Main {

    public Double temp;

    public Double feels_like;

    public Double temp_min;

    public Double temp_max;

    public Integer pressure;

    public Integer humidity;
}
