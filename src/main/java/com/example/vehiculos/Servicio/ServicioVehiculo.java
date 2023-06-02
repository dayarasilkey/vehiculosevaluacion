package com.example.vehiculos.Servicio;

import com.example.vehiculos.Entidad.Cliente;
import com.example.vehiculos.Entidad.Vehiculo;
import com.example.vehiculos.Repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioVehiculo {
    private RepositorioVehiculo repositorio;

    public ServicioVehiculo(RepositorioVehiculo repositorio) {
        this.repositorio = repositorio;
    }

    //Metodo Listar tos los Vehiculos
    public ArrayList<Vehiculo> ListarVehiculos() {
        return (ArrayList<Vehiculo>) repositorio.findAll();
    }

    //Metodo buscar por Id
    public Vehiculo buscarVehiculo(String CodicoVehiculo) {
        if (repositorio.findById(CodicoVehiculo).isPresent())
            return repositorio.findById(CodicoVehiculo).get();
        else return null;
    }


    //Metodo Agregar
    public String agregarVehiculo(Vehiculo vehiculo) {

        if (repositorio.findById(vehiculo.getCodicoVehiculo()).isPresent())
            return "El vehiculo ya se encuentra registrado";
        else
            repositorio.save(vehiculo);
        return "El vehiculo se registro exitosamente.";

    }


    //Metodo Actualizar
    public String actualizarVehiculo(Vehiculo vehiculo) {

        if (repositorio.findById(vehiculo.getCodicoVehiculo()).isPresent()){
            repositorio.save(vehiculo);
            return "El vehiculo se actualizo exitosamente.";
        }
        else{
            return "El vehiculo no se encuentra registrado";

        }
    }

    //Metodo eliminar
    public String eliminarVehiculo(String CodicoVehiculo) {
        if (repositorio.findById(CodicoVehiculo).isPresent()) {
            repositorio.deleteById(CodicoVehiculo);
            return "Vehiculo eliminado";
        } else {
            return "El vehiculo no se encuentra registrado";
        }
    }

}
