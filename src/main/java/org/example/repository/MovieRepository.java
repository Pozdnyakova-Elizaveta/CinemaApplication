package org.example.repository;

import org.example.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    Optional<MovieEntity> findByMovieTitle(String title);
    @Query("SELECT m FROM Movie m WHERE m.Rental_Start_Date < :currentDate AND m.Rental_End_Date > :currentDate")
    List<MovieEntity> findMoviesCurrentlyShowing(@Param("currentDate") LocalDate currentDate);
}