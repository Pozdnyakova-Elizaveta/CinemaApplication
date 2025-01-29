package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.MovieDTO;
import org.example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping(path = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieDTO> getCurrentMovie() {
        return movieService.findRelevant();
    }
    @GetMapping(path = "/movie/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO getMovie(@PathVariable("title") String title) {
        return movieService.find(title);
    }   //работает, выводит не то

    @PutMapping(path = "/movie/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateMovie(@RequestBody MovieDTO movieDTO) {
        try {
            movieService.update(movieDTO);
        } catch (Exception e) {
            return createErrorResponse(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @PutMapping(path = "/movie/update-date", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateDateMovie(@RequestBody MovieDTO movieDTO) {
        try {
            movieService.updateDate(movieDTO);
        } catch (Exception e) {
            return createErrorResponse(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @PostMapping(path = "/movie/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addMovie(@RequestBody MovieDTO movieDto) {
        try {
            movieService.add(movieDto);
        } catch (Exception e) {
            return createErrorResponse(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @DeleteMapping(path = "/movie/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id) {    //не работает
        try {
            movieService.delete(id);
        } catch (Exception e) {
            return createErrorResponse(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    public ResponseEntity<String> createErrorResponse(Exception e) {
        String errorMessage = e.getMessage();
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", errorMessage);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(errorResponse);
        } catch (JsonProcessingException ex) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unknown error");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);
    }
}
