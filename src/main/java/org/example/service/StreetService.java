package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.dto.CityDTO;
import org.example.dto.StreetDTO;
import org.example.entity.CityEntity;
import org.example.entity.StreetEntity;
import org.example.repository.CityRepository;
import org.example.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StreetService {
    private final CityRepository cityRepository;
    private final StreetRepository streetRepository;
    @Autowired
    public StreetService(CityRepository cityRepository, StreetRepository streetRepository) {
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
    }
    public void add(StreetDTO streetDTO){
        streetRepository.save(mappingToEntity(streetDTO));
    }
    public void delete(Long id){
        streetRepository.deleteById(id);
    }
    public StreetDTO findById(Long id){
        return mappingToDTO(streetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id)));
    }
    public List<StreetDTO> findByCity(Long idCity){
        List<StreetEntity> streetEntities = streetRepository.findByCity(idCity);
        List<StreetDTO> streetDTOS = new ArrayList<>();
        for (StreetEntity streetEntity: streetEntities){
            StreetDTO cityDTO = mappingToDTO(streetEntity);
            streetDTOS.add(cityDTO);
        }
        return streetDTOS;
    }
    public StreetDTO mappingToDTO(StreetEntity streetEntity){
        StreetDTO streetDTO = StreetDTO.builder().idStreet(streetEntity.getIdStreet())
                .streetName(streetEntity.getStreetName()).idCity(streetEntity.getCityEntity().getIdCity())
                .nameCity(streetEntity.getCityEntity().getNameCity()).build();
        return streetDTO;
    }
    public StreetEntity mappingToEntity(StreetDTO streetDTO){
        StreetEntity streetEntity = StreetEntity.builder().idStreet(streetDTO.getIdStreet()).streetName(streetDTO.getStreetName())
                .build();
        streetEntity.setCityEntity(cityRepository.findById(streetDTO.getIdCity())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + streetDTO.getIdCity())));
        return streetEntity;
    }
}
