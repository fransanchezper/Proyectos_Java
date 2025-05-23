package com.tienda.tienda.service;

import java.util.List;

import com.tienda.tienda.model.Cliente;

public interface IClienteService {

    //metodo para traer todas las cliente
    //lectura
     public List<Cliente> getcliente();
    
    //alta
    public void saveCliente(Cliente cliente);
    
    //baja
    public void deleteCliente(Long id_clientet); 

    //Lectura de un solo objeto
    public Cliente findCliente(Long idLong);

    //modificar
    public void editCliente(Long idOriginal,
                            Long id_clientNueva,
                            String nombreNuevo,
                            String apellidoNuevo,
                            String dniNuevo);
}
