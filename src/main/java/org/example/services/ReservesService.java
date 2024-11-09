package org.example.services;

import org.example.exceptions.IDNotFoundException;
import org.example.models.*;
import org.example.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservesService {

    private final ReservesRepository reservesRepository;
    private final RegionRepository regionRepository;
    private final CityRepository cityRepository;
    private final CategoryRepository categoryRepository;

    public List<Reserves> getAllReserves() {
        return reservesRepository.findAll();
    }

    public Reserves getReservesById(Long id) {
        return reservesRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("Reserves with id " + id + " not found")));
    }

    public Reserves createReserve(Reserves reserves) {
        return reservesRepository.save(reserves);
    }

    public Reserves updateReserve(Long id, Reserves reserves) {
        Reserves existingReserves = getReservesById(id);
        existingReserves.setName(reserves.getName());
        existingReserves.setDescription(reserves.getDescription());
        existingReserves.setRegion(reserves.getRegion());
        existingReserves.setCity(reserves.getCity());
        existingReserves.setCategory(reserves.getCategory());
        existingReserves.setState(reserves.getState());
        existingReserves.setType(reserves.getType());
        existingReserves.setPurpose(reserves.getPurpose());
        existingReserves.setDataCreate(reserves.getDataCreate());
        existingReserves.setDepartment(reserves.getDepartment());
        existingReserves.setCountCluster(reserves.getCountCluster());
        existingReserves.setSize(reserves.getSize());
        existingReserves.setGuardedSize(reserves.getGuardedSize());
        existingReserves.setMail(reserves.getMail());
        existingReserves.setSupervisor(reserves.getSupervisor());
        existingReserves.setPhone(reserves.getPhone());
        existingReserves.setEmail(reserves.getEmail());
        existingReserves.setLink(reserves.getLink());
        existingReserves.setX(reserves.getX());
        existingReserves.setY(reserves.getY());

        return reservesRepository.save(existingReserves);
    }

    public void deleteReserve(Long id) {
        reservesRepository.deleteById(id);
    }

    // Методы для поиска по объектам

    public List<Reserves> findByRegion(Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new IDNotFoundException(("Region with id " + regionId + " not found")));
        return reservesRepository.findByRegion(region);
    }

    public List<Reserves> findByCity(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new IDNotFoundException(("City with id " + cityId + " not found")));
        return reservesRepository.findByCity(city);
    }

    public List<Reserves> findByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IDNotFoundException(("Category with id " + categoryId + " not found")));
        return reservesRepository.findByCategory(category);
    }

    public Reserves findByName(String name) {
        return reservesRepository.findByName(name)
                .orElseThrow(() -> new IDNotFoundException(("Reserves with name " + name + " not found")));
    }
}

