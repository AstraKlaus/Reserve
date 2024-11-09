package org.example.services;

import org.example.exceptions.IDNotFoundException;
import org.example.models.*;
import org.example.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Region getRegionById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("Region with id " + id + " not found")));
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }

    public Region updateRegion(Long id, Region region) {
        Region existingRegion = getRegionById(id);
        existingRegion.setName(region.getName());
        existingRegion.setCities(region.getCities());
        return regionRepository.save(existingRegion);
    }

    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }

    public Optional<Region> findByName(String name) {
        return regionRepository.findByName(name);
    }

    public Set<City> getCitiesByRegion(Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new IDNotFoundException(("Region with id " + regionId + " not found")));
        return region.getCities();
    }
}
