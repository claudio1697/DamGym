package com.Gimnasio.AplicacionGimnasio.excepcion;

import org.springframework.http.HttpStatus;

public class reservaNotFoundExcepcion extends RuntimeException{
    public reservaNotFoundExcepcion() {
        super();
    }
    public reservaNotFoundExcepcion(String message , HttpStatus status) {
        super(message);
    }
    public reservaNotFoundExcepcion(long id, HttpStatus status) {
        super("Reserva not found: " + id + status);
    }
}
