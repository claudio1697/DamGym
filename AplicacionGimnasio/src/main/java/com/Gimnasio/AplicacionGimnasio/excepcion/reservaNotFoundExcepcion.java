package com.Gimnasio.AplicacionGimnasio.excepcion;

public class reservaNotFoundExcepcion extends RuntimeException{
    public reservaNotFoundExcepcion() {
        super();
    }
    public reservaNotFoundExcepcion(String message) {
        super(message);
    }
    public reservaNotFoundExcepcion(long id) {
        super("Clientes not found: " + id);
    }
}
