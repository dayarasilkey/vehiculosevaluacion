package com.example.vehiculos.Servicio;

import com.example.vehiculos.Entidad.Cliente;
import com.example.vehiculos.Repositorio.RepositorioCliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioCliente {

    private RepositorioCliente repositorio;

    public ServicioCliente(RepositorioCliente repositorio) {
        this.repositorio = repositorio;
    }

    //Metodo Listar tos los Clientes
    public ArrayList<Cliente> ListarClientes() {
        return (ArrayList<Cliente>) repositorio.findAll();
    }

    //Metodo buscar por Id
    public Cliente buscarCliente(String IdCliente) {
        if (repositorio.findById(IdCliente).isPresent())
            return repositorio.findById(IdCliente).get();
        else return null;
    }


    //Metodo Agregar
    public String agregarCliente(Cliente cliente) {

        if (repositorio.findById(cliente.getIdCliente()).isPresent())
            return "El cliente ya se encuentra registrado";
        else
            repositorio.save(cliente);
        return "El cliente se registro exitosamente.";

    }


    //Metodo Actualizar
    public String actualizarCliente(Cliente cliente) {

        if (repositorio.findById(cliente.getIdCliente()).isPresent()){
            repositorio.save(cliente);
            return "El cliente se actualizo exitosamente.";
        }
        else{
            return "El cliente no se encuentra registrado";

        }
    }

    //Metodo eliminar
    public String eliminarCliente(String IdCliente) {
        if (repositorio.findById(IdCliente).isPresent()) {
            repositorio.deleteById(IdCliente);
            return "Cliente eliminado";
        } else {
            return "El cliente no se encuentra registrado";
        }
    }
}
