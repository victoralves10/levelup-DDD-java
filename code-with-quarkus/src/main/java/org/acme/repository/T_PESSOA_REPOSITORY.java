package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.model.DTO.DTO_T_PESSOA;
import org.acme.model.DTO.JOINS.DTO_JOIN_PESSOA_LOGIN;
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

    // LISTAR TODOS
    public List<T_PESSOA> listarGeral() throws SQLException {
        String sql = """
            SELECT id_pessoa, nm_pessoa, cpf_pessoa, dt_nascimento, id_endereco, id_login
            FROM T_PESSOA
        """;

        List<T_PESSOA> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new T_PESSOA(
                        rs.getInt("id_pessoa"),
                        rs.getString("nm_pessoa"),
                        rs.getString("cpf_pessoa"),
                        rs.getDate("dt_nascimento").toLocalDate(),
                        rs.getLong("id_endereco"),
                        rs.getLong("id_login")
                ));
            }
        }

        return lista;
    }

    // AUTENTICAÇÃO
    public DTO_JOIN_PESSOA_LOGIN autenticaPessoaLogin(DTO_T_LOGIN_2 loginDigitado) throws SQLException {
        DTO_JOIN_PESSOA_LOGIN pessoaLogin = null;

        String sql = """
            SELECT p.id_pessoa, p.nm_pessoa, p.cpf_pessoa, p.dt_nascimento,
                   l.id_login, l.login, l.senha, l.st_ativo
            FROM T_PESSOA p
            INNER JOIN T_LVUP_LOGIN l ON p.id_login = l.id_login
            WHERE l.login = ? AND l.senha = ?
        """;

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, loginDigitado.getLogin());
            pst.setString(2, loginDigitado.getSenha());

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    pessoaLogin = new DTO_JOIN_PESSOA_LOGIN(
                            rs.getLong("id_pessoa"),
                            rs.getString("nm_pessoa"),
                            rs.getString("cpf_pessoa"),
                            rs.getDate("dt_nascimento").toLocalDate(),
                            rs.getLong("id_login"),
                            rs.getString("login"),
                            rs.getString("senha"),
                            rs.getString("st_ativo")
                    );
                }
            }
        }

        return pessoaLogin;
    }

    // INSERÇÃO
    public boolean inserirPessoa(DTO_T_PESSOA np) throws SQLException {
        String sql = """
            INSERT INTO T_PESSOA (nm_pessoa, cpf_pessoa, dt_nascimento, id_endereco, id_login)
            VALUES (?, ?, ?, ?, ?)
        """;

        int linhasAfetadas;

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, np.getNm_pessoa());
            pst.setString(2, np.getCpf_pessoa());
            pst.setDate(3, java.sql.Date.valueOf(np.getDt_nascimento()));
            pst.setLong(4, np.getId_endereco());
            pst.setLong(5, np.getId_login());

            linhasAfetadas = pst.executeUpdate();
        }

        return linhasAfetadas > 0;
    }

    // REMOÇÃO
    public boolean removerPessoa(Long id) throws SQLException {
        String sql = "DELETE FROM T_PESSOA WHERE id_pessoa = ?";

        int linhasAfetadas;

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setLong(1, id);
            linhasAfetadas = pst.executeUpdate();
        }

        return linhasAfetadas > 0;
    }

    // VALIDAÇÃO SE CPF É EXISTENTE
    public boolean existeCpf(String cpf) throws SQLException {
        String sql = "SELECT 1 FROM T_PESSOA WHERE cpf_pessoa = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            return rs.next(); // Se encontrar algum registro, CPF já existe
        }
    }
}