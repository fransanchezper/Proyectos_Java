package com.tienda.tienda.controller;

import java.time.LocalDate;
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
import com.tienda.tienda.model.TuplaLongDouble;
import com.tienda.tienda.model.Venta;
import com.tienda.tienda.model.DTO.VentasDTO;
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
    
   
    //Productos segun venta id
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getListaProductosByCodigoVenta(@PathVariable Long codigo_venta) {

        return venSer.getListaProductosByCodigoVenta(codigo_venta);
    }

    @GetMapping("/ventas/resumen_venta/{fecha_venta}")
    public TuplaLongDouble getResumenVentasPorFecha(@PathVariable LocalDate fecha_venta) {
        return venSer.getResumenVentasPorFecha(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public VentasDTO getMayorVenta() {
        return venSer.getMayorVenta();
    }
    // #endregion

    // #region POSTS
    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta) {
        for (Producto p : venta.getProductos()) {
            p.setVenta(venta);
        }
        venSer.saveVenta(venta);
        return "Se ha creado una venta";
    }

    // #endregion

    // #region DELETES
    @DeleteMapping("/cliente/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta) {
        venSer.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente";
    }
    // #endregion

    // #region PUTS
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
