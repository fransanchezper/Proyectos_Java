package com.tienda.tienda.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.tienda.model.TuplaLongDouble;
import com.tienda.tienda.model.Venta;
import com.tienda.tienda.model.DTO.VentasDTO;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{

    @Query("SELECT COUNT(v), SUM(v.total) FROM Venta v WHERE v.fecha_venta = :fecha_venta")
     TuplaLongDouble getResumenVentasPorFecha(@Param("fecha_venta") LocalDate fecha_venta);


    @Query(SELECT vd FROM VentasDTO vd WHERE)
     VentasDTO getMayorVenta();
}
