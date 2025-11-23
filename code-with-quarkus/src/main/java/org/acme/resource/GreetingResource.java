package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.DTO.*;
import org.acme.model.DTO.JOINS.DTO_EVENTOxPESSOA_RETORNO;
import org.acme.service.*;

import java.sql.SQLException;
import java.util.List;

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
    @Inject
    EventoService eventoService;


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


    @GET
    @Path("/eventos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodos() {
        try {
            List<DTO_T_LVUP_EVENTO> eventos = eventoService.listarTodosEventos();
            return Response.ok(eventos).build();
        } catch (SQLException e) {
            System.err.println("[RESOURCE] Erro ao listar eventos: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Não foi possível listar os eventos.")
                    .build();
        }
    }


    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public  Response deletarConta(){

        return Response.ok().build();
    }

    @GET
    @Path("/pessoa/{idPessoa}")
    @Produces (MediaType.APPLICATION_JSON)
    public Response listarEventosPessoa(@PathParam("idPessoa") long idPessoa) {
        System.out.println("Chamou listarEventosPessoa com idPessoa = " + idPessoa); // DEBUG
        try {
            List<DTO_EVENTOxPESSOA_RETORNO> eventos = pessoaService.listarEventosPorPessoa(idPessoa);
            System.out.println("Quantidade de eventos encontrados: " + eventos.size()); // DEBUG
            return Response.ok(eventos).build();
        } catch (SQLException e) {
            e.printStackTrace(); // Mostra o erro completo no console
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar eventos da pessoa")
                    .build();
        }
    }

    @GET
    @Path("/pessoa/dadospessoais/{idPessoa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarDadosPessoais(@PathParam("idPessoa") Long idPessoa) {
        try {
            return Response.ok(
                    pessoaService.buscarDadosPessoais(idPessoa)
            ).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar dados pessoais da pessoa.")
                    .build();
        }
    }

    @GET
    @Path("/empresa/dadosEmpresariais/{idEmpresa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarDadosEmpresariais(@PathParam("idEmpresa") Long idEmpresa) {
        try {
            // Chama o service que retorna DTO_T_EMPRESA_2
            DTO_T_EMPRESA_2 dadosEmpresa = empresaService.buscarDadosEmpresariais(idEmpresa);
            return Response.ok(dadosEmpresa).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar dados empresariais da empresa.")
                    .build();
        }
    }


    @GET
    @Path("/minhaconta/dadosendereco/{idEndereco}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarEndereco(@PathParam("idEndereco") Long idEndereco) {
        try {
            DTO_T_ENDERECO endereco = enderecoService.buscarEnderecoPorId(idEndereco);
            return Response.ok(endereco).build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar endereço: " + e.getMessage())
                    .build();
        }
    }


    @GET
    @Path("/minhas-demandas/{idEmpresa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMinhasDemandas(@PathParam("idEmpresa") Long idEmpresa) {
        try {
            // Chama o service para buscar as vagas/demandas da empresa
            List<DTO_T_VAGA_EMPRESA> vagas = vagaEmpresaService.listarVagasPorEmpresa(idEmpresa);
            return Response.ok(vagas).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar vagas/demandas da empresa.")
                    .build();
        }
    }


    @GET
    @Path("/minhaconta/dadosinstituicao/{idInstituicao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMinhaConta(@PathParam("idInstituicao") long idInstituicao) {
        try {
            DTO_T_INST_ACADEMICA_2 dados = instAcademicaService.getInstituicaoById(idInstituicao);
            return Response.ok(dados).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao consultar a instituição: " + e.getMessage()).build();
        }
    }

}
