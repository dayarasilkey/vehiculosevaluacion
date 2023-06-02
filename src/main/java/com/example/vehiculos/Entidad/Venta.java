package com.example.vehiculos.Entidad;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "venta")
public class Venta {

    @Id
    @Column(name = "IdVenta", length = 11)
    private String IdVenta;


    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "IdCliente", referencedColumnName = "IdCliente", nullable = false)
    @JsonIgnore
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "CodicoVehiculo", referencedColumnName = "CodicoVehiculo", nullable = false)
    @JsonIgnore
    private Vehiculo vehiculo;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date Fecha;

    @PrePersist
    public void fechaActual(){
        Fecha=new Date();
    }

    public Venta() {
    }

    public Venta(String idVenta, Cliente cliente, Date fecha) {
        IdVenta = idVenta;
        this.cliente = cliente;
        Fecha = fecha;
    }

    public String getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(String idVenta) {
        IdVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "IdVenta=" + IdVenta +
                ", cliente=" + cliente +
                ", Fecha=" + Fecha +
                '}';
    }
}
