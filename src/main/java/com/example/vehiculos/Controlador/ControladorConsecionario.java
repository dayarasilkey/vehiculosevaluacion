package com.example.vehiculos.Controlador;


import com.example.vehiculos.Entidad.Concesionario;
import com.example.vehiculos.Entidad.Vehiculo;
import com.example.vehiculos.Servicio.ServicioConsecionario;
import com.example.vehiculos.Servicio.ServicioVehiculo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorConsecionario {

    private ServicioConsecionario servicio;

    public ControladorConsecionario(ServicioConsecionario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarConsecionarios")
    public ArrayList<Concesionario> Listarcon(){
        return servicio.ListarConsecionario();
    }

    @GetMapping ("/buscarConsecionario/{Nit}")
    Concesionario buscarConsecionario(@PathVariable("Nit")String Nit){
        return  servicio.buscarConcesionario(Nit);
    }

    @PostMapping("/agregarconsecionario")
    public  String agregarconsecionario(@RequestBody Concesionario concesionario){
        return servicio.agregarVehiculo(concesionario);
    }

    @PutMapping("/actualizarConsecionario")
    public  String actualizarConsecionario(@RequestBody Concesionario concesionario){
        return servicio.actualizarConsecionario(concesionario);
    }

    @DeleteMapping("/eliminarConcesionario/{Nit}")
    public String eliminarConcesionario(@PathVariable("Nit") String Nit){
        return servicio.eliminarConcesionario(Nit);
    }
}
