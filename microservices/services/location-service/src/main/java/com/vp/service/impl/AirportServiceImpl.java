package com.vp.service.impl;

import com.vp.payload.request.AirportRequest;
import com.vp.payload.response.AirportResponse;
import com.vp.repository.AirportRepository;
import com.vp.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public AirportResponse createAirport(AirportRequest request) {
        return null;
    }

    @Override
    public AirportResponse getAirportById(Long id) {
        return null;
    }

    @Override
    public List<AirportResponse> getAllAirports() {
        return List.of();
    }

    @Override
    public AirportResponse updateAirport(Long id, AirportRequest request) {
        return null;
    }

    @Override
    public void deleteAirport(Long id) {

    }

    @Override
    public List<AirportResponse> getAirportsByCityId(Long cityId) {
        return List.of();
    }
}
