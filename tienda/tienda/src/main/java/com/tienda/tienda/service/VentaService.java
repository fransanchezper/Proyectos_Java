package com.tienda.tienda.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.model.Producto;
import com.tienda.tienda.model.TuplaLongDouble;
import com.tienda.tienda.model.Venta;
import com.tienda.tienda.model.DTO.VentasDTO;
import com.tienda.tienda.repository.IProductoRepository;
import com.tienda.tienda.repository.IVentaRepository;

@Service
public class VentaService implements iVentaService {

    @Autowired
    private IVentaRepository ventarepo;

    @Autowired
    private IProductoRepository productoRepo;

    // #region CRUD

    // GET LIST
    @Override
    public List<Venta> getVenta() {
        List<Venta> listaVentas = ventarepo.findAll();
        return listaVentas;
    }

    // GET BY ID
    @Override
    public Venta findVenta(Long idVenta) {
        Venta vent = ventarepo.findById(idVenta).orElse(null);
        return vent;
    }

    // POST
    @Override
    public void saveVenta(Venta vent) {
        ventarepo.save(vent);
    }

    // DELETE
    @Override
    public void deleteVenta(Long id_vent) {
        ventarepo.deleteById(id_vent);
    }

    // EDIT
    @Override
    public void editVenta(Long idOriginal,
            Long codigo_ventaNueva,
            Double totalNuevo,
            LocalDate nuevaFechaNueva) {

        Venta venta = this.findVenta(idOriginal);

        if (venta != null) {
            venta.setCodigo_venta(codigo_ventaNueva);
            venta.setTotal(totalNuevo);
            venta.setFecha_venta(nuevaFechaNueva);

            this.saveVenta(venta);
        } else {
            System.out.println("Venta no encontrada con ID: " + idOriginal);
        }
    }
    // #endregion

    // #region GETS

    public List<Producto> getListaProductosByCodigoVenta(Long codigo_venta) {
        return productoRepo.getListaProductosByCodigoVenta(codigo_venta);
    }

    public TuplaLongDouble getResumenVentasPorFecha(LocalDate fecha_venta) {
        return ventarepo.getResumenVentasPorFecha(fecha_venta);
    }

    public VentasDTO getMayorVenta() {
        return ventarepo.getMayorVenta().get(0);
    }
    // #endregion

    // #region PUTS
    // #endregion

    // #region DELETES
    // #endregion

    // #region EDITS
    // #endregion

}
