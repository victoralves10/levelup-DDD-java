package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.service.EmpresaService;
import org.acme.service.EnderecoService;
import org.acme.service.LoginService;
import org.acme.service.PessoaService;

import java.sql.SQLException;

@Path("/listagem")
public class GreetingResource {

    @Inject
    PessoaService pessoaService;
    @Inject
    EnderecoService enderecoService;
    @Inject
    LoginService loginService;
    @Inject
    EmpresaService empresaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pessoas")
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/logins")
    public Response listarLogins() {
        try {
            return Response.ok(loginService.listarLogins()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/empresas")
    public Response listaEmpresas(){
        try {
            return Response.ok(empresaService.listarEmpresas()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
