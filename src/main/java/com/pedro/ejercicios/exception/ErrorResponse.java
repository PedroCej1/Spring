package com.pedro.ejercicios.exception;

import java.time.LocalDateTime;

/**
 * Clase que representa la estructura de la respuesta de error de la API.
 *
 * <p>
 * Este objeto se utiliza para devolver informacion estructurada cuando
 * ocurre una excepcion dentro de la aplicacion. Normalmente es creado
 * por el manejador global de excepciones (GlobalExceptionHandler)
 * y enviado al cliente como respuesta HTTP.
 * </p>
 *
 * <p>
 * La respuesta incluye:
 * <ul>
 *     <li>El codigo de error HTTP</li>
 *     <li>Un mensaje descriptivo del error</li>
 *     <li>La fecha y hora en la que ocurrio el error</li>
 * </ul>
 * </p>
 */
public class ErrorResponse {

    /**
     * Codigo de error HTTP asociado a la excepcion.
     */
    private int codigo;

    /**
     * Mensaje descriptivo del error ocurrido.
     */
    private String mensaje;

    /**
     * Fecha y hora en la que se produjo el error.
     */
    private LocalDateTime timestamp;

    /**
     * Constructor que inicializa la respuesta de error.
     *
     * @param codigo codigo de estado HTTP asociado al error
     * @param mensaje mensaje descriptivo del error
     * @param timestamp fecha y hora en la que ocurrio el error
     */
    public ErrorResponse(int codigo, String mensaje, LocalDateTime timestamp) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
    }

    /**
     * Devuelve el codigo de error HTTP.
     *
     * @return codigo de error
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el mensaje asociado al error.
     *
     * @return mensaje descriptivo del error
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Devuelve la fecha y hora en la que ocurrio el error.
     *
     * @return timestamp del error
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}