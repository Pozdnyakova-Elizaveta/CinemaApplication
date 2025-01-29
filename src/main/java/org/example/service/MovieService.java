package org.example.service;

import org.example.api.KinopoiskClient;
import org.example.dto.MovieDTO;
import org.example.entity.MovieEntity;
import org.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final KinopoiskClient kpClient = new KinopoiskClient();
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public void add(MovieDTO movieDTO){
        if (kpClient.searchByName(movieDTO)){
            MovieEntity movieEntity = mappingToEntity(movieDTO);
            movieRepository.save(movieEntity);
        }
    }
    public void update(MovieDTO movieDTO){
        if (kpClient.searchByID(movieDTO)){
            MovieEntity movieEntity = mappingToEntity(movieDTO);
            movieRepository.save(movieEntity);
        }
    }
    public void updateDate(MovieDTO movieDTO){
        MovieEntity movieEntity = mappingToEntity(movieDTO);
        movieRepository.save(movieEntity);
    }
    public MovieDTO find(String title){
        Optional<MovieEntity> movieEntityOptional = movieRepository.findByMovieTitle(title);
        if (!movieEntityOptional.isEmpty()) {
            MovieEntity movieEntity = movieEntityOptional.get();
            MovieDTO movieDTO = mappingToDTO(movieEntity);
            return movieDTO;
        }
        return null;
    }
    public void delete(Long id){
        movieRepository.deleteById(id);
    }
    public List<MovieDTO> findRelevant(){
        List<MovieEntity> movieEntities = movieRepository.findMoviesCurrentlyShowing(LocalDate.now());
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for (MovieEntity m: movieEntities){
            movieDTOS.add(mappingToDTO(m));
        }
        return movieDTOS;
    }
    private MovieEntity mappingToEntity(MovieDTO movieDTO){
        MovieEntity movieEntity = MovieEntity.builder().idMovie(movieDTO.getIdMovie())
                .movieTitle(movieDTO.getMovieTitle()).yearRelease(movieDTO.getYearRelease())
                .raitingKP(movieDTO.getRaitingKP()).raitingIMDB(movieDTO.getRaitingIMDB())
                .descriptionMovie(movieDTO.getDescriptionMovie()).ageLimit(movieDTO.getAgeLimit())
                .countryOrigin(movieDTO.getCountryOrigin()).poster(movieDTO.getPoster()).movieDuration(movieDTO.getMovieDuration())
                .rentalStartDate(movieDTO.getRentalStartDate()).rentalEndDate(movieDTO.getRentalEndDate()).build();
        return movieEntity;
    }
    private MovieDTO mappingToDTO(MovieEntity movieEntity){
        MovieDTO movieDTO = MovieDTO.builder().idMovie(movieEntity.getIdMovie()).movieTitle(movieEntity.getMovieTitle())
                .yearRelease(movieEntity.getYearRelease()).raitingKP(movieEntity.getRaitingKP())
                .raitingIMDB(movieEntity.getRaitingIMDB()).descriptionMovie(movieEntity.getDescriptionMovie())
                .ageLimit(movieEntity.getAgeLimit()).countryOrigin(movieEntity.getCountryOrigin())
                .poster(movieEntity.getPoster()).movieDuration(movieEntity.getMovieDuration())
                .rentalStartDate(movieEntity.getRentalStartDate()).rentalEndDate(movieEntity.getRentalEndDate())
                .build();
        return movieDTO;
    }
}
