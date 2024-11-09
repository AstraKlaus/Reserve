package org.example.services;

import org.example.exceptions.IDNotFoundException;
import org.example.models.*;
import org.example.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("City with id " + id + " not found")));
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city) {
        City existingCity = getCityById(id);
        existingCity.setName(city.getName());
        existingCity.setRegion(city.getRegion());
        return cityRepository.save(existingCity);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public Optional<City> findByName(String name) {
        return cityRepository.findByName(name);
    }
}

