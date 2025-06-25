package com.todocodeacademy.cities_service.service;

import com.todocodeacademy.cities_service.dto.CityDTO;

public interface ICityService {

    public CityDTO getCitiesHotels(String name, String country);
}
