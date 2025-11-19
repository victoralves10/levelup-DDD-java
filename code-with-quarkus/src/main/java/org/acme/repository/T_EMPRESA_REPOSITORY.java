package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.model.DTO.JOINS.DTO_JOIN_EMPRESA_LOGIN;
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
        String sql = "SELECT * FROM T_EMPRESA";
        List<T_EMPRESA> listaEmpresas = new ArrayList<>();

        try (Connection conn = datasource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)){
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                listaEmpresas.add(new T_EMPRESA(rs.getLong(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getDate(5),rs.getString(6)));
            }
            return listaEmpresas;
        }

    }

    public DTO_JOIN_EMPRESA_LOGIN autenticaEmpresaLogin(DTO_T_LOGIN_2 loginDigitado) throws SQLException {
        DTO_JOIN_EMPRESA_LOGIN EmpresaLogin = null;

        String sql = """
            SELECT e.id_empresa, e.nm_empresa, e.cnpj_empresa, l.id_login, l.login, l.senha, l.st_ativo 
            FROM T_EMPRESA e INNER JOIN T_LVUP_LOGIN l 
            ON e.id_login = l.id_login
            WHERE l.login=? AND l.senha=?""";

        try(Connection con = datasource.getConnection();
            PreparedStatement pst = con.prepareStatement(sql)){

            pst.setString(1, loginDigitado.getLogin());
            pst.setString(2, loginDigitado.getSenha());

            try(ResultSet rs = pst.executeQuery()){

                if(rs.next()){
                    // População do DTO
                    EmpresaLogin = new DTO_JOIN_EMPRESA_LOGIN(
                            rs.getLong("id_empresa"),
                            rs.getString("nm_empresa"),
                            rs.getString("cnpj_empresa"),
                            rs.getLong("id_login"),
                            rs.getString("login"),
                            rs.getString("senha"),
                            rs.getString("st_ativo")
                    );
                }
            }
            return EmpresaLogin;
        }
    }

}
