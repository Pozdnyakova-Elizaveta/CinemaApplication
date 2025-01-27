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

import java.io.IOException;

public class KinopoiskClient {
    private final String urlSearchByName = "https://api.kinopoisk.dev/v1.4/movie/search?query=";
    private final String urlSearchById = "https://api.kinopoisk.dev/v1.4/movie/";
    public MovieDTO searchByName(String title, Integer year){
        try {
            JSONObject movies = getMovieData(urlSearchByName + title);
            JSONArray moviesArray = movies.getJSONArray("docs");
            for (int i = 0; i < moviesArray.length(); i++) {
                JSONObject movie = moviesArray.getJSONObject(i);
                if (movie.optInt("year")==year){
                    return parserMovie(movie);
                }
            }
            return null;
        }catch (IOException | ParseException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public MovieDTO searchByID(Integer id){
        try {
            JSONObject movie = getMovieData(urlSearchById + id.toString());
            return parserMovie(movie);
        }catch (IOException | ParseException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    private JSONObject getMovieData(String url) throws IOException, ParseException {
        RequestConfig requestConfig = RequestConfig.DEFAULT;
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
        HttpGet request = new HttpGet(url);
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
    private MovieDTO parserMovie(JSONObject movie){
        JSONArray countriesArray = movie.getJSONArray("countries");
        String countries = "";
        for (int i = 0; i < countriesArray.length(); i++){
            countries = countries+countriesArray.getJSONObject(i).optString("name")+" ";
        }
        MovieDTO movieDTO = MovieDTO.builder().idMovie(movie.getLong("id"))
                .movieTitle(movie.getString("name")).yearRelease(movie.getInt("year"))
                .descriptionMovie(movie.getString("description")).ageLimit(movie.getString("ageRating")+"+")
                .movieDuration(movie.getInt("movieLength"))
                .raitingKP(movie.getJSONObject("rating").getDouble("kp"))
                .raitingIMDB(movie.getJSONObject("rating").getDouble("imdb"))
                .countryOrigin(countries).poster(movie.getJSONObject("poster").getString("url")).build();
        return movieDTO;
    }
}
