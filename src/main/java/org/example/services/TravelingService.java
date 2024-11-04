package org.example.services;

import org.example.exceptions.IDNotFoundException;
import org.example.models.*;
import org.example.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TravelingService {

    private final TravelingRepository travelingRepository;

    public List<Traveling> getAllTravelings() {
        return travelingRepository.findAll();
    }

    public Traveling getTravelingById(Long id) {
        return travelingRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("Traveling with id " + id + " not found")));
    }

    public Traveling createTraveling(Traveling traveling) {
        return travelingRepository.save(traveling);
    }

    public Traveling updateTraveling(Long id, Traveling traveling) {
        Traveling existingTraveling = getTravelingById(id);
        existingTraveling.setName(traveling.getName());
        existingTraveling.setDescription(traveling.getDescription());
        existingTraveling.setPoints(traveling.getPoints());
        return travelingRepository.save(existingTraveling);
    }

    public void deleteTraveling(Long id) {
        travelingRepository.deleteById(id);
    }

}
