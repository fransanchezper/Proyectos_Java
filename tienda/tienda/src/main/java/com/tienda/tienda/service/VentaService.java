package com.tienda.tienda.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.model.Producto;
import com.tienda.tienda.model.Venta;
import com.tienda.tienda.repository.IVentaRepository;

@Service
public class VentaService implements iVentaService{

    @Autowired
    private IVentaRepository ventarepo;

    @Override
    public List<Venta> getVenta() {
       List<Venta> listaVentas = ventarepo.findAll();
       return listaVentas;
    }

    @Override
    public void saveVenta(Venta vent) {
       ventarepo.save(vent);
    }

    @Override
    public void deleteVenta(Long id_vent) {
        ventarepo.deleteById(id_vent);
    }

    @Override
    public Venta findVenta(Long idVenta) {
       Venta vent = ventarepo.findById(idVenta).orElse(null);
       return vent;
    }

   @Override
public void editVenta(Long idOriginal, 
                      Long codigo_ventaNueva, 
                      Double totalNuevo, 
                      LocalDate nuevaFechaNueva) {

    Venta venta = this.findVenta(idOriginal);

    if (venta != null) {
        venta.setCodigo_venta(codigo_ventaNueva);
        venta.setTotal(totalNuevo);
        venta.setFecha_venta(nuevaFechaNueva);

        this.saveVenta(venta);
    } else {
        System.out.println("Venta no encontrada con ID: " + idOriginal);
    }
}

public List<Producto> obtenerProductosDeVenta(Long codigoVenta) {
        Venta venta = ventarepo.findById(codigoVenta)
            .orElseThrow(() -> new RuntimeException("Venta no encontrada")); // esto es una excepcion que lanza este mensaje si es null codigoVenta
        
        return venta.getProductos();
    }
}

