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
             PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, novoEndereco.getCep());
            pst.setString(2, novoEndereco.getPais());
            pst.setString(3, novoEndereco.getEstado());
            pst.setString(4, novoEndereco.getCidade());
            pst.setString(5, novoEndereco.getBairro());
            pst.setString(6, novoEndereco.getRua());
            pst.setInt(7, novoEndereco.getNumero());     // setInt porque numero é INTEGER
            pst.setString(8, novoEndereco.getComplemento());

            pst.executeUpdate();

            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    idGerado = rs.getLong(1);
                } else {
                    throw new SQLException("Nenhum ID foi retornado ao inserir ENDEREÇO.");
                }
            }
        }

        return idGerado;
    }


}
