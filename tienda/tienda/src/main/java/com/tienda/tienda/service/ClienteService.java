package com.tienda.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.tienda.model.Cliente;
import com.tienda.tienda.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public List<Cliente> getcliente() {
       List<Cliente> listaClientes = clienteRepo.findAll();
       return listaClientes;
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
       clienteRepo.deleteById(id_cliente);
    }

    @Override
    public Cliente findCliente(Long idCliente) {
        Cliente cliente = clienteRepo.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public void editCliente(Long idOriginal,
                            Long id_clientNueva,
                            String nombreNuevo,
                            String apellidoNuevo,
                            String dniNuevo) {
        Cliente cliente = this.findCliente(idOriginal);

        if(cliente != null){
        cliente.setId_client(id_clientNueva);                       
        cliente.setNombre(nombreNuevo);
        cliente.setApellido(apellidoNuevo);
        cliente.setDni(dniNuevo);

        this.saveCliente(cliente);
        }
    }

}
