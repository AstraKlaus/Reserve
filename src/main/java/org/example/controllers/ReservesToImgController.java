package org.example.controllers;

import org.example.models.*;
import org.example.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserves-to-images")
@RequiredArgsConstructor
public class ReservesToImgController {

    private final ReservesToImgService reservesToImgService;
    private final ReservesService reservesService;

    @GetMapping
    public ResponseEntity<List<ReservesToImg>> getAllReservesToImages() {
        return ResponseEntity.ok(reservesToImgService.getAll());
    }

    @GetMapping("/by-reserve/{reserveId}")
    public ResponseEntity<List<ReservesToImg>> getImagesForReserve(@PathVariable Long reserveId) {
        Reserves reserves = reservesService.getReservesById(reserveId);
        return ResponseEntity.ok(reservesToImgService.getImagesForReserve(reserves));
    }
}
