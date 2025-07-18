package com.todocodeacademy.hotels_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.hotels_service.model.Hotel;
import com.todocodeacademy.hotels_service.service.IHotelService;


@RestController
@RequestMapping("/hotels")
public class HotelsController {
    @Autowired
    private IHotelService servHotel;

    @GetMapping("/{city_id}")
    public List<Hotel> getHotelsByCityId(@PathVariable Long city_id) {
        
        return servHotel.getHotelsByCityId(city_id);
    }
    
}
