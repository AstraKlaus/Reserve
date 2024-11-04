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
public class ReservesToImgService {

    private final ReservesToImgRepository reservesToImgRepository;

    public List<ReservesToImg> getAll() {
        return reservesToImgRepository.findAll();
    }

    public List<ReservesToImg> getImagesForReserve(Reserves reserves) {
        return reservesToImgRepository.findByReserves(reserves);
    }
}
