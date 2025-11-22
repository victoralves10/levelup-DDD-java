package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.DTO.CADASTRO.EmpresaCadastro;
import org.acme.model.DTO.CADASTRO.InstituicaoCadastro;
import org.acme.model.DTO.CADASTRO.PessoaCadastro;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.service.EmpresaService;
import org.acme.service.InstAcademicaService;
import org.acme.service.LoginService;
import org.acme.service.PessoaService;

import java.sql.SQLException;

@Path("/auth")
public class LoginCadastroResource {

    @Inject
    LoginService loginService;
    @Inject
    PessoaService pessoaService;
    @Inject
    EmpresaService empresaService;
    @Inject
    InstAcademicaService instituicaoService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fazerLogin(DTO_T_LOGIN_2 loginDigitado){
        try {
            System.out.println("[RESOURCE] Recebido login: " + loginDigitado.getLogin());
            return Response.ok(loginService.loginExistente(loginDigitado)).build();
        } catch (SQLException e) {
            System.err.println("[RESOURCE] Erro SQL: " + e.getMessage());
            return Response.serverError().entity(e.getMessage()).build();
        } catch (IllegalArgumentException il){
            System.err.println("[RESOURCE] Login inválido: " + il.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).entity(il.getMessage()).build();
        }
    }

    @POST
    @Path("/cadastro/pessoa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarPessoa(PessoaCadastro novaPessoa){
        try {
            System.out.println("[RESOURCE] Recebido cadastro para: " + novaPessoa.getNome());
            boolean sucesso = pessoaService.criarContaPessoa(novaPessoa);
            System.out.println("[RESOURCE] Cadastro concluído: " + sucesso);
            return Response.ok(sucesso).build();
        } catch (SQLException e) {
            System.err.println("[RESOURCE] Erro ao cadastrar pessoa: " + e.getMessage()+","+e.getSQLState());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível cadastrar").build();
        }catch (IllegalArgumentException il){
            System.err.println("[RESOURCE] Erro de validação: " + il.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(il.getMessage()).build();
        }
    }


    @POST
    @Path("/cadastro/empresa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarEmpresa(EmpresaCadastro novaEmpresa){
        try {
            System.out.println("[RESOURCE] Recebido cadastro de empresa: " + novaEmpresa.getNome_empresa());
            boolean sucesso = empresaService.criarContaEmpresa(novaEmpresa);

            System.out.println("[RESOURCE] Cadastro de empresa concluído: " + sucesso);
            return Response.ok(sucesso).build();

        } catch (SQLException e) {
            System.err.println("[RESOURCE] Erro ao cadastrar empresa: "
                    + e.getMessage() + " | SQLState=" + e.getSQLState());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Não foi possível cadastrar").build();

        } catch (IllegalArgumentException il) {
            System.err.println("[RESOURCE] Erro de validação (empresa): " + il.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(il.getMessage()).build();
        }
    }

    @POST
    @Path("/cadastro/instituicao")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarInstituicao(InstituicaoCadastro novaInst) {
        try {
            System.out.println("[RESOURCE] Recebido cadastro de Instituição: "
                    + novaInst.getNm_instAcademica());

            boolean sucesso = instituicaoService.criarContaInstituicao(novaInst);

            System.out.println("[RESOURCE] Cadastro de instituição concluído: " + sucesso);
            return Response.ok(sucesso).build();

        } catch (SQLException e) {
            System.err.println("[RESOURCE] ERRO SQL ao cadastrar instituição: "
                    + e.getMessage() + " | SQLState=" + e.getSQLState());
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao cadastrar instituição acadêmica.")
                    .build();

        } catch (IllegalArgumentException il) {
            System.err.println("[RESOURCE] Erro de validação (instituição): " + il.getMessage());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(il.getMessage())
                    .build();
        }
    }


}
