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
    public ResponseEntity<List<Reserve>> getAllReserves() {
        return ResponseEntity.ok(reservesService.getAllReserves());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserve> getReservesById(@PathVariable Long id) {
        return ResponseEntity.ok(reservesService.getReservesById(id));
    }

    @PostMapping
    public ResponseEntity<Reserve> createReserve(@RequestBody @Valid Reserve reserve) {
        Reserve createdReserve = reservesService.createReserve(reserve);
        return new ResponseEntity<>(createdReserve, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserve> updateReserve(@PathVariable Long id, @RequestBody @Valid Reserve reserve) {
        Reserve updatedReserve = reservesService.updateReserve(id, reserve);
        return ResponseEntity.ok(updatedReserve);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserve(@PathVariable Long id) {
        reservesService.deleteReserve(id);
        return ResponseEntity.noContent().build();
    }

    // Методы для поиска по объектам

    @GetMapping("/by-region/{regionId}")
    public ResponseEntity<List<Reserve>> getReservesByRegion(@PathVariable Long regionId) {
        return ResponseEntity.ok(reservesService.findByRegion(regionId));
    }

    @GetMapping("/by-city/{cityId}")
    public ResponseEntity<List<Reserve>> getReservesByCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(reservesService.findByCity(cityId));
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<List<Reserve>> getReservesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(reservesService.findByCategory(categoryId));
    }

    @GetMapping("/search")
    public ResponseEntity<Reserve> searchReservesByName(@RequestParam String name) {
        return ResponseEntity.ok(reservesService.findByName(name));
    }

}
