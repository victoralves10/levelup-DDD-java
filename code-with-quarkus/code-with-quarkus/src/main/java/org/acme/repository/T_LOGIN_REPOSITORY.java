package org.acme.repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_LOGIN;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class T_LOGIN_REPOSITORY {

    @Inject
    DataSource dataSource;

    public List<T_LOGIN> listarLogins() throws SQLException {
        List<T_LOGIN> listaLogins = new ArrayList<>();
        String sql = "SELECT * FROM T_LVUP_LOGIN";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                listaLogins.add(new T_LOGIN(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        }
        return listaLogins;
    }
}
