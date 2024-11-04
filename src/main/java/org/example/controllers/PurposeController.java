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
@RequestMapping("/api/purposes")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class PurposeController {

    private final PurposeService purposeService;

    @GetMapping
    public ResponseEntity<List<Purpose>> getAllPurposes() {
        return ResponseEntity.ok(purposeService.getAllPurposes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purpose> getPurposeById(@PathVariable Long id) {
        return ResponseEntity.ok(purposeService.getPurposeById(id));
    }

    @PostMapping
    public ResponseEntity<Purpose> createPurpose(@RequestBody @Valid Purpose purpose) {
        Purpose createdPurpose = purposeService.createPurpose(purpose);
        return new ResponseEntity<>(createdPurpose, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Purpose> updatePurpose(@PathVariable Long id, @RequestBody @Valid Purpose purpose) {
        Purpose updatedPurpose = purposeService.updatePurpose(id, purpose);
        return ResponseEntity.ok(updatedPurpose);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurpose(@PathVariable Long id) {
        purposeService.deletePurpose(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Purpose> findPurposeByName(@RequestParam String name) {
        return purposeService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
