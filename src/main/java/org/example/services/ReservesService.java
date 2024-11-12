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

    private final ReserveRepository reserveRepository;
    private final RegionRepository regionRepository;
    private final CityRepository cityRepository;
    private final CategoryRepository categoryRepository;

    public List<Reserve> getAllReserves() {
        return reserveRepository.findAll();
    }

    public Reserve getReservesById(Long id) {
        return reserveRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("Reserve with id " + id + " not found")));
    }

    public Reserve createReserve(Reserve reserve) {
        return reserveRepository.save(reserve);
    }

    public Reserve updateReserve(Long id, Reserve reserve) {
        Reserve existingReserve = getReservesById(id);
        existingReserve.setName(reserve.getName());
        existingReserve.setDescription(reserve.getDescription());
        existingReserve.setRegion(reserve.getRegion());
        existingReserve.setCity(reserve.getCity());
        existingReserve.setCategory(reserve.getCategory());
        existingReserve.setState(reserve.getState());
        existingReserve.setType(reserve.getType());
        existingReserve.setPurpose(reserve.getPurpose());
        existingReserve.setDataCreate(reserve.getDataCreate());
        existingReserve.setDepartment(reserve.getDepartment());
        existingReserve.setCountCluster(reserve.getCountCluster());
        existingReserve.setSize(reserve.getSize());
        existingReserve.setGuardedSize(reserve.getGuardedSize());
        existingReserve.setMail(reserve.getMail());
        existingReserve.setSupervisor(reserve.getSupervisor());
        existingReserve.setPhone(reserve.getPhone());
        existingReserve.setEmail(reserve.getEmail());
        existingReserve.setLink(reserve.getLink());
        existingReserve.setX(reserve.getX());
        existingReserve.setY(reserve.getY());

        return reserveRepository.save(existingReserve);
    }

    public void deleteReserve(Long id) {
        reserveRepository.deleteById(id);
    }

    // Методы для поиска по объектам

    public List<Reserve> findByRegion(Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new IDNotFoundException(("Region with id " + regionId + " not found")));
        return reserveRepository.findByRegion(region);
    }

    public List<Reserve> findByCity(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new IDNotFoundException(("City with id " + cityId + " not found")));
        return reserveRepository.findByCity(city);
    }

    public List<Reserve> findByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IDNotFoundException(("Category with id " + categoryId + " not found")));
        return reserveRepository.findByCategory(category);
    }

    public Reserve findByName(String name) {
        return reserveRepository.findByName(name)
                .orElseThrow(() -> new IDNotFoundException(("Reserve with name " + name + " not found")));
    }
}

