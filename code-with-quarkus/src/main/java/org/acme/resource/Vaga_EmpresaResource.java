package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.DTO.DTO_T_VAGA_EMPRESA;
import org.acme.model.DTO.DTO_T_VAGA_EMPRESA_2;
import org.acme.service.VagaEmpresaService;

import java.sql.SQLException;

@Path("/listagem/vagas")
public class Vaga_EmpresaResource {

    @Inject
    VagaEmpresaService vagaEmpresaService;

    @POST
    @Path("/nova-demanda/{idEmpresa}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarNovaDemanda(@PathParam("idEmpresa") Long idEmpresa, DTO_T_VAGA_EMPRESA_2 novaVaga) {
        try {
            // Chama o service para criar a demanda
            boolean sucesso = vagaEmpresaService.criarNovaVaga(idEmpresa, novaVaga);
            if (sucesso) {
                return Response.status(Response.Status.CREATED)
                        .entity("Demanda cadastrada com sucesso!")
                        .build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("Erro ao cadastrar a demanda.")
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao criar nova demanda: " + e.getMessage())
                    .build();
        }
    }

}
