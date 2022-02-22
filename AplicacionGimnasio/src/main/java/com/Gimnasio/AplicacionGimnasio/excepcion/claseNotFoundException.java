package com.Gimnasio.AplicacionGimnasio.excepcion;


public class claseNotFoundException extends RuntimeException{
    public claseNotFoundException() {
        super();
    }
    public claseNotFoundException(String message) {
        super(message);
    }
    public claseNotFoundException(long id_clase) {
        super("Clase not found: " + id_clase);
    }

}
