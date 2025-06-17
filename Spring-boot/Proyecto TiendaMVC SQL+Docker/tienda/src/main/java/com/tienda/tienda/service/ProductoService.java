package com.tienda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.model.Producto;
import com.tienda.tienda.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productRepo;

    // #region CRUD

    // GET LIST
    @Override
    public List<Producto> getProducto() {
        List<Producto> listaProductos = productRepo.findAll();
        return listaProductos;
    }

    // FIND BY ID
    @Override
    public Producto findProducto(Long codigo_producto) {
        Producto product = productRepo.findById(codigo_producto).orElse(null);
        return product;
    }

    // POST
    @Override
    public void saveProducto(Producto product) {
        productRepo.save(product);
    }

    // DELETE
    @Override
    public void deleteProducto(Long codigo_producto) {
        productRepo.deleteById(codigo_producto);
    }

    // EDIT
    @Override
    public void editProducto(Long idOriginal,
            Long codigoProductoNuevo,
            String nombreNuevo,
            String marcaNueva,
            Double costoNuevo,
            Double cantidadDisponibleNuevo) {
        Producto producto = this.findProducto(idOriginal);
        if (producto != null) {
            producto.setCodigoProducto(codigoProductoNuevo);
            producto.setNombre(nombreNuevo);
            producto.setMarca(marcaNueva);
            producto.setCosto(costoNuevo);
            producto.setCantidadDisponible(cantidadDisponibleNuevo);

            this.saveProducto(producto);
        } else {
            System.out.println("Producto no encontrada con ID: " + idOriginal);
        }
    }

    // #endregion
    
    // #region GETS
    //PRODUCTO->filtra por producto.cantidadDisponible < 5
    public List<Producto> obtenerProductosConBajoStock(){
        return productRepo.obtenerProductosConBajoStock(5);
        

    }
    
  
    // #endregion

    // #region POSTS
    // #endregion

    // #region DELETES
    // #endregion

    // #region EDITS
    // #endregion

}
