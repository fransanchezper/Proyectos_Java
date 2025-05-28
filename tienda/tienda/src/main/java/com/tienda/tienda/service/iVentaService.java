package com.tienda.tienda.service;

import java.time.LocalDate;
import java.util.List;

import com.tienda.tienda.model.Venta;

public interface iVentaService {

    // #region GETS
    // Lectura de un solo objeto
    public Venta findVenta(Long idLong);

    // metodo para traer todas las Venta
    // lectura
    public List<Venta> getVenta();

    // #endregion

    // #region PUTS
    // alta
    public void saveVenta(Venta vent);
    // #endregion

    // #region DELETES
    // baja
    public void deleteVenta(Long id_vent);
    // #endregion

    // #region EDITS
    // modificar
    public void editVenta(Long idOriginal,
            Long codigo_ventaNueva,
            Double totalNuevo,
            LocalDate nuevaFechaNueva);
    // #endregion
}
