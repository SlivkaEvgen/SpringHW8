//package org.goit.springhw8.weather;
//
//import com.google.gson.Gson;
//import lombok.SneakyThrows;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import org.goit.springhw8.weather.dto.Root;
//
//import java.util.Objects;
//
//public class WeatherHttpClient {
//
//    private final OkHttpClient HTTP_CLIENT;
//    private final Gson GSON;
//
//    private final String baseUrl;
//
//    public WeatherHttpClient(String baseUrl, String apiKey, String lang) {
//        this.GSON = new Gson();
//        this.HTTP_CLIENT = new OkHttpClient();
//        this.baseUrl = String.join("", baseUrl, "?appid=", apiKey, "&lang=", lang);
//    }
//
//    public Root getWeather(String cityId) {
//        return callGet(String.join("", baseUrl, "&id=", cityId));
//    }
//
//    @SneakyThrows
//    private <T> T callGet(String url) {
//        Request request = new Request.Builder().url(url).get().build();
//        Response result = HTTP_CLIENT.newCall(request).execute();
//        return GSON.fromJson(Objects.requireNonNull(result.body()).charStream(), (Class<T>) Root.class);
//    }
//
//}
