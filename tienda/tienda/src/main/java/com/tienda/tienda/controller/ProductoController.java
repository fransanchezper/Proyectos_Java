package com.tienda.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.tienda.model.Producto;
import com.tienda.tienda.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ProductoController {

    @Autowired
    private ProductoService proSer;
    
    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto) {
        proSer.saveProducto(producto);
        return "La persona fue creada correctamente";
    }
    
    @GetMapping("productos")
    public List<Producto> listaProducto() {
     return proSer.getProducto();
    }
    
    @GetMapping("/producto/{codigo_producto}")
    public Producto buscarProducto(@RequestParam Long codigo_producto) {
        return proSer.findProducto(codigo_producto);
    }
    
    @DeleteMapping("/eliminar/{codigo_producto}")
    public String eliminarProducto(@PathVariable Long codigo_producto){
        proSer.deleteProducto(codigo_producto);
        return "Producto eliminado";
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public String editarProducto(@PathVariable Long idOriginal, @RequestBody Producto productoNuevo) {
        proSer.editProducto(idOriginal,
        productoNuevo.getCodigo_producto(),
        productoNuevo.getNombre(),
        productoNuevo.getMarca(),
        productoNuevo.getCosto(),
        productoNuevo.getCantidad_disponible()
        );
        return "Producto editado correctamente";
    }

    @GetMapping("/falta_stock")
    public List<Producto> obtenerProductosConBajoStock() {
        return proSer.obtenerProductosConBajoStock();
    }
}
