package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_EMPRESA;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class T_EMPRESA_REPOSITORY {

    @Inject
    DataSource datasource;

    public List<T_EMPRESA> listarEmpresas() throws SQLException {
        String sql = "SELECT * FROM T_TABELA";
        List<T_EMPRESA> listaEmpresas = new ArrayList<>();

        try (Connection conn = datasource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)){
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                listaEmpresas.add(new T_EMPRESA(rs.getLong(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getDate(5),rs.getString(6)));
            }

        }
        return listaEmpresas;
    }

}
