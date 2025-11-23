package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_ENDERECO;
import org.acme.model.T_ENDERECO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class T_ENDERECO_REPOSITORY {

    @Inject
    DataSource dataSource;

    // LISTAR
    public List<T_ENDERECO> listarEnderecos() throws SQLException {
        List<T_ENDERECO> listaEnderecos = new ArrayList<>();

        String sql = "SELECT id_endereco, cep, pais, estado, cidade, bairro, rua, numero, complemento FROM T_ENDERECO";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                listaEnderecos.add(new T_ENDERECO(
                        rs.getLong("id_endereco"),
                        rs.getString("cep"),
                        rs.getString("pais"),
                        rs.getString("estado"),
                        rs.getString("cidade"),
                        rs.getString("bairro"),
                        rs.getString("rua"),
                        rs.getInt("numero"),           // int conforme DDL
                        rs.getString("complemento")
                ));
            }
        }
        return listaEnderecos;
    }

    // INSERIR e RETORNAR ID
    public Long inserirEnderecoRetornandoId(DTO_T_ENDERECO novoEndereco) throws SQLException {
        Long idGerado = null;

        String sql = """
        INSERT INTO T_ENDERECO
        (cep, pais, estado, cidade, bairro, rua, numero, complemento)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = dataSource.getConnection();
             // Informando explicitamente a coluna de identidade para o Oracle
             PreparedStatement pst = conn.prepareStatement(sql, new String[]{"ID_ENDERECO"})) {

            pst.setString(1, novoEndereco.getCep());
            pst.setString(2, novoEndereco.getPais());
            pst.setString(3, novoEndereco.getEstado());
            pst.setString(4, novoEndereco.getCidade());
            pst.setString(5, novoEndereco.getBairro());
            pst.setString(6, novoEndereco.getRua());
            pst.setInt(7, novoEndereco.getNumero());
            pst.setString(8, novoEndereco.getComplemento());

            int linhasAfetadas = pst.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao inserir endereço, nenhuma linha afetada.");
            }
            System.out.println("Endereco inserido");

            // Captura o ID gerado
            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    idGerado = rs.getLong(1);
                    System.out.println("ID de endereco pego: " + idGerado);
                } else {
                    throw new SQLException("Nenhum ID foi retornado ao inserir ENDEREÇO.");
                }
            }
        }

        return idGerado;
    }


    public DTO_T_ENDERECO buscarEnderecoPorId(Long idEndereco) throws SQLException {

        String sql = """
        SELECT cep, pais, estado, cidade, bairro, rua, numero, complemento
        FROM T_ENDERECO
        WHERE id_endereco = ?
    """;

        DTO_T_ENDERECO endereco = null;

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setLong(1, idEndereco);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {

                    endereco = new DTO_T_ENDERECO(
                            rs.getString("cep"),
                            rs.getString("pais"),
                            rs.getString("estado"),
                            rs.getString("cidade"),
                            rs.getString("bairro"),
                            rs.getString("rua"),
                            rs.getInt("numero"),
                            rs.getString("complemento")
                    );
                }
            }
        }

        return endereco;
    }



}
