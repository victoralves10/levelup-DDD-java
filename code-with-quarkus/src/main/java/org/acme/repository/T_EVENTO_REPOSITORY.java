package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_LVUP_EVENTO;
import org.acme.model.T_LVUP_EVENTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class T_EVENTO_REPOSITORY {
    @Inject
    DataSource dataSource;

    // LISTAR TODOS OS EVENTOS
    public List<DTO_T_LVUP_EVENTO> listarTodosEventos() throws SQLException {
        String sql = """
            SELECT id_evento, nm_evento, descricao_evento, qt_dias, dt_inicio_evento
            FROM T_LVUP_EVENTO
        """;

        List<DTO_T_LVUP_EVENTO> lista = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                lista.add(new DTO_T_LVUP_EVENTO(
                        rs.getLong("id_evento"),
                        rs.getString("nm_evento"),
                        rs.getString("descricao_evento"),
                        rs.getInt("qt_dias"),
                        rs.getDate("dt_inicio_evento").toLocalDate()
                ));
            }
        }

        return lista;
    }

    // BUSCAR EVENTO POR ID
    public T_LVUP_EVENTO buscarPorId(long idEvento) throws SQLException {
        String sql = """
            SELECT id_evento, nm_evento, descricao_evento, qt_dias, dt_inicio_evento,
                   id_instAcademica, id_endereco, id_vagaEmpresa
            FROM T_LVUP_EVENTO
            WHERE id_evento = ?
        """;

        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setLong(1, idEvento);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new T_LVUP_EVENTO(
                            rs.getLong("id_evento"),
                            rs.getString("nm_evento"),
                            rs.getString("descricao_evento"),
                            rs.getInt("qt_dias"),
                            rs.getDate("dt_inicio_evento").toLocalDate(),
                            rs.getLong("id_instAcademica"),
                            rs.getLong("id_endereco"),
                            rs.getLong("id_vagaEmpresa")
                    );
                }
            }
        }

        return null;
    }

    public void inscreverPessoaEmEvento(int idPessoa, int idEvento) throws SQLException {
        String sql = "INSERT INTO PESSOA_EVENTO (id_pessoa, id_evento) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.setInt(2, idEvento);
            stmt.executeUpdate();
        }
    }

    public int removerPessoaDoEvento(int idPessoa, int idEvento) throws SQLException {
        String sql = "DELETE FROM PESSOA_EVENTO WHERE id_pessoa = ? AND id_evento = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.setInt(2, idEvento);
            return stmt.executeUpdate(); // retorna linhas deletadas
        }
    }


    public boolean estaInscrito(int idPessoa, int idEvento) throws SQLException {
        String sql = "SELECT COUNT(*) FROM PESSOA_EVENTO WHERE id_pessoa = ? AND id_evento = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.setInt(2, idEvento);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }


}
