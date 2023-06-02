package com.example.vehiculos.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "concesionario")
public class Concesionario {
    @Id
    @Column(length = 11)
    private  String Nit;
    @Column(length = 50)
    private String Nombre;
    @Column(length = 25)
    private String Telefono;
    @Column(length = 25)
    private String Direccion;

    @OneToMany(mappedBy = "concesionario", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Vehiculo> concesionario;

    public Concesionario() {
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String nit) {
        Nit = nit;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    @Override
    public String toString() {
        return "Concesionario{" +
                "Nit=" + Nit +
                ", Nombre='" + Nombre + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Direccion='" + Direccion + '\'' +
                '}';
    }
}
