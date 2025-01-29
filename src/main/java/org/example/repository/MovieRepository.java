package org.example.repository;

import jakarta.persistence.Table;
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
    @Query("SELECT m FROM MovieEntity m WHERE m.rentalStartDate < :currentDate AND m.rentalEndDate > :currentDate")
    List<MovieEntity> findMoviesCurrentlyShowing(@Param("currentDate") LocalDate currentDate);
}