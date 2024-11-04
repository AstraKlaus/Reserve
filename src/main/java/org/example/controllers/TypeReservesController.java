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
@RequestMapping("/api/types")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5174")
public class TypeReservesController {

    private final TypeReservesService typeReservesService;

    @GetMapping
    public ResponseEntity<List<TypeReserves>> getAllTypes() {
        return ResponseEntity.ok(typeReservesService.getAllTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeReserves> getTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(typeReservesService.getTypeById(id));
    }

    @PostMapping
    public ResponseEntity<TypeReserves> createType(@RequestBody @Valid TypeReserves typeReserves) {
        TypeReserves createdType = typeReservesService.createType(typeReserves);
        return new ResponseEntity<>(createdType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeReserves> updateType(@PathVariable Long id, @RequestBody @Valid TypeReserves typeReserves) {
        TypeReserves updatedType = typeReservesService.updateType(id, typeReserves);
        return ResponseEntity.ok(updatedType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        typeReservesService.deleteType(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<TypeReserves> findTypeByName(@RequestParam String name) {
        return typeReservesService.findByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
