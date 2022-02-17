package com.Gimnasio.AplicacionGimnasio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan({"com.Gimnasio.AplicacionGimnasio"})
public class AplicacionGimnasioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionGimnasioApplication.class, args);
	}

}
