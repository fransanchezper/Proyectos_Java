package com.tienda.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.tienda.model.Cliente;
import com.tienda.tienda.service.ClienteService;





@RestController
public class ClienteController {
    @Autowired
    private ClienteService cliSer;

    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente) {
        cliSer.saveCliente(cliente);
         return "Cliente creado";
    }
    
    @GetMapping("/clientes")
    public List<Cliente> listaCliente() {
        return cliSer.getcliente();
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente getMethodName(@PathVariable Long id_cliente) {
        return cliSer.findCliente(id_cliente);
    }

    @DeleteMapping("/eliminar/{id_cliente}")
    public String eliminarCliente(@PathVariable Long id_cliente){
        cliSer.deleteCliente(id_cliente);
        return "El cliente ha sido eliminado";
    }

    @PutMapping("/clientes/editar/{idOriginal}")
    public String editarCliente(@PathVariable Long idOriginal, @RequestBody Cliente clienteNuevo) {
        cliSer.editCliente(idOriginal,
                           clienteNuevo.getId_client(),
                           clienteNuevo.getNombre(),
                           clienteNuevo.getApellido(),
                           clienteNuevo.getDni());

        return "Cliente editado";
    }


}
