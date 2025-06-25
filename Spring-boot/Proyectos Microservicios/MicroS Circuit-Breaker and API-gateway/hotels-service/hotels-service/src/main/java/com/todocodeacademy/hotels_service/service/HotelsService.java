package com.todocodeacademy.hotels_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todocodeacademy.hotels_service.model.Hotel;

@Service
public class HotelsService implements IHotelService{

    List<Hotel> hotelslList = new ArrayList<>();

    @Override
    public List<Hotel> getHotelsByCityId(Long city_id) {
        List<Hotel> hotelCitylList = new ArrayList<>();
        //carga la simulacion de la base de datos que se ha creado abajo
        this.loadHotels();
        //busca si coincide la id
        for(Hotel h:hotelslList){
            if(h.getCity_id()==city_id){
                hotelCitylList.add(h);
            }
        }
        return hotelCitylList;
    }

    public void loadHotels(){
        hotelslList.add(new Hotel(1L, "Paradise", 5, 1L));
        hotelslList.add(new Hotel(2L, "Sunset View", 4, 2L));
        hotelslList.add(new Hotel(3L, "Ocean Breeze", 3, 3L));
        hotelslList.add(new Hotel(4L, "Mountain Retreat", 4, 1L));
        hotelslList.add(new Hotel(5L, "City Lights Inn", 3, 2L));
        hotelslList.add(new Hotel(6L, "Riverside Lodge", 4, 3L));
        hotelslList.add(new Hotel(7L, "Cozy Cabin Resort", 2, 1L));
        hotelslList.add(new Hotel(8L, "Luxury Haven", 5, 2L));
        hotelslList.add(new Hotel(9L, "Historic Grand Hotel", 4, 3L));
        hotelslList.add(new Hotel(10L, "Tranquil Garden", 3, 1L));

    }

}
