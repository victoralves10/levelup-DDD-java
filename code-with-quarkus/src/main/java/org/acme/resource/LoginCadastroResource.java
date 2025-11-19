package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.service.LoginService;

import java.sql.SQLException;

@Path("/login")
public class LoginCadastroResource {

    @Inject
    LoginService loginService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public  Response fazerLogin(DTO_T_LOGIN_2 loginDigitado){

        try{
            return Response.ok(loginService.loginExistente(loginDigitado)).build();

        }catch (SQLException e){
            return Response.serverError().build();

        }catch (IllegalArgumentException il){
            return Response.status(Response.Status.UNAUTHORIZED).entity(il.getMessage()).build();
        }
    }


}
