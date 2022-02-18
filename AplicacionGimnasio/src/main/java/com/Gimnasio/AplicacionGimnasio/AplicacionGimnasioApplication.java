package com.Gimnasio.AplicacionGimnasio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//Esto permite que el swagger funcione ya que antes daba error y no lo encontraba,
//Y eso que se creo la clase config
@EnableSwagger2
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
//Esto al no estar el main en un package no funcionaba el programa
// Asi que añadi este linea que detecta el package y al estar el SpringBootApplication arriba
//Detecta cada package con su correcta funcion.
@ComponentScan({"com.Gimnasio.AplicacionGimnasio"})
public class AplicacionGimnasioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionGimnasioApplication.class, args);
	}

}
