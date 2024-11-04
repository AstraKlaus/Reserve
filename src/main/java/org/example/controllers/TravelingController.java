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
@RequestMapping("/api/travelings")
@RequiredArgsConstructor
public class TravelingController {

    private final TravelingService travelingService;

    @GetMapping
    public ResponseEntity<List<Traveling>> getAllTravelings() {
        return ResponseEntity.ok(travelingService.getAllTravelings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traveling> getTravelingById(@PathVariable Long id) {
        return ResponseEntity.ok(travelingService.getTravelingById(id));
    }

    @PostMapping
    public ResponseEntity<Traveling> createTraveling(@RequestBody @Valid Traveling traveling) {
        Traveling createdTraveling = travelingService.createTraveling(traveling);
        return new ResponseEntity<>(createdTraveling, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Traveling> updateTraveling(@PathVariable Long id, @RequestBody @Valid Traveling traveling) {
        Traveling updatedTraveling = travelingService.updateTraveling(id, traveling);
        return ResponseEntity.ok(updatedTraveling);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraveling(@PathVariable Long id) {
        travelingService.deleteTraveling(id);
        return ResponseEntity.noContent().build();
    }

}
