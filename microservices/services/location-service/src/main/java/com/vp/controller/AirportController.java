package com.vp.controller;

import com.vp.payload.request.AirportRequest;
import com.vp.payload.response.AirportResponse;
import com.vp.payload.response.ApiResponse;
import com.vp.service.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @PostMapping
    public ResponseEntity<AirportResponse> createAirport(@Valid @RequestBody AirportRequest request) {
        AirportResponse airportResponse = airportService.createAirport(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(airportResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportResponse> getAirportById(@PathVariable("id") Long id) {
        AirportResponse airportResponse = airportService.getAirportById(id);
        return ResponseEntity.ok(airportResponse);
    }

    @GetMapping
    public ResponseEntity<List<AirportResponse>> getAllAirports() {
        List<AirportResponse> airports = airportService.getAllAirports();
        return ResponseEntity.ok(airports);
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<AirportResponse>> getAirportsByCityId(@PathVariable("cityId") Long cityId) {
        List<AirportResponse> airports = airportService.getAirportsByCityId(cityId);
        return ResponseEntity.ok(airports);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportResponse> updateAirport(@PathVariable("id") Long id, @Valid @RequestBody AirportRequest request) {
        AirportResponse airportResponse = airportService.updateAirport(id, request);
        return ResponseEntity.ok(airportResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAirport(@PathVariable("id") Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.ok(new ApiResponse("Airport deleted successfully"));
    }

}
