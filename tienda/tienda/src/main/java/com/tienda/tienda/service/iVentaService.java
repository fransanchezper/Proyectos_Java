package com.tienda.tienda.service;

import java.time.LocalDate;
import java.util.List;

import com.tienda.tienda.model.Venta;

public interface iVentaService {

    //metodo para traer todas las Venta
    //lectura
     public List<Venta> getVenta();
    
    //alta
    public void saveVenta(Venta  vent);
    
    //baja
    public void deleteVenta(Long id_vent); 

    //Lectura de un solo objeto
    public Venta findVenta(Long idLong);

    //modificar
    public void editVenta(Long idOriginal, 
                      Long codigo_ventaNueva, 
                      Double totalNuevo, 
                      LocalDate nuevaFechaNueva);
}
