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
@RequestMapping("/api/reserves")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class ReservesController {

    private final ReservesService reservesService;

    @GetMapping
    public ResponseEntity<List<Reserves>> getAllReserves() {
        return ResponseEntity.ok(reservesService.getAllReserves());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserves> getReservesById(@PathVariable Long id) {
        return ResponseEntity.ok(reservesService.getReservesById(id));
    }

    @PostMapping
    public ResponseEntity<Reserves> createReserve(@RequestBody @Valid Reserves reserves) {
        Reserves createdReserve = reservesService.createReserve(reserves);
        return new ResponseEntity<>(createdReserve, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserves> updateReserve(@PathVariable Long id, @RequestBody @Valid Reserves reserves) {
        Reserves updatedReserve = reservesService.updateReserve(id, reserves);
        return ResponseEntity.ok(updatedReserve);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserve(@PathVariable Long id) {
        reservesService.deleteReserve(id);
        return ResponseEntity.noContent().build();
    }

    // Методы для поиска по объектам

    @GetMapping("/by-region/{regionId}")
    public ResponseEntity<List<Reserves>> getReservesByRegion(@PathVariable Long regionId) {
        return ResponseEntity.ok(reservesService.findByRegion(regionId));
    }

    @GetMapping("/by-city/{cityId}")
    public ResponseEntity<List<Reserves>> getReservesByCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(reservesService.findByCity(cityId));
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<List<Reserves>> getReservesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(reservesService.findByCategory(categoryId));
    }

    @GetMapping("/search")
    public ResponseEntity<Reserves> searchReservesByName(@RequestParam String name) {
        return ResponseEntity.ok(reservesService.findByName(name));
    }

}
