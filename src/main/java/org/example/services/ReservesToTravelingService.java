package org.example.services;

import org.example.models.*;
import org.example.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReservesToTravelingService {

    private final ReservesToTravelingRepository reservesToTravelingRepository;

    public List<ReservesToTraveling> getAll() {
        return reservesToTravelingRepository.findAll();
    }

    public List<ReservesToTraveling> getTravelingsForReserve(Reserves reserves) {
        return reservesToTravelingRepository.findByReserves(reserves);
    }
}
