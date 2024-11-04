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
public class StateReserveService {

    private final StateReserveRepository stateReserveRepository;

    public List<StateReserve> getAllStates() {
        return stateReserveRepository.findAll();
    }

    public StateReserve getStateById(Long id) {
        return stateReserveRepository.findById(id)
                .orElseThrow(() -> new IDNotFoundException(("State with id " + id + " not found")));
    }

    public StateReserve createState(StateReserve stateReserve) {
        return stateReserveRepository.save(stateReserve);
    }

    public StateReserve updateState(Long id, StateReserve stateReserve) {
        StateReserve existingState = getStateById(id);
        existingState.setName(stateReserve.getName());
        return stateReserveRepository.save(existingState);
    }

    public void deleteState(Long id) {
        stateReserveRepository.deleteById(id);
    }

    public Optional<StateReserve> findByName(String name) {
        return stateReserveRepository.findByName(name);
    }
}

