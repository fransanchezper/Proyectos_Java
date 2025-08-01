package com.tienda.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienda.tienda.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p  where p.cantidadDisponible<:cantidad")
    List<Producto> obtenerProductosConBajoStock(@Param("cantidad") int cantidad);

    @Query("SELECT p FROM Producto p  where p.venta = :codigo_venta ")
    List<Producto> getListaProductosByCodigoVenta(@Param("codigo_venta") Long codigo_venta);
}
