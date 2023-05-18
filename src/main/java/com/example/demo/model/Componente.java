package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;


/**
 *
 * @author jhony
 */


@Entity
@Table(name = "componentes")
public class Componente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private int idComp;

    @Column(name = "NOMBRE_COMP")
    private String nombreComp;

    @Column(name = "DESCRIPCION_COMP")
    private String descripcionComp;

    @Column(name = "PRECIO_COMP")
    private BigDecimal precioComp;

    @Column(name = "STOCK_COMP")
    private int stockComp;

    // Constructor sin argumentos
    public Componente() {
    }

    // Constructor con parámetros principales
    public Componente(String nombreComp, String descripcionComp, BigDecimal precioComp, int stockComp) {
        this.nombreComp = nombreComp;
        this.descripcionComp = descripcionComp;
        this.precioComp = precioComp;
        this.stockComp = stockComp;
    }

    public int getIdComp() {
        return idComp;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    public String getNombreComp() {
        return nombreComp;
    }

    public void setNombreComp(String nombreComp) {
        this.nombreComp = nombreComp;
    }

    public String getDescripcionComp() {
        return descripcionComp;
    }

    public void setDescripcionComp(String descripcionComp) {
        this.descripcionComp = descripcionComp;
    }

    public BigDecimal getPrecioComp() {
        return precioComp;
    }

    public void setPrecioComp(BigDecimal precioComp) {
        this.precioComp = precioComp;
    }

    public int getStockComp() {
        return stockComp;
    }

    public void setStockComp(int stockComp) {
        this.stockComp = stockComp;
    }

    // Implementación de equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Componente componente = (Componente) o;

        return idComp == componente.idComp;
    }

    @Override
    public int hashCode() {
        return idComp;
    }
}
