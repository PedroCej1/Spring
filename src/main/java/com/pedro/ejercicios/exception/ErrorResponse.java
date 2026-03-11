package com.pedro.ejercicios.exception;

import java.time.LocalDateTime;

/**
 * Clase que representa la respuesta de error de la API.
 */
public class ErrorResponse {

    private int codigo;
    private String mensaje;
    private LocalDateTime timestamp;

    public ErrorResponse(int codigo, String mensaje, LocalDateTime timestamp) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}