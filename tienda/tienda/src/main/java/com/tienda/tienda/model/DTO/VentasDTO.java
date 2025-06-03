package com.tienda.tienda.model.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VentasDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ventaId;
    private Double total;
    private Integer cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentasDTO() {
    }

    public VentasDTO(Long ventaId, Double total, Integer cantidadProductos, String nombreCliente,
            String apellidoCliente) {
        this.ventaId = ventaId;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

}
