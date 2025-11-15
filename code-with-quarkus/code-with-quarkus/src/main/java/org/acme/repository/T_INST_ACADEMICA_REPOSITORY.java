package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_INST_ACADEMICA;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class T_INST_ACADEMICA_REPOSITORY {
    @Inject
    DataSource dataSource;
    public List<T_INST_ACADEMICA> listarInstAcademicas() throws SQLException {
        String sql = "SELECT * FROM T_INST_ACADEMICA";
        List<T_INST_ACADEMICA> listaInstAcademica = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst= conn.prepareStatement(sql)){

            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                listaInstAcademica.add(new T_INST_ACADEMICA(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            return listaInstAcademica
        }


    }


}
