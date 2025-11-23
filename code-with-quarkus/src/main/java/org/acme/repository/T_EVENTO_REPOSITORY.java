package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.DTO.DTO_JOIN_ENDERECO_EVENTO;
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

    @Transactional
    public void inscreverPessoaEmEvento(int idPessoa, int idEvento) throws SQLException {
        String sql = "INSERT INTO PESSOA_EVENTO (id_pessoa, id_evento) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPessoa);
            stmt.setInt(2, idEvento);
            stmt.executeUpdate();
        }
    }

    @Transactional
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

    public List<DTO_JOIN_ENDERECO_EVENTO> listarEventosComEndereco() throws SQLException {
        String sql = """
                SELECT e.id_evento, e.nm_evento, e.descricao_evento, e.qt_dias, e.dt_inicio_evento,
                       en.id_endereco, en.cep, en.pais, en.estado, en.cidade, en.bairro, en.rua, en.numero, en.complemento
                FROM T_LVUP_EVENTO e
                INNER JOIN T_ENDERECO en ON e.id_endereco = en.id_endereco
                """;

        List<DTO_JOIN_ENDERECO_EVENTO> listaEventos = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                DTO_JOIN_ENDERECO_EVENTO evento = new DTO_JOIN_ENDERECO_EVENTO(
                        rs.getLong("id_evento"),
                        rs.getString("nm_evento"),
                        rs.getString("descricao_evento"),
                        rs.getInt("qt_dias"),
                        rs.getDate("dt_inicio_evento"),
                        rs.getLong("id_endereco"),
                        rs.getString("cep"),
                        rs.getString("pais"),
                        rs.getString("estado"),
                        rs.getString("cidade"),
                        rs.getString("bairro"),
                        rs.getString("rua"),
                        rs.getInt("numero"),
                        rs.getString("complemento")
                );
                listaEventos.add(evento);
            }
        }

        return listaEventos;
    }


}
