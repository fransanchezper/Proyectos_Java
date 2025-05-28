package com.tienda.tienda.service;

import java.time.LocalDate;
import java.util.List;

import com.tienda.tienda.model.Venta;

public interface iVentaService {

    // #region GETS
    
    // metodo para traer todas las Venta
    public List<Venta> getVenta();

    // Lectura de un solo objeto
    public Venta findVenta(Long idLong);

    // #endregion

    // #region PUTS
    // POST
    public void saveVenta(Venta vent);
    // #endregion

    // #region DELETES
    // DELETE
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
