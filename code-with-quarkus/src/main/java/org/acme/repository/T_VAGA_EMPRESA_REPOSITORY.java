package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_VAGA_EMPRESA;
import org.acme.model.T_VAGA_EMPRESA;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class T_VAGA_EMPRESA_REPOSITORY {

@Inject
    DataSource dataSource;

    public List<T_VAGA_EMPRESA> listarVagasDasEmpresas() throws SQLException {

        String sql = "SELECT * FROM T_VAGA_EMPRESA";
        List<T_VAGA_EMPRESA> listaVagas= new ArrayList<>();
        try(Connection con = dataSource.getConnection();
            PreparedStatement pst= con.prepareStatement(sql);){

            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                listaVagas.add(new T_VAGA_EMPRESA(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            return listaVagas;
        }
    }


    public List<DTO_T_VAGA_EMPRESA> listarVagasPorEmpresa(long idEmpresa) throws SQLException {
        String sql = """
            SELECT v.vaga_tema, v.des_vaga, v.st_vaga
            FROM T_VAGA_EMPRESA v
            INNER JOIN EMPRESA_VAGA ev ON v.id_vagaEmpresa = ev.id_vagaEmpresa
            WHERE ev.id_empresa = ?
        """;

        List<DTO_T_VAGA_EMPRESA> vagas = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setLong(1, idEmpresa);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    vagas.add(new DTO_T_VAGA_EMPRESA(
                            rs.getString("vaga_tema"),
                            rs.getString("des_vaga"),
                            rs.getString("st_vaga")
                    ));
                }
            }
        }

        return vagas;
    }

    public long inserirVaga(DTO_T_VAGA_EMPRESA vaga) throws SQLException {
        // SQL de insert
        String sql = "INSERT INTO T_VAGA_EMPRESA (vaga_tema, des_vaga, st_vaga) VALUES (?, ?, ?)";

        // Abre conexão e prepara statement pedindo explicitamente o ID gerado
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql, new String[]{"id_vagaEmpresa"})) {

            // Preenche os parâmetros
            pst.setString(1, vaga.getVaga_tema());
            pst.setString(2, vaga.getDes_vaga());
            pst.setString(3, "A"); // status sempre Aberta

            // Executa o insert
            pst.executeUpdate();

            // Recupera o ID gerado
            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1); // retorna o ID numérico corretamente
                } else {
                    throw new SQLException("Falha ao obter ID da vaga inserida.");
                }
            }
        }
    }




    public void vincularVagaEmpresa(long idEmpresa, Long idVaga) throws SQLException {
        String sql = "INSERT INTO EMPRESA_VAGA (id_empresa, id_vagaEmpresa) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setLong(1, idEmpresa);
            pst.setLong(2, idVaga);
            pst.executeUpdate();
        }
    }
}
