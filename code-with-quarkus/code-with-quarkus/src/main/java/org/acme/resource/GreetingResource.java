package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.service.EnderecoService;
import org.acme.service.PessoaService;

import java.sql.SQLException;

@Path("/listagem")
public class GreetingResource {

    @Inject
    PessoaService pessoaService;
    @Inject
    EnderecoService enderecoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPessoas() {
        try{
            return Response.ok(pessoaService.listarGeral()).build();
        }catch (SQLException e){
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/enderecos")
    public Response listarEnderecos(){
        try {
            return Response.ok(enderecoService.listarEnderecos()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
