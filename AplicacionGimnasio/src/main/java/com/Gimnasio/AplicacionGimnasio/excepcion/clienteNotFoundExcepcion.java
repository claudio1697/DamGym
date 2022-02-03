package com.Gimnasio.AplicacionGimnasio.excepcion;

    public class clienteNotFoundExcepcion extends RuntimeException{
        public clienteNotFoundExcepcion() {
            super();
        }
        public clienteNotFoundExcepcion(String message) {
            super(message);
        }
        public clienteNotFoundExcepcion(long id) {
            super("Clientes not found: " + id);
        }
    }

