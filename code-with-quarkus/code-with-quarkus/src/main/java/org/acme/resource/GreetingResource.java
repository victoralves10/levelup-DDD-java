package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.service.PessoaService;

import java.sql.SQLException;

@Path("/loginPessoa")
public class GreetingResource {

    @Inject
    PessoaService pessoaService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        try{
            return Response.ok(pessoaService.listarGeral()).build();
        }catch (SQLException e){
            return Response.serverError().build();
        }


    }
}
