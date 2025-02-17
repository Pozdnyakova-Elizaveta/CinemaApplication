package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.CityDTO;
import org.example.dto.StreetDTO;
import org.example.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StreetController {
    private final StreetService streetService;
    @Autowired
    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }
    @GetMapping(path = "/street/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StreetDTO getStreet(@PathVariable("id") Long id) {
        return streetService.findById(id);
    }
    @GetMapping(path = "/street/city/{idCity}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StreetDTO> getStreetByCity(@PathVariable("idCity") Long idCity) {
        return streetService.findByCity(idCity);
    }
    @DeleteMapping(path = "/street/delete/{id}")
    public ResponseEntity<String> deleteStreet(@PathVariable("id") Long id) {
        try {
            streetService.delete(id);
        } catch (Exception e) {
            return createErrorResponse(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
    @PostMapping(path = "/street/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addStreet(@RequestBody StreetDTO streetDto) {
        try {
            streetService.add(streetDto);
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
