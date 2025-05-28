package com.tienda.tienda.service;

import java.util.List;

import com.tienda.tienda.model.Producto;

public interface IProductoService {
  // #region GETS

  // metodo para traer todas las producto
  // lectura
  public List<Producto> getProducto();

  // Lectura de un solo objeto
  public Producto findProducto(Long idLong);

  // #endregion

  // #region PUTS
  // alta
  public void saveProducto(Producto product);

  // #endregion

  // #region DELETES
  // baja
  public void deleteProducto(Long id_product);

  // #endregion

  // #region EDITS
  // modificar
  public void editProducto(Long idOriginal,
      Long codigoProductoNuevo,
      String nombreNuevo,
      String marcaNueva,
      Double costoNuevo,
      Double cantidadDisponibleNuevo);
  // #endregion

}
