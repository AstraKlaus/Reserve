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
public class TypeReservesService {

    private final TypeReservesRepository typeReservesRepository;

    public List<TypeReserves> getAllTypes() {
        return typeReservesRepository.findAll();
    }

    public TypeReserves getTypeById(Long id) {
        return typeReservesRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("TypeReserves with id " + id + " not found.")));
    }

    public TypeReserves createType(TypeReserves typeReserves) {
        return typeReservesRepository.save(typeReserves);
    }

    public TypeReserves updateType(Long id, TypeReserves typeReserves) {
        TypeReserves existingType = getTypeById(id);
        existingType.setName(typeReserves.getName());
        return typeReservesRepository.save(existingType);
    }

    public void deleteType(Long id) {
        typeReservesRepository.deleteById(id);
    }

    public Optional<TypeReserves> findByName(String name) {
        return typeReservesRepository.findByName(name);
    }
}
