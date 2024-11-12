package org.example.controllers;

import org.example.models.*;
import org.example.services.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @PostMapping("/upload")
    public ResponseEntity<Img> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("reserveId") Long reserveId
    ) throws IOException {
        Img createdImg = imgService.saveImage(file, reserveId);
        return new ResponseEntity<>(createdImg, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imgService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

    // Метод для получения изображений по ID резерва
    @GetMapping("/reserve/{reserveId}")
    public ResponseEntity<List<Img>> getImagesByReserveId(@PathVariable Long reserveId) {
        return ResponseEntity.ok(imgService.getImagesByReserveId(reserveId));
    }
}