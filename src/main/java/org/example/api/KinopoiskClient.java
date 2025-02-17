package org.example.api;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.example.dto.MovieDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
@Component
public class KinopoiskClient {
    private final String urlSearchByName = "https://api.kinopoisk.dev/v1.4/movie/search?query=";
    private final String urlSearchById = "https://api.kinopoisk.dev/v1.4/movie/";
    private final String token;
    @Autowired
    public KinopoiskClient(KinopoiskProperties kinopoiskProperties) {
        this.token = kinopoiskProperties.getToken();
    }

    public boolean searchByName(MovieDTO movieDTO){
        try {
            String encodedString = URLEncoder.encode(movieDTO.getMovieTitle().toString(), "UTF-8");
            JSONObject movies = getMovieData(urlSearchByName+encodedString);
            JSONArray moviesArray = movies.getJSONArray("docs");
            if (moviesArray.isEmpty()){
                System.out.println("Фильм с таким названием не найден, проверьте правильность написания");
                return false;
            }
            for (int i = 0; i < moviesArray.length(); i++) {
                JSONObject movie = moviesArray.getJSONObject(i);
                if (movie.optInt("year")==movieDTO.getYearRelease()){
                    parserMovie(movie, movieDTO);
                    return true;
                }
            }
        }catch (IOException | ParseException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Фильм с таким годом выпуска не найден, проверьте год выпуска");
        return false;
    }
    public boolean searchByID(MovieDTO movieDTO){
        try {
            JSONObject movie = getMovieData(urlSearchById + movieDTO.getIdMovie().toString());
            parserMovie(movie, movieDTO);
            return true;
        }catch (IOException | ParseException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    private JSONObject getMovieData(String url) throws IOException, ParseException {
        RequestConfig requestConfig = RequestConfig.DEFAULT;
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
        HttpGet request = new HttpGet(url);
        request.setHeader("accept", "application/json");
        request.setHeader("X-API-KEY", token);
        CloseableHttpResponse response = httpClient.execute(request);
        int statusCode = response.getCode();
        if (statusCode != 200) {
            throw new IOException("HTTP error - " + statusCode);
        }
        String jsonString = EntityUtils.toString(response.getEntity());
        JSONObject jsonResponse = new JSONObject(jsonString);
        httpClient.close();
        response.close();
        return jsonResponse;
    }
    private void parserMovie(JSONObject movie, MovieDTO movieDTO){
        JSONArray countriesArray = movie.getJSONArray("countries");
        String countries = "";
        for (int i = 0; i < countriesArray.length(); i++){
            countries = countries+countriesArray.getJSONObject(i).optString("name")+" ";
        }
       movieDTO.setIdMovie(movie.getLong("id"));
       movieDTO.setDescriptionMovie(movie.getString("description"));
       movieDTO.setAgeLimit(movie.getInt("ageRating")+"+");
       movieDTO.setMovieDuration(movie.getInt("movieLength"));
       movieDTO.setRaitingKP(movie.getJSONObject("rating").getDouble("kp"));
       movieDTO.setRaitingIMDB(movie.getJSONObject("rating").getDouble("imdb"));
       movieDTO.setCountryOrigin(countries);
       movieDTO.setPoster(movie.getJSONObject("poster").getString("url"));
    }
}
