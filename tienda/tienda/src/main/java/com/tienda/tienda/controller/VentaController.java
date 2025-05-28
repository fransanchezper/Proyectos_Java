package com.tienda.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.tienda.model.Producto;
import com.tienda.tienda.model.Venta;
import com.tienda.tienda.service.VentaService;

@RestController
public class VentaController {

    @Autowired
    private VentaService venSer;

    // #region GETS
    @GetMapping("/ventas")
    public List<Venta> getList() {
        return venSer.getVenta();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta buscarVenta(@PathVariable Long codigo_venta) {

        return venSer.findVenta(codigo_venta);
    }

    // @GetMapping("/productos/{codigoVenta}")
    // public List<Producto> obtenerProductosPorVenta(@PathVariable Long
    // codigoVenta) {
    // return venSer.obtenerProductosDeVenta(codigoVenta);
    // }

    
    // #endregion

    // #region POST
    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta vent) {
        venSer.saveVenta(vent);
        return "Se ha creado una persona";
    }

    // #endregion

    // #region DELETES
    @DeleteMapping("/cliente/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta) {
        venSer.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente";
    }
    // #endregion

    // #region PUT

    @PutMapping("/ventas/editar/{idOriginal}")
    public String editarVenta(@PathVariable Long idOriginal, @RequestBody Venta nuevaVenta) {
        venSer.editVenta(
                idOriginal,
                nuevaVenta.getCodigo_venta(),
                nuevaVenta.getTotal(),
                nuevaVenta.getFecha_venta());
        return "Venta editada correctamente";
    }
    // #endregion

}
