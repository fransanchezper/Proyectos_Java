package com.tienda.tienda.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id_client;    
   private String nombre;
   private String apellido;
   private String dni;

   @OneToMany(mappedBy = "cliente")
   @JsonIgnore
   private List<Venta> ventas;

   public Cliente() {
   }

   public Cliente(Long id_client, String nombre, String apellido, String dni, List<Venta> ventas) {
      this.id_client = id_client;
      this.nombre = nombre;
      this.apellido = apellido;
      this.dni = dni;
      this.ventas = ventas;
   }

   
}
