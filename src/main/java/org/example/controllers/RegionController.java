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
@RequestMapping("/api/regions")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> getAllRegions() {
        return ResponseEntity.ok(regionService.getAllRegions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.getRegionById(id));
    }

    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody @Valid Region region) {
        Region createdRegion = regionService.createRegion(region);
        return new ResponseEntity<>(createdRegion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody @Valid Region region) {
        Region updatedRegion = regionService.updateRegion(id, region);
        return ResponseEntity.ok(updatedRegion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Region> findRegionByName(@RequestParam String name) {
        return regionService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
