package com.tienda.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.tienda.model.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{

}
