package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.CityDTO;
import org.example.dto.MovieDTO;
import org.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CityController {
    private final CityService cityService;
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping(value = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityDTO> getAllCity() {
        return cityService.findAll();
    }
    @GetMapping(path = "/city/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CityDTO getCity(@PathVariable("id") Long id) {
        return cityService.findById(id);
    }
    @DeleteMapping(path = "/city/delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Long id) {
        try {
            cityService.delete(id);
        } catch (Exception e) {
            return createErrorResponse(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @PostMapping(path = "/city/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addCity(@RequestBody CityDTO cityDto) {
        try {
            cityService.add(cityDto);
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
