package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.model.DTO.JOINS.DTO_JOIN_EMPRESA_LOGIN;
import org.acme.model.T_ENDERECO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class T_ENDERECO_REPOSITORY {


    @Inject
    DataSource dataSource;

    public List<T_ENDERECO> listarEnderecos() throws SQLException {

        List<T_ENDERECO> listaEnderecos = new ArrayList<>();

        String sql = "SELECT * FROM T_ENDERECO";
        try(Connection conn = dataSource.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);){
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                listaEnderecos.add(new T_ENDERECO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9)));
            }
        }

        return listaEnderecos;
    }

    
}
