package com.todocodeacademy.cities_service.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todocodeacademy.cities_service.dto.HotelDTO;

@FeignClient(name="hotel-service")
public interface IHotelAPI {

    @GetMapping("hotels/{city_id}")
    public List<HotelDTO> getHotelsByCityId(@PathVariable("city_id") Long city_id);
}
