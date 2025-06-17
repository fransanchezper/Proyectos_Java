package com.tienda.tienda.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VentasDTO {
   
    private Long ventaId;
    private Double total;
    private Long cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentasDTO() {
    }

    public VentasDTO(Long ventaId, Double total, Long cantidadProductos, String nombreCliente,
            String apellidoCliente) {
        this.ventaId = ventaId;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

}
