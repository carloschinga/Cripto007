package com.example.Cripto007.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "codiUsua", length = 8, nullable = false)
    private String codiUsua;

    @Column(name = "logiUsua", length = 40, nullable = false)
    private String logiUsua;

    @Column(name = "passUsua", length = 120, nullable = false)
    private String passUsua;

    // Getters y Setters
    public String getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(String codiUsua) {
        this.codiUsua = codiUsua;
    }

    public String getLogiUsua() {
        return logiUsua;
    }

    public void setLogiUsua(String logiUsua) {
        this.logiUsua = logiUsua;
    }

    public String getPassUsua() {
        return passUsua;
    }

    public void setPassUsua(String passUsua) {
        this.passUsua = passUsua;
    }
}
