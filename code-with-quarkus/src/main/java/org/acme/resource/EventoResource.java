package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.DTO.EVENTO.EVENTO_PESSOA;
import org.acme.service.EventoService;

import java.sql.SQLException;

@Path("/evento")
public class EventoResource {

    @Inject
    EventoService eventoService;

    @POST
    @Path("/inscricao")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inscreverPessoa(EVENTO_PESSOA inscr) {
        try {
            eventoService.inscreverPessoa(inscr.getIdPessoa(), inscr.getIdEvento());
            return Response.ok().entity("Inscrição realizada com sucesso").build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao se inscrever no evento")
                    .build();
        }
    }



    @DELETE
    @Path("/remocao")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removerInscricao(@QueryParam("id_pessoa") int idPessoa,
                                     @QueryParam("id_evento") int idEvento) {
        try {
            eventoService.removerInscricao(idPessoa, idEvento);
            return Response.ok("Inscrição removida com sucesso").build();
        } catch (IllegalStateException e) {
            // usuário não inscrito
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao remover inscrição")
                    .build();
        }
    }

}
