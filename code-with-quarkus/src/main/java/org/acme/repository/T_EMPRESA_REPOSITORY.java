package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_EMPRESA;
import org.acme.model.DTO.DTO_T_EMPRESA_2;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.model.DTO.JOINS.DTO_JOIN_EMPRESA_LOGIN;
import org.acme.model.T_EMPRESA;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public boolean inserirEmpresa(DTO_T_EMPRESA empresa) throws SQLException {
        String sql = """
            INSERT INTO T_EMPRESA 
            (nm_empresa, cnpj_empresa, email_empresa, dt_cadastro, st_empresa, id_endereco, id_login)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        // Define data e status padrão se não vierem do DTO
        LocalDate dtCadastro = empresa.getDt_cadastro() != null ? empresa.getDt_cadastro() : LocalDate.now();
        char status = empresa.getSt_empresa() != 0 ? empresa.getSt_empresa() : 'A';

        try (Connection con = datasource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, empresa.getNm_empresa());
            pst.setString(2, empresa.getCnpj_empresa());
            pst.setString(3, empresa.getEmail_empresa());
            pst.setDate(4, java.sql.Date.valueOf(dtCadastro));
            pst.setString(5, String.valueOf(status));
            pst.setLong(6, empresa.getEndereco());
            pst.setLong(7, empresa.getLogin());

            int linhasAfetadas = pst.executeUpdate();
            return linhasAfetadas > 0;
        }
    }

    public boolean cnpjExiste(String cnpj) throws SQLException {
        String sql = "SELECT 1 FROM T_INST_ACADEMICA WHERE cnpj_inst_academica = ?";

        try (Connection conn = datasource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, cnpj);

            ResultSet rs = pst.executeQuery();

            return rs.next(); // Se encontrou registro, o CNPJ já existe
        }
    }


    public DTO_T_EMPRESA_2 buscarDadosEmpresariais(Long idEmpresa) throws SQLException {
        DTO_T_EMPRESA_2 empresa = null;

        String sql = """
            SELECT nm_empresa, cnpj_empresa, email_empresa, dt_cadastro, id_endereco
            FROM T_EMPRESA
            WHERE id_empresa = ?
        """;

        try (Connection conn = datasource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setLong(1, idEmpresa);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    empresa = new DTO_T_EMPRESA_2();
                    empresa.setNm_empresa(rs.getString("nm_empresa"));
                    empresa.setCnpj_empresa(rs.getString("cnpj_empresa"));
                    empresa.setEmail_empresa(rs.getString("email_empresa"));
                    empresa.setDt_cadastro(rs.getDate("dt_cadastro").toLocalDate());
                    empresa.setId_endereco(rs.getLong("id_endereco"));
                }
            }
        }

        return empresa;
    }

}
