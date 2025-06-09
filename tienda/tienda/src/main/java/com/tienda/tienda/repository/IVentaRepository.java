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


    @Query("SELECT v.codigo_venta, v.total, count(p.codigo_producto) as cantidad_producto, c.nombre, c.apellido\n" + //
                "FROM Venta v \n" + //
                "join Producto p on v.codigo_venta = p.codigo_venta\n" + //
                "join Cliente c on v.id_client = c.id_client\n" + //
                "where v.total = (SELECT max(total) FROM Venta) \n" + //
                "group by v.codigo_venta limit 1;")
     VentasDTO getMayorVenta();
}
