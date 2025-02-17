package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.dto.CityDTO;
import org.example.entity.CityEntity;
import org.example.entity.MovieEntity;
import org.example.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;
    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    public void add(CityDTO cityDTO){
        cityRepository.save(mappingToEntity(cityDTO));
    }
    public void delete(Long id){
        cityRepository.deleteById(id);
    }
    public CityDTO findById(Long id){
        return mappingToDTO(cityRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Entity not found with id: " + id)));
    }
    public List<CityDTO> findAll(){
        List<CityEntity> cityEntities = cityRepository.findAll();
        List<CityDTO> cityDTOS = new ArrayList<>();
        for (CityEntity cityEntity: cityEntities){
            CityDTO cityDTO = mappingToDTO(cityEntity);
            cityDTOS.add(cityDTO);
        }
        return cityDTOS;
    }
    public CityDTO mappingToDTO(CityEntity cityEntity){
        CityDTO cityDTO = CityDTO.builder().idCity(cityEntity.getIdCity()).nameCity(cityEntity.getNameCity()).build();
        return cityDTO;
    }
    public CityEntity mappingToEntity(CityDTO cityDTO){
        CityEntity cityEntity = CityEntity.builder().idCity(cityDTO.getIdCity()).nameCity(cityDTO.getNameCity()).build();
        return cityEntity;
    }
}
