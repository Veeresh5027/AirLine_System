package com.vp.mapper;

import com.vp.model.City;
import com.vp.payload.request.CityRequest;
import com.vp.payload.response.CityResponse;

public class CityMapper {

    public static City cityEntity(CityRequest request) {
        if (request == null) {
            return null;
        }
        return City.builder()
                .name(request.getName())
                .cityCode(request.getCityCode())
                .countryCode(request.getCountryCode())
                .countryName(request.getCountryName())
                .regionCode(request.getRegionCode())
                .timeZoneId(request.getTimeZoneOffset())
                .build();
    }

    public static CityResponse toResponse(City city) {
        if (city == null) {
            return null;
        }
        return CityResponse.builder()
                .id(city.getId())
                .cityCode(city.getCityCode())
                .countryCode(city.getCountryCode())
                .countryName(city.getCountryName())
                .regionCode(city.getRegionCode())
                .build();
    }

    public static City updateEntity(City city, CityRequest request){
        if (request.getName() != null){
            city.setName(request.getName().trim());
        }
        if (request.getCityCode() != null){
            city.setCityCode(request.getCityCode().toUpperCase().trim());
        }
        if (request.getCountryCode() != null){
            city.setCountryCode(request.getCountryCode().toUpperCase().trim());
        }
        if (request.getCountryName() != null){
            city.setCountryName(request.getCountryName().trim());
        }
        if (request.getRegionCode() != null){
            city.setRegionCode(request.getRegionCode().toUpperCase().trim());
        }
        return city;
    } 

}
