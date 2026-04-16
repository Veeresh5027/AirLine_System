package com.vp.service.impl;

import com.vp.mapper.AirportMapper;
import com.vp.model.Airport;
import com.vp.model.City;
import com.vp.payload.request.AirportRequest;
import com.vp.payload.response.AirportResponse;
import com.vp.repository.AirportRepository;
import com.vp.repository.CityRepository;
import com.vp.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public AirportResponse createAirport(AirportRequest request) {

        if(airportRepository.findByIataCode(request.getIataCode()) != null){
            throw new RuntimeException("Airport with iata code " + request.getIataCode() + " already exists");
        }
        City city = cityRepository.findById(request.getCityId())
                .orElseThrow(() -> new RuntimeException("City not found with id " + request.getCityId()));

        Airport airport = AirportMapper.airportEntity(request);
        airport.setCity(city);
        Airport savedAirport = airportRepository.save(airport);
        return AirportMapper.toResponse(savedAirport);

    }

    @Override
    public AirportResponse getAirportById(Long id) {
        return airportRepository.findById(id)
                .map(AirportMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Airport not found with id " + id));
    }

    @Override
    public List<AirportResponse> getAllAirports() {
        return airportRepository.findAll().stream()
                .map(AirportMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AirportResponse updateAirport(Long id, AirportRequest request) {

        Airport existingAirport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found with id " + id));

        if (request.getIataCode() != null
                && !existingAirport.getIataCode().equals(request.getIataCode())
                && airportRepository.findByIataCode(request.getIataCode()) != null){
            throw new RuntimeException("Airport with iata code " + request.getIataCode() + " already exists");
        }

        AirportMapper.updateEntity(request, existingAirport);
        Airport updateAirport = airportRepository.save(existingAirport);
        return AirportMapper.toResponse(updateAirport);
    }

    @Override
    public void deleteAirport(Long id) {

        airportRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Airport not found with id " + id)
                );
        airportRepository.deleteById(id);

    }

    @Override
    public List<AirportResponse> getAirportsByCityId(Long cityId) {
        return airportRepository.findByCityId(cityId).stream()
                .map(AirportMapper::toResponse)
                .collect(Collectors.toList());
    }
}
