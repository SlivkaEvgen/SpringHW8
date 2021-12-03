package org.goit.springhw8.weather;

import org.goit.springhw8.weather.dto.Root;

public class Main {

    //это должно быть в либо в ресурсах, либо принимаемый из вне параметр
    private static final String lang = "ua";
    private static final String idKiev = "703448";

    //это должно быть в ресурсах
    private static final String apiKey1 = "035ffdb64394f6a009c9de97dd704169";
    private static final String baseUrl = "https://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {
        WeatherHttpClient client = new WeatherHttpClient(baseUrl, apiKey1, lang);
        Root weather = client.getWeather(idKiev);
        System.out.println(weather);
        System.out.println(weather.main.temp);
    }

}
