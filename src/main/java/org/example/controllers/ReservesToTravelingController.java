package org.example.controllers;

import org.example.models.*;
import org.example.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserves-to-traveling")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5174")
public class ReservesToTravelingController {

    private final ReservesToTravelingService reservesToTravelingService;
    private final ReservesService reservesService;

    @GetMapping
    public ResponseEntity<List<ReservesToTraveling>> getAllReservesToTravelings() {
        return ResponseEntity.ok(reservesToTravelingService.getAll());
    }

    @GetMapping("/by-reserve/{reserveId}")
    public ResponseEntity<List<ReservesToTraveling>> getTravelingsForReserve(@PathVariable Long reserveId) {
        Reserves reserves = reservesService.getReservesById(reserveId);
        return ResponseEntity.ok(reservesToTravelingService.getTravelingsForReserve(reserves));
    }
}

