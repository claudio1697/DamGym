package com.Gimnasio.AplicacionGimnasio.excepcion;

public class capacidadReservaExcepcion extends  Exception{
    public capacidadReservaExcepcion() {
        super();
    }
    public capacidadReservaExcepcion(String message) {
        super(message);
    }
    public capacidadReservaExcepcion(int id_cliente) {
        super("Clase not found: " + id_cliente);
    }
}
