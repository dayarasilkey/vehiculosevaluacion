package com.example.vehiculos.Repositorio;
import com.example.vehiculos.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, String> {

   //ArrayList<Cliente> findByNombre(String Nombre);
   //ArrayList<Cliente> findBytelefono(String Telefono);




}
