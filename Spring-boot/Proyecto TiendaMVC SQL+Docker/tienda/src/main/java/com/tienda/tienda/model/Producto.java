package com.tienda.tienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoProducto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidadDisponible;
    @ManyToOne
    @JoinColumn(name="codigo_venta")
    @JsonIgnore
    private Venta venta;

    public Producto() {
    }

    public Producto(Long codigoProducto, String nombre, String marca, Double costo, Double cantidadDisponible,
            Venta venta) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
        this.venta = venta;
    }


    


}
