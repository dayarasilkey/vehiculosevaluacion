package com.example.vehiculos.Repositorio;

import com.example.vehiculos.Entidad.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioConsecionario extends JpaRepository<Concesionario, String> {
}
