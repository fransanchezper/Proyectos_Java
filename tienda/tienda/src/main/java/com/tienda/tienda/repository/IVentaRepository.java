package com.tienda.tienda.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.tienda.model.TuplaLongDouble;
import com.tienda.tienda.model.Venta;
import com.tienda.tienda.model.DTO.VentasDTO;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT COUNT(v), SUM(v.total) FROM Venta v WHERE v.fecha_venta = :fecha_venta")
    TuplaLongDouble getResumenVentasPorFecha(@Param("fecha_venta") LocalDate fecha_venta);

    @Query("SELECT new com.tienda.tienda.model.DTO.VentasDTO(v.codigo_venta, v.total, count(p.codigoProducto), c.nombre, c.apellido)\n" + //
            "FROM Venta v \n" + //
            "join v.productos p \n" + //
            "join v.cliente c \n" + //
            "where v.total = (SELECT max(v2.total) FROM Venta v2) \n" + //
            "group by v.codigo_venta")
    List<VentasDTO> getMayorVenta();
}
