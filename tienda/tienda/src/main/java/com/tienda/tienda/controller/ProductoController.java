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

    // #region GETS
    @GetMapping("productos")
    public List<Producto> listaProducto() {
        return proSer.getProducto();
    }

    @GetMapping("/producto/{codigoProducto}")
    public Producto buscarProducto(@RequestParam Long codigoProducto) {
        return proSer.findProducto(codigoProducto);
    }

    @GetMapping("/falta_stock")
    public List<Producto> obtenerProductosConBajoStock() {
        return proSer.obtenerProductosConBajoStock();
    }
    // #endregion

    // #region POSTS

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto) {
        proSer.saveProducto(producto);
        return "La persona fue creada correctamente";
    }
    // #endregion

    // #region PUTS

    @PutMapping("/productos/editar/{codigoProducto}")
    public String editarProducto(@PathVariable Long idOriginal, @RequestBody Producto productoNuevo) {
        proSer.editProducto(idOriginal,
                productoNuevo.getCodigoProducto(),
                productoNuevo.getNombre(),
                productoNuevo.getMarca(),
                productoNuevo.getCosto(),
                productoNuevo.getCantidadDisponible());
        return "Producto editado correctamente";
    }
    // #endregion

    // #region DELETES

    @DeleteMapping("/eliminar/{codigoProducto}")
    public String eliminarProducto(@PathVariable Long codigoProducto) {
        proSer.deleteProducto(codigoProducto);
        return "Producto eliminado";
    }
    // #endregion

}
