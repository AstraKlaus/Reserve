package org.example.controllers;

import org.example.models.*;
import org.example.services.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class StateReserveController {

    private final StateReserveService stateReserveService;

    @GetMapping
    public ResponseEntity<List<StateReserve>> getAllStates() {
        return ResponseEntity.ok(stateReserveService.getAllStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateReserve> getStateById(@PathVariable Long id) {
        return ResponseEntity.ok(stateReserveService.getStateById(id));
    }

    @PostMapping
    public ResponseEntity<StateReserve> createState(@RequestBody @Valid StateReserve stateReserve) {
        StateReserve createdState = stateReserveService.createState(stateReserve);
        return new ResponseEntity<>(createdState, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateReserve> updateState(@PathVariable Long id, @RequestBody @Valid StateReserve stateReserve) {
        StateReserve updatedState = stateReserveService.updateState(id, stateReserve);
        return ResponseEntity.ok(updatedState);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
        stateReserveService.deleteState(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<StateReserve> findStateByName(@RequestParam String name) {
        return stateReserveService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}

