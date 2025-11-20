package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.model.DTO.JOINS.DTO_JOIN_INSTITUICAO_LOGIN;
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
            return listaInstAcademica;
        }


    }

    public DTO_JOIN_INSTITUICAO_LOGIN autenticaInstituicaoLogin(DTO_T_LOGIN_2 loginDigitado) throws SQLException {
        DTO_JOIN_INSTITUICAO_LOGIN InstituicaoLogin = null;

        String sql = """
            SELECT i.id_instAcademica\s, i.nm_instAcademica, i.cnpj_inst_academica, l.id_login, l.login, l.senha, l.st_ativo 
            FROM T_INST_ACADEMICA i 
            INNER JOIN T_LVUP_LOGIN l ON i.id_login = l.id_login
            WHERE l.login=? AND l.senha=?""";

        try(Connection con = dataSource.getConnection();
            PreparedStatement pst = con.prepareStatement(sql)){

            pst.setString(1, loginDigitado.getLogin());
            pst.setString(2, loginDigitado.getSenha());

            try(ResultSet rs = pst.executeQuery()){

                if(rs.next()){
                    // População do DTO
                    InstituicaoLogin = new DTO_JOIN_INSTITUICAO_LOGIN(
                            rs.getLong("id_instituicao"),
                            rs.getString("nm_instituicao"),
                            rs.getString("cnpj_instituicao"),
                            rs.getLong("id_login"),
                            rs.getString("login"),
                            rs.getString("senha"),
                            rs.getString("st_ativo")
                    );
                }
            }
            return InstituicaoLogin;
        }
    }
}
