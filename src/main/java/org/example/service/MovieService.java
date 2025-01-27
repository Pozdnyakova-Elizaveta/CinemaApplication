package org.example.service;

import org.example.dto.MovieDTO;
import org.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public void add(MovieDTO movieDTO){}
    public void update(MovieDTO movieDTO){}
    public void find(MovieDTO movieDTO){}
    public void delete(MovieDTO movieDTO){}
    public void findRelevant(){}
}
