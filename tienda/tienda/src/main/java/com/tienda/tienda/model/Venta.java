package com.tienda.tienda.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<Producto> productos;
    @OneToOne()
    @JoinColumn(name = "id_client")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(LocalDate fecha_venta, Double total, List<Producto> productos,
            Cliente cliente) {

        this.fecha_venta = fecha_venta;
        this.total = total;
        this.productos = productos;
        this.cliente = cliente;
    }

}
