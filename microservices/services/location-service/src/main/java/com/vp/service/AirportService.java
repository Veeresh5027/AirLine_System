package com.vp.service;

import com.vp.payload.request.AirportRequest;
import com.vp.payload.response.AirportResponse;

import java.util.List;

public interface AirportService {

    AirportResponse createAirport(AirportRequest request);

    AirportResponse getAirportById(Long id);

    List<AirportResponse> getAllAirports();

    AirportResponse updateAirport(Long id, AirportRequest request);

    void deleteAirport(Long id);

    List<AirportResponse> getAirportsByCityId(Long cityId);
}
