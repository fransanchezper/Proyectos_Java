package com.todocodeacademy.cities_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.todocodeacademy.cities_service.dto.CityDTO;
import com.todocodeacademy.cities_service.model.City;
import com.todocodeacademy.cities_service.repository.IHotelAPI;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

public class CityService implements ICityService{

    @Autowired 
    private IHotelAPI hotelAPI;

    List<City> cities = new ArrayList<>();

    @Override
    @CircuitBreaker(name = "hotel-service", fallbackMethod = "fallbackGetCitiesHotel") //el name es la otra aplicacion a la que va a recurrir la api
    @Retry(name = "hotel-service") //Esto hace que despues del fallo espera y vuelve a intentar si no hubiera fallo
    public CityDTO getCitiesHotels(String name, String country) {
        //buscamos ciudad original
        City city = this.findCity(name,country);
        //creamos el dto de la ciudad listo de hoteles
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCity_id(city.getCity_id());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        //buscamoos la lista de hoteles en la API y asignamos
        cityDTO.setHotelList(hotelAPI.getHotelsByCityId(null));

        createException(); //Este metodo lo ponemos para provocar un fallo y veamos como salta el Circuit Breaker

         return cityDTO;
    }

    public CityDTO fallbackGetCitiesHotel(Throwable throwable){

        return new CityDTO(9999999999L, "Fallido", "Fallido", "Fallido", "Fallido", null);       
    }

    public void createException(){
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
    }

    public City findCity(String name, String country){
        this.loadCities();
        for(City c:cities){
            if (c.getName().equals(name)) {
                if(c.getCountry().equals(country)){
                    return c;
                }
            }
        }
        return null;
    }

    public void loadCities(){
        cities.add(new City(1L, "Buenos Aires", "South America", "Argentina", "Buenos Aires"));
        cities.add(new City(2L, "Obera", "South America", "Argentina", "Misiones"));
        cities.add(new City(3L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City(4L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City(5L, "Bogota", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City(6L, "Medellin", "South America", "Colombia", "Antioquia"));
        cities.add(new City(7L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City(8L, "Valparaisa", "South America", "Chile", "Valparaiso"));
        cities.add(new City(9L, "Asuncion", "South America", "Paraguay", "Asuncion"));
        cities.add(new City(10L, "Montevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City(11L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City(12L, "Barcelona", "Europe", "Spain", "Catalunia"));
        cities.add(new City(13L, "Sevilla", "Europe", "Spain", "Andalucia"));
        cities.add(new City(14L, "Monterrey", "North America", "Mexico", "Mexico"));
        cities.add(new City(15L, "Valencia", "Europe", "Spain", "Valencia"));
       
    }

}
