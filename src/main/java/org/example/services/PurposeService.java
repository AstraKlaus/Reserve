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
public class PurposeService {

    private final PurposeRepository purposeRepository;

    public List<Purpose> getAllPurposes() {
        return purposeRepository.findAll();
    }

    public Purpose getPurposeById(Long id) {
        return purposeRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("Purpose with id " + id + " not found")));
    }

    public Purpose createPurpose(Purpose purpose) {
        return purposeRepository.save(purpose);
    }

    public Purpose updatePurpose(Long id, Purpose purpose) {
        Purpose existingPurpose = getPurposeById(id);
        existingPurpose.setName(purpose.getName());
        return purposeRepository.save(existingPurpose);
    }

    public void deletePurpose(Long id) {
        purposeRepository.deleteById(id);
    }

    public Optional<Purpose> findByName(String name) {
        return purposeRepository.findByName(name);
    }
}
