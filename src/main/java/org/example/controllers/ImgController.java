package org.example.controllers;

import org.example.models.*;
import org.example.services.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class ImgController {

    private final ImgService imgService;

    @GetMapping
    public ResponseEntity<List<Img>> getAllImages() {
        return ResponseEntity.ok(imgService.getAllImages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Img> getImageById(@PathVariable Long id) {
        return ResponseEntity.ok(imgService.getImageById(id));
    }

    @PostMapping
    public ResponseEntity<Img> createImage(@RequestBody @Valid Img img) {
        Img createdImg = imgService.createImage(img);
        return new ResponseEntity<>(createdImg, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Img> updateImage(@PathVariable Long id, @RequestBody @Valid Img img) {
        Img updatedImg = imgService.updateImage(id, img);
        return ResponseEntity.ok(updatedImg);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imgService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Optional<Img>> findByLink(@RequestParam String link) {
        return ResponseEntity.ok(imgService.findByLink(link));
    }
}

