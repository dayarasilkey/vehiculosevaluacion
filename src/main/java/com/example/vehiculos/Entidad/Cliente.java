package com.example.vehiculos.Entidad;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = " ", length = 11)
    private String IdCliente;

    @Column(name = "Nombre", nullable = false, length= 50)
    private String Nombre;



    //@Column(name = "Telefono",nullable = false, length= 11)
    //private String Telefono;

    @Column(name = "Direccion", nullable = false, length= 50)
    private String Direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Venta> cliente;

    public Set<Venta> getCliente() {
        return cliente;
    }

    public void setCliente(Set<Venta> cliente) {
        this.cliente = cliente;
    }

    public Cliente() {
    }

    public Cliente(String idCliente, String nombre, String direccion) {
        IdCliente = idCliente;
        Nombre = nombre;
        Direccion = direccion;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String idCliente) {
        IdCliente = idCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "IdCliente='" + IdCliente + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Direccion='" + Direccion + '\'' +
                '}';
    }
}
