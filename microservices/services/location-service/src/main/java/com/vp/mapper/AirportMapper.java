package com.vp.mapper;

import com.vp.model.Airport;
import com.vp.payload.request.AirportRequest;
import com.vp.payload.response.AirportResponse;

public class AirportMapper {

    public static Airport airportEntity(AirportRequest request) {
        if (request == null) {
            return null;
        }
        return Airport.builder()
                .iataCode(request.getIataCode())
                .name(request.getName())
                .timeZone(String.valueOf(request.getTimeZone()))
                .address(request.getAddress())
                .geoCode(request.getGeoCode())
                .build();
    }

    public static AirportResponse toResponse(Airport airport){
        if (airport == null) {
            return null;
        }
        return AirportResponse.builder()
                .id(airport.getId())
                .iataCode(airport.getIataCode())
                .name(airport.getName())
                .detailedName(airport.getDetailedName())
                .timeZone(airport.getTimeZone())
                .address(airport.getAddress())
                .geoCode(airport.getGeoCode())
                .city(CityMapper.toResponse(airport.getCity()))
                .build();
    }
}
