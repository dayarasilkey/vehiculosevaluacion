package com.example.vehiculos.Controlador;

import com.example.vehiculos.Entidad.Cliente;
import com.example.vehiculos.Servicio.ServicioCliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorCliente {
    private ServicioCliente servicioCliente;

    public ControladorCliente(ServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
    }

    @GetMapping("/listarClientes")
    public ArrayList<Cliente> Listarcli(){
        return servicioCliente.ListarClientes();
    }

    @GetMapping ("/buscarCliente/{IdCliente}")
    Cliente buscarCliente(@PathVariable("IdCliente")String IdCliente){
        return  servicioCliente.buscarCliente(IdCliente);
    }

    //@GetMapping ("/buscarNombre/{Nombre}")
    //public ArrayList<Cliente> buscarNombre(@PathVariable("Nombre")String n){
    //    return servicio.buscarNombre(n);
    //}

    //@GetMapping ("/buscarTelefono/{Telefono}")
    //public ArrayList<Cliente> buscarTelefono(@PathVariable("Telefono")String t){
      //  return servicioCliente.buscarTelefono(t);
    //}


    @PostMapping("/agregarcliente")
    public  String agregarcliente(@RequestBody Cliente cliente){
        return servicioCliente.agregarCliente(cliente);
    }

    @PutMapping("/actualizarCliente")
    public  String actualizarCliente(@RequestBody Cliente cliente){
        return servicioCliente.actualizarCliente(cliente);
    }

    @DeleteMapping("/eliminarCliente/{IdCliente}")
    public String eliminarCliente(@PathVariable("IdCliente") String IdCliente){
        return servicioCliente.eliminarCliente(IdCliente);
    }


}
