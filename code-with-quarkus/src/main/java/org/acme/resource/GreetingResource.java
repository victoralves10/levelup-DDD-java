package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.service.*;

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
    @Inject
    InstAcademicaService instAcademicaService;
    @Inject
    VagaEmpresaService vagaEmpresaService;

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
    public Response listarEmpresas(){
        try {
            return Response.ok(empresaService.listarEmpresas()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/instAcademicas")
    public Response listarInstAcademicas(){
        try {
            return Response.ok(instAcademicaService.listarInstAcademicas()).build();
        } catch (SQLException e) {
            return Response.serverError().build();

        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/vagasDasEmpresas")
    public Response listarVagasDasEmpresas(){
        try {
            return Response.ok(vagaEmpresaService.listarVagasDasEmpresas()).build();
        } catch (SQLException e) {
            return Response.serverError().build();

        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public  Response fazerLogin(){

        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public  Response criarConta(){

        return Response.ok().build();
    }


}
