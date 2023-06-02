package com.example.vehiculos.Servicio;

import com.example.vehiculos.Entidad.Concesionario;
import com.example.vehiculos.Entidad.Vehiculo;
import com.example.vehiculos.Repositorio.RepositorioCliente;
import com.example.vehiculos.Repositorio.RepositorioConsecionario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioConsecionario {
    private RepositorioConsecionario repositorio;

    public ServicioConsecionario(RepositorioConsecionario repositorio) {
        this.repositorio = repositorio;
    }

    //Metodo Listar
    public ArrayList<Concesionario> ListarConsecionario() {
        return (ArrayList<Concesionario>) repositorio.findAll();
    }

    //Metodo buscar por Id
    public Concesionario buscarConcesionario(String Nit) {
        if (repositorio.findById(Nit).isPresent())
            return repositorio.findById(Nit).get();
        else return null;
    }


    //Metodo Agregar
    public String agregarVehiculo(Concesionario concesionario) {

        if (repositorio.findById(concesionario.getNit()).isPresent())
            return "El Consecionario ya se encuentra registrado";
        else
            repositorio.save(concesionario);
        return "El consecionario se registro exitosamente.";

    }


    //Metodo Actualizar
    public String actualizarConsecionario(Concesionario concesionario) {

        if (repositorio.findById(concesionario.getNit()).isPresent()){
            repositorio.save(concesionario);
            return "El concesionario se actualizo exitosamente.";
        }
        else{
            return "El concesionario no se encuentra registrado";

        }
    }

    //Metodo eliminar
    public String eliminarConcesionario(String Nit) {
        if (repositorio.findById(Nit).isPresent()) {
            repositorio.deleteById(Nit);
            return "Concesionario eliminado";
        } else {
            return "El concesionario no se encuentra registrado";
        }
    }
}
