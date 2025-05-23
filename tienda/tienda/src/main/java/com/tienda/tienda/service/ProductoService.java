package com.tienda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.model.Producto;
import com.tienda.tienda.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService{

     @Autowired
    private IProductoRepository productRepo;

    @Override
    public List<Producto> getProducto() {
         List<Producto> listaProductos = productRepo.findAll();
         return listaProductos;
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        Producto product = productRepo.findById(codigo_producto).orElse(null);
        return product;
    }

    @Override
    public void saveProducto(Producto product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
       productRepo.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Long idOriginal,
                             Long codigo_productoNuevo,
                             String nombreNuevo,
                             String marcaNueva,
                             Double costoNuevo,
                             Double cantidad_disponibleNuevo) {
        Producto producto = this.findProducto(idOriginal);
        if (producto != null) {
            producto.setCodigo_producto(codigo_productoNuevo);
            producto.setNombre(nombreNuevo);
            producto.setMarca(marcaNueva);
            producto.setCosto(costoNuevo);
            producto.setCantidad_disponible(cantidad_disponibleNuevo);

            this.saveProducto(producto);
        }else{
            System.out.println("Producto no encontrada con ID: " + idOriginal);
        }
    }

    public List<Producto> obtenerProductosConBajoStock() {
        return productRepo.findByCantidadDisponibleLessThan(5);
    }
   
}
