package org.acme.repository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_LOGIN;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.model.T_LVUP_LOGIN;

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

        //SELECT
    public List<T_LVUP_LOGIN> listarLogins() throws SQLException {
        List<T_LVUP_LOGIN> listaLogins = new ArrayList<>();
        String sql = "SELECT * FROM T_LVUP_LOGIN";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                listaLogins.add(new T_LVUP_LOGIN(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        }
        return listaLogins;
    }

        //LOGIN
    public List<DTO_T_LOGIN_2> procurarLogin(DTO_T_LOGIN_2 loginDigitado) throws SQLException {
        List<DTO_T_LOGIN_2> listaVerificada = new ArrayList<>();
        String sql = "SELECT login,senha FROM T_LVUP_LOGIN where login=? AND senha=?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setString(1,loginDigitado.getLogin());
            pst.setString(2,loginDigitado.getSenha());

            ResultSet res = pst.executeQuery();

            while(res.next()){
                String loginBD =res.getString(1);
                String senhaBD =res.getString(2);

                listaVerificada.add(new DTO_T_LOGIN_2(loginBD,senhaBD));
            }

            return listaVerificada;
        }

    }

    public Long inserirLoginRetornandoId(DTO_T_LOGIN novoLogin) throws SQLException {

        Long idGerado = null;

        String sql = """
            INSERT INTO T_LVUP_LOGIN
            (login, senha, st_ativo)
            VALUES (?, ?, 'S')
            """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, novoLogin.getLogin());
            pst.setString(2, novoLogin.getSenha());

            pst.executeUpdate();

            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    idGerado = rs.getLong(1);
                } else {
                    throw new SQLException("Nenhum ID foi retornado pelo banco ao inserir login.");
                }
            }
        }

        return idGerado;
    }

}
