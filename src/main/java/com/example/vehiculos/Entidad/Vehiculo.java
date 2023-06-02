package com.example.vehiculos.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @Column(name = "CodicoVehiculo")
    private String CodicoVehiculo;

    @Column(name = "Marca")
    private String Marca;

    @Column(name = "Modelo")
    private Integer Modelo;

    @Column(name = "Precio")
    private double Precio;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "Nit", referencedColumnName = "Nit", nullable = false)
    @JsonIgnore
    private Concesionario concesionario;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Venta> vehiculo;

    public Vehiculo() {
    }

    public Vehiculo(String codicoVehiculo, String marca, Integer modelo, double precio, Concesionario concesionario) {
        CodicoVehiculo = codicoVehiculo;
        Marca = marca;
        Modelo = modelo;
        Precio = precio;
        this.concesionario = concesionario;
    }

    public String getCodicoVehiculo() {
        return CodicoVehiculo;
    }

    public void setCodicoVehiculo(String codicoVehiculo) {
        CodicoVehiculo = codicoVehiculo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public Integer getModelo() {
        return Modelo;
    }

    public void setModelo(Integer modelo) {
        Modelo = modelo;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "CodicoVehiculo=" + CodicoVehiculo +
                ", Marca='" + Marca + '\'' +
                ", Modelo=" + Modelo +
                ", Precio=" + Precio +
                ", concesionario=" + concesionario +
                '}';
    }
}
