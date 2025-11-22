package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_INST_ACADEMICA;
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
        String sql = "SELECT id_instAcademica, nm_instAcademica, st_ativo, cnpj_inst_academica FROM T_INST_ACADEMICA";
        List<T_INST_ACADEMICA> listaInstAcademica = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaInstAcademica.add(
                        new T_INST_ACADEMICA(
                                rs.getLong("id_instAcademica"),
                                rs.getString("nm_instAcademica"),
                                rs.getString("st_ativo"),
                                rs.getString("cnpj_inst_academica")
                        )
                );
            }
            return listaInstAcademica;
        }
    }


    public DTO_JOIN_INSTITUICAO_LOGIN autenticaInstituicaoLogin(DTO_T_LOGIN_2 loginDigitado) throws SQLException {
        DTO_JOIN_INSTITUICAO_LOGIN InstituicaoLogin = null;

        String sql = """
            SELECT i.id_instAcademica, i.nm_instAcademica, i.cnpj_inst_academica, l.id_login, l.login, l.senha, l.st_ativo 
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
                            rs.getLong("id_instAcademica"),
                            rs.getString("nm_instAcademica"),
                            rs.getString("cnpj_inst_academica"),
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

    public boolean inserirInstituicao(DTO_T_INST_ACADEMICA inst) throws SQLException{
        String sql = """
            INSERT INTO T_INST_ACADEMICA 
            (nm_instAcademica,st_ativo, cnpj_inst_academica, id_endereco, id_login)
            VALUES (?,?,?,?, ?)
        """;

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, inst.getNm_instAcademica());
            pst.setString(2, "S");
            pst.setString(3, inst.getCnpj());
            pst.setLong(4, inst.getEndereco());
            pst.setLong(5, inst.getLogin());

            int linhas = pst.executeUpdate();
            return linhas > 0;
        }
    }


    public boolean cnpjExiste(String cnpj) throws SQLException {
        String sql = "SELECT 1 FROM T_INST_ACADEMICA WHERE cnpj_inst_academica = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, cnpj);

            ResultSet rs = pst.executeQuery();

            return rs.next(); // Se encontrou registro, o CNPJ já existe
        }
    }
}
