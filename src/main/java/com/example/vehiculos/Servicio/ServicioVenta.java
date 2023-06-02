package com.example.vehiculos.Servicio;


import com.example.vehiculos.Entidad.Cliente;
import com.example.vehiculos.Entidad.Venta;
import com.example.vehiculos.Repositorio.RepositorioVenta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioVenta {

    private RepositorioVenta repositorio;

    public ServicioVenta(RepositorioVenta repositorio) {
        this.repositorio = repositorio;
    }

    //Metodo Listar tos los Clientes
    public ArrayList<Venta> ListarVentas() {
        return (ArrayList<Venta>) repositorio.findAll();
    }

    //Metodo buscar por Id
    public Venta buscarVenta(String IdVenta) {
        if (repositorio.findById(IdVenta).isPresent())
            return repositorio.findById(IdVenta).get();
        else return null;
    }


    //Metodo Agregar
    public String agregarVenta(Venta venta) {

        if (repositorio.findById(venta.getIdVenta()).isPresent())
            return "La venta ya se encuentra registrado";
        else
            repositorio.save(venta);
        return "La venta se registro exitosamente.";

    }

    //Metodo Actualizar
    public String actualizarVenta(Venta venta) {

        if (repositorio.findById(venta.getIdVenta()).isPresent()){
            repositorio.save(venta);
            return "La venta se actualizo exitosamente.";
        }
        else{
            return "La venta no se encuentra registrado";

        }
    }

    //Metodo eliminar
    public String eliminarVenta(String IdVenta) {
        if (repositorio.findById(IdVenta).isPresent()) {
            repositorio.deleteById(IdVenta);
            return "Venta eliminado";
        } else {
            return "La venta no se encuentra registrado";
        }
    }




}
