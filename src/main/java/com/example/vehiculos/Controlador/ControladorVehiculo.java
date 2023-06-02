package com.example.vehiculos.Controlador;

import com.example.vehiculos.Entidad.Cliente;
import com.example.vehiculos.Entidad.Vehiculo;
import com.example.vehiculos.Servicio.ServicioCliente;
import com.example.vehiculos.Servicio.ServicioVehiculo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorVehiculo {

    private ServicioVehiculo servicio;

    public ControladorVehiculo(ServicioVehiculo servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarVehiculos")
    public ArrayList<Vehiculo> Listarveh(){
        return servicio.ListarVehiculos();
    }

    @GetMapping ("/buscarVehiculo/{CodicoVehiculo}")
    Vehiculo buscarVehiculo(@PathVariable("CodicoVehiculo")String CodicoVehiculo){
        return  servicio.buscarVehiculo(CodicoVehiculo);
    }

    @PostMapping("/agregarvehiculo")
    public  String agregarvehiculo(@RequestBody Vehiculo vehiculo){
        return servicio.agregarVehiculo(vehiculo);
    }

    @PutMapping("/actualizarVehiculo")
    public  String actualizarVehiculo(@RequestBody Vehiculo vehiculo){
        return servicio.actualizarVehiculo(vehiculo);
    }

    @DeleteMapping("/eliminarVehiculo/{CodicoVehiculo}")
    public String eliminarVehiculo(@PathVariable("CodicoVehiculo") String CodicoVehiculo){
        return servicio.eliminarVehiculo(CodicoVehiculo);
    }
}
