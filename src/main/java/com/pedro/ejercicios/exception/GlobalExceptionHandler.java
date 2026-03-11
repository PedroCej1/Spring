package com.pedro.ejercicios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * Manejador global de excepciones de la aplicación.
 *
 * <p>
 * Esta clase permite capturar excepciones lanzadas por los
 * controladores de Spring de forma centralizada.
 * </p>
 *
 * <p>
 * Gracias a la anotación {@link ControllerAdvice}, Spring detecta
 * automáticamente esta clase y la utiliza para interceptar errores
 * producidos durante la ejecución de los endpoints REST.
 * </p>
 *
 * <p>
 * Su objetivo es devolver respuestas de error estructuradas al cliente
 * en lugar de mostrar trazas internas de la aplicación.
 * </p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones generales de tipo {@link Exception}.
     *
     * <p>
     * Cuando se produce cualquier excepcion no controlada dentro
     * de la aplicacion, este metodo crea un objeto ErrorResponse
     * con la informacion del error y devuelve una respuesta HTTP 500.
     * </p>
     *
     * @param ex excepcion capturad durante la ejecucion de la aplicacion
     * @return ResponseEntity que contiene la informacion del error y
     *         el código HTTP 500 (Internal Server Error)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {

        ErrorResponse error = new ErrorResponse(
                500,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}