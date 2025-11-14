package org.acme.repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_PESSOA;
import org.acme.model.T_ENDERECO;
import org.acme.model.T_LOGIN;
import org.acme.model.T_PESSOA;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class T_PESSOA_REPOSITORY {


    @Inject
    DataSource dataSource;

    public List<T_PESSOA> listarGeral() throws SQLException {
        String sql = """
            SELECT
                p.id_pessoa, p.nm_pessoa, p.cpf_pessoa, p.dt_nascimento
            FROM
                T_PESSOA p
            """;
        List<T_PESSOA> lista = new ArrayList<>();
        try(Connection con = dataSource.getConnection();
            PreparedStatement pst = con.prepareStatement(sql)){

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                lista.add(new T_PESSOA(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getDate(4)));
            }
            return lista;
        }

    }
/*
    public void inserir(DTO_T_PESSOA pessoa) {

    }*/
}
