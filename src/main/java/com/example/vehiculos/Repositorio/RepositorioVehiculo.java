package com.example.vehiculos.Repositorio;

import com.example.vehiculos.Entidad.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioVehiculo extends JpaRepository<Vehiculo, String> {
}
