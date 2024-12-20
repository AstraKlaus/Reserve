package org.example.services;

import org.example.exceptions.IDNotFoundException;
import org.example.models.*;
import org.example.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final RegionRepository regionRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }


    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("City with id " + id + " not found")));
    }

    public City createCity(City city) {
        // Проверяем, что регион не пустой, и устанавливаем связь
        if (city.getRegion() != null) {
            // Загружаем регион из базы данных, чтобы убедиться, что он находится в текущем сеансе
            Region region = regionRepository.findById(city.getRegion().getId())
                    .orElseThrow(() -> new IDNotFoundException(("Region with id " + city.getRegion().getId() + " not found")));

            // Устанавливаем связь город <-> регион
            region.getCities().add(city);  // Добавляем город в регион
            city.setRegion(region);        // Привязываем регион к городу
        }
        // Сохраняем город, что также сохранит связь с регионом (при наличии каскада в аннотациях)
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

