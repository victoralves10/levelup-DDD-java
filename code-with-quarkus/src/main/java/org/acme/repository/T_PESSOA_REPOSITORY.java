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

        // SELECT
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
                lista.add(new T_PESSOA(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4).toLocalDate()
                ));
            }
            return lista;
        }
    }

        // LOGIN
    public DTO_JOIN_PESSOA_LOGIN autenticaPessoaLogin(DTO_T_LOGIN_2 loginDigitado) throws SQLException {
        DTO_JOIN_PESSOA_LOGIN PessoaLogin = null;

        String sql = """
            SELECT p.id_pessoa, p.nm_pessoa, p.cpf_pessoa, p.dt_nascimento, l.id_login, l.login, l.senha, l.st_ativo 
            FROM T_PESSOA p 
            INNER JOIN T_LVUP_LOGIN l ON p.id_login = l.id_login
            WHERE l.login=? AND l.senha=?""";

        try(Connection con = dataSource.getConnection();
            PreparedStatement pst = con.prepareStatement(sql)){

            // 1. Definição dos parâmetros da Query
            pst.setString(1, loginDigitado.getLogin());
            pst.setString(2, loginDigitado.getSenha()); // AVISO: Em produção, NUNCA use senha em texto simples aqui!

            try(ResultSet rs = pst.executeQuery()){

                // 2. Uso de 'if' em vez de 'while', pois esperamos no máximo 1 resultado
                if(rs.next()){
                    // 3. População do DTO usando NOMES de coluna (melhor prática)
                    PessoaLogin = new DTO_JOIN_PESSOA_LOGIN(
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
                // 4. Fechamento do ResultSet (garantido pelo try-with-resources se fosse rs)
            }
            return PessoaLogin;
        } // con e pst são fechados automaticamente aqui
    }

        //INSERÇÃO
    public boolean inserirPessoa(DTO_T_PESSOA np) throws SQLException {
        int linhasAfetadas = 0;

        String sql = """
        INSERT INTO T_PESSOA
        (nm_pessoa, cpf_pessoa, dt_nascimento, id_endereco, id_login)
        VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, np.getNm_pessoa());
            pst.setString(2, np.getCpf_pessoa());
            pst.setDate(3, java.sql.Date.valueOf(np.getDt_nascimento()));
            pst.setLong(4, np.getEndereco().getId_endereco());
            pst.setLong(5, np.getLogin().getId_login());

            linhasAfetadas = pst.executeUpdate();
        }

        return linhasAfetadas > 0;
    }


        //REMOÇÃO
    public boolean removerPessoa(Long id) throws SQLException {
        int linhasAfetadas = 0;

        String sql = """
            DELETE FROM T_PESSOA
            WHERE id_pessoa = ?
            """;

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setLong(1, id);

            linhasAfetadas = pst.executeUpdate();
        }

        return linhasAfetadas > 0;
    }

}
