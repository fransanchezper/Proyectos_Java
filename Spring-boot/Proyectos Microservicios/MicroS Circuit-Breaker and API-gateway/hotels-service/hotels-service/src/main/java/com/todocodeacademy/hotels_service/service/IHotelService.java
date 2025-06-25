package com.todocodeacademy.hotels_service.service;

import java.util.List;

import com.todocodeacademy.hotels_service.model.Hotel;

public interface IHotelService {

    public List<Hotel> getHotelsByCityId(Long city_id);
}
