package org.example.repository;

import org.example.entity.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<StreetEntity, Long> {
    @Query("SELECT s FROM StreetEntity s WHERE s.cityEntity.idCity = :idCity")
    List<StreetEntity> findByCity(@Param("idCity") Long idCity);

}
