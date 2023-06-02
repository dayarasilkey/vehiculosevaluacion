package com.example.vehiculos.Controlador;

import com.example.vehiculos.Entidad.Cliente;
import com.example.vehiculos.Entidad.Venta;
import com.example.vehiculos.Servicio.ServicioVenta;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorVenta {
    private ServicioVenta servicio;

    public ControladorVenta(ServicioVenta servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarVentas")
    public ArrayList<Venta> Listarven() {
        return servicio.ListarVentas();
    }

    @GetMapping("/buscarVenta/{IdVenta}")
    Venta buscarVenta(@PathVariable("IdVenta") String IdVenta) {
        return servicio.buscarVenta(IdVenta);
    }

    @PostMapping("/agregarventa")
    public  String agregarventa(@RequestBody Venta venta){
        return servicio.agregarVenta(venta);
    }

    @PutMapping("/actualizarVenta")
    public  String actualizarCliente(@RequestBody Venta venta){
        return servicio.actualizarVenta(venta);
    }

    @DeleteMapping("/eliminarVenta/{IdVenta}")
    public String eliminarCliente(@PathVariable("IdVenta") String IdVenta){
        return servicio.eliminarVenta(IdVenta);
    }
}
