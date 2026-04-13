package com.vp.service.impl;

import com.vp.mapper.CityMapper;
import com.vp.model.City;
import com.vp.payload.request.CityRequest;
import com.vp.payload.response.CityResponse;
import com.vp.repository.CityRepository;
import com.vp.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public CityResponse createCity(CityRequest request) {
        if (cityRepository.existsByCityCode(request.getCityCode())){
            throw new RuntimeException("City Code already exists");
        }
        City city = CityMapper.cityEntity(request);
        City result = cityRepository.save(city);
        return CityMapper.toResponse(result);
    }

    @Override
    public CityResponse getCityById(Long id) {
       City city = cityRepository.findById(id).orElseThrow(
               () -> new RuntimeException("City not found"));
        return CityMapper.toResponse(city);
    }

    @Override
    public CityResponse updateCity(Long id, CityRequest request) {
        City city = cityRepository.findById(id).orElseThrow(
                () -> new RuntimeException("City not found"));
        if(cityRepository.existsByCityCode(request.getCityCode())){
            throw new RuntimeException("City already exists");
        }
        City updatedCity = CityMapper.updateEntity(city, request);
        return CityMapper.toResponse(cityRepository.save(updatedCity));
    }

    @Override
    public void deleteCity(Long id) {
        City city = cityRepository.findById(id).orElseThrow(
                () -> new RuntimeException("City not found"));
        cityRepository.deleteById(id);

        cityRepository.delete(city);
    }

    @Override
    public Page<CityResponse> getAllCities(Pageable pageable) {
        Page<City> cities = cityRepository.findAll(pageable);
        return cities.map(CityMapper::toResponse);
    }

    @Override
    public Page<CityResponse> searchCities(String keyword, Pageable pageable) {
        return cityRepository.searchByKeyword(keyword, pageable).map(CityMapper::toResponse);
    }

    @Override
    public Page<CityResponse> getCitiesByCountryCode(String countryCode, Pageable pageable) {
        return cityRepository
                .findByCountryCodeIgnoreCase(countryCode, pageable)
                .map(CityMapper::toResponse);
    }

    @Override
    public boolean cityExists(String cityCode) {
        return cityRepository.existsByCityCode(cityCode);
    }
    
}
