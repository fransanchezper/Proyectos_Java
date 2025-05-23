package com.tienda.tienda.service;

import java.util.List;

import com.tienda.tienda.model.Producto;

public interface IProductoService{

 //metodo para traer todas las producto
    //lectura
     public List<Producto> getProducto();
    
      //Lectura de un solo objeto
    public Producto findProducto(Long idLong);

    //alta
    public void saveProducto(Producto product);
    
    //baja
    public void deleteProducto(Long id_product); 

   //modificar
    public void editProducto(Long idOriginal,
                             Long codigo_productoNuevo,
                             String nombreNuevo,
                             String marcaNueva,
                             Double costoNuevo,
                             Double cantidad_disponibleNuevo);
}



