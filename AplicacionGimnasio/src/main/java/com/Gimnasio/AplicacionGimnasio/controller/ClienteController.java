package com.Gimnasio.AplicacionGimnasio.controller;

import com.Gimnasio.AplicacionGimnasio.domain.Cliente;
import com.Gimnasio.AplicacionGimnasio.excepcion.clienteNotFoundExcepcion;
import com.Gimnasio.AplicacionGimnasio.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //ANYADIR CLIENTE
    @Operation(summary = "Registra un nuevo Cliente")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Se ha registrado el cliente", content = @Content(schema = @Schema(implementation =
            Cliente.class)))
    })

    @PostMapping(value = "/cliente",produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<Cliente> anyadirCliente(@RequestBody Cliente cliente){
        Cliente clienteAnyadido = clienteService.anyadirClienteBD(cliente);
        return new ResponseEntity<>(clienteAnyadido, HttpStatus.OK);
    }

    //BUSCAR TODOS LOS CLIENTES
    @Operation(summary = "Obtiene el listado de Clientes")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Listado de Clientes",content = @Content(array = @ArraySchema(schema =
    @Schema(implementation = Cliente.class)))),})

    @GetMapping(value ="/cliente",produces = "application/json")
    public ResponseEntity<Set<Cliente>> getCliente() {
        Set<Cliente> cliente = null;
        cliente = clienteService.findAll();
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    // BUSCAR CLIENTE POR ID
    @Operation(summary = "Obtiene un cliente determinado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el cliente", content = @Content(schema = @Schema(implementation =
                    Cliente.class))),
            @ApiResponse(responseCode = "404", description = "El Cliente no existe", content = @Content(schema = @Schema(implementation =
                    Cliente.class)))
    } )
    @GetMapping(value = "/cliente/{id}",produces = "application/json")
    public ResponseEntity<Cliente> getClienteId(@PathVariable long id) {
        Cliente cliente = clienteService.findById(id)
                .orElseThrow(() -> new clienteNotFoundExcepcion(id));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    //Encontrar cliente por DNI
    @Operation(summary = "Obtiene un cliente determinado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Existe el cliente", content = @Content(schema = @Schema(implementation =
                    Cliente.class))),
            @ApiResponse(responseCode = "404", description = "El Cliente no existe", content = @Content(schema = @Schema(implementation =
                    Cliente.class)))
    } )
    @GetMapping(value = "/cliente-{dni}",produces = "application/json")
    public ResponseEntity<Cliente> getClienteDNI(@PathVariable String dni) {
        Cliente cliente = clienteService.findByDni(dni);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    //MODIFICAR CLIENTE PUT
    @Operation(summary = "Modifica un Cliente en el catálogo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se modifica el cliente", content = @Content(schema = @Schema(implementation =
                    Cliente.class))),
            @ApiResponse(responseCode = "404", description = "El Cliente no existe", content = @Content(schema = @Schema(implementation =
                    Cliente.class)))})

    @PutMapping(value = "/cliente/{dni}",produces = "application/json",
            consumes = "application/json" )

    public ResponseEntity<Cliente> modifyClient(@PathVariable String dni,@RequestBody Cliente clienteModificado){
        Cliente cliente = clienteService.modificarCliente(dni,clienteModificado);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }


    //ELIMINAR CLIENTE

    @Operation(summary = "Elimina un Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Se elimina el Cliente",content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404",description = "El Cliente no existe",content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @DeleteMapping(value = "/cliente-{id}",produces = "application/json")
    public void deleteClient(@PathVariable long id){clienteService.deleteCliente(id);}

    //ELIMINAR CLIENTE POR DNI

    @Operation(summary = "Elimina un Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Se elimina el Cliente",content = @Content(schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "404",description = "El Cliente no existe",content = @Content(schema = @Schema(implementation = Response.class)))
    })
    @DeleteMapping(value = "/cliente-{dni}",produces = "application/json")
    public void deleteClientDNI(@PathVariable String dni){clienteService.deleteByDni(dni);}
}
