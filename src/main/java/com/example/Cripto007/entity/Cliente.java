package com.example.Cripto007.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "codiClie", length = 8)
    private String codiClie;

    @Column(name = "appaClie", length = 45, nullable = false)
    private String appaClie;

    @Column(name = "apmaClie", length = 45, nullable = false)
    private String apmaClie;

    @Column(name = "nombClie", length = 60, nullable = false)
    private String nombClie;

    // Getters y setters
    public String getCodiClie() {
        return codiClie;
    }

    public void setCodiClie(String codiClie) {
        this.codiClie = codiClie;
    }

    public String getAppaClie() {
        return appaClie;
    }

    public void setAppaClie(String appaClie) {
        this.appaClie = appaClie;
    }

    public String getApmaClie() {
        return apmaClie;
    }

    public void setApmaClie(String apmaClie) {
        this.apmaClie = apmaClie;
    }

    public String getNombClie() {
        return nombClie;
    }

    public void setNombClie(String nombClie) {
        this.nombClie = nombClie;
    }
}