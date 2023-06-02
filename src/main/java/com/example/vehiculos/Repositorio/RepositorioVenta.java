package com.example.vehiculos.Repositorio;

import com.example.vehiculos.Entidad.Cliente;
import com.example.vehiculos.Entidad.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface RepositorioVenta extends JpaRepository<Venta, String> {

    //ArrayList<Venta> findByFecha(Date Fecha);
}
