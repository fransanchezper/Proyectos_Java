package com.tienda.tienda.service;

import java.util.List;

import com.tienda.tienda.model.Cliente;

public interface IClienteService {
    // #region GETS
    // metodo para traer todas las cliente
    // lectura
    public List<Cliente> getcliente();

    // Lectura de un solo objeto
    public Cliente findCliente(Long idLong);

    // #endregion

    // #region POST
    // alta
    public void saveCliente(Cliente cliente);

    // #endregion

    // #region DELETES
    // baja
    public void deleteCliente(Long id_clientet);

    // #endregion

    // #region PUT

    // modificar
    public void editCliente(Long idOriginal,
            Long id_clientNueva,
            String nombreNuevo,
            String apellidoNuevo,
            String dniNuevo);
    // #endregion

}
