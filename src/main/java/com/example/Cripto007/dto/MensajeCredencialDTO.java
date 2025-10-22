package com.example.Cripto007.dto;

public class MensajeCredencialDTO {
    private String resultado;
    private String mensaje;

    public MensajeCredencialDTO(String resultado, String mensaje) {
        this.resultado = resultado;
        this.mensaje = mensaje;
    }
    public MensajeCredencialDTO() {

    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
