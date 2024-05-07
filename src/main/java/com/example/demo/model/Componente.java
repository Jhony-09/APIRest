package com.example.demo.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Entity
@JsonSerialize
@Table(name = "componentes")
public class Componente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMP")
    private int idComp;

    @Column(name = "NOMBRE_COMP")
    private String nombreComp;

    @Column(name = "DESCRIPCION_COMP")
    private String descripcionComp;

    @Column(name = "PRECIO_COMP")
    private BigDecimal precioComp;

    @Column(name = "STOCK_COMP")
    private int stockComp;

}
