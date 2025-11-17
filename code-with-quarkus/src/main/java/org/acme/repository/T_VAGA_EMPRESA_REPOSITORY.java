package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_VAGA_EMPRESA;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class T_VAGA_EMPRESA_REPOSITORY {

@Inject
    DataSource dataSource;

    public List<T_VAGA_EMPRESA> listarVagasDasEmpresas() throws SQLException {

        String sql = "SELECT * FROM T_VAGA_EMPRESA";
        List<T_VAGA_EMPRESA> listaVagas= new ArrayList<>();
        try(Connection con = dataSource.getConnection();
            PreparedStatement pst= con.prepareStatement(sql);){

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                listaVagas.add(new T_VAGA_EMPRESA(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            return listaVagas;
        }
    }



}
