package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.DTO.DTO_JOIN_ENDERECO_EVENTO;
import org.acme.model.DTO.DTO_T_LVUP_EVENTO;
import org.acme.model.T_LVUP_EVENTO;
import org.acme.repository.T_EVENTO_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class EventoService {

    @Inject
    T_EVENTO_REPOSITORY eventoRepository;

    // LISTAR TODOS OS EVENTOS DISPONÍVEIS
    public List<DTO_T_LVUP_EVENTO> listarTodosEventos() throws SQLException {
        return eventoRepository.listarTodosEventos();
    }

    // BUSCAR EVENTO POR ID
    public T_LVUP_EVENTO buscarEventoPorId(long idEvento) throws SQLException {
        return eventoRepository.buscarPorId(idEvento);
    }

    @Transactional
    public void inscreverPessoa(int idPessoa, int idEvento) throws SQLException {
        boolean inscrito = eventoRepository.estaInscrito(idPessoa, idEvento);
        if (!inscrito) {
            eventoRepository.inscreverPessoaEmEvento(idPessoa, idEvento);
        }
        // Se já está inscrito, não faz nada
    }

    // REMOVER INSCRIÇÃO
    @Transactional
    public void removerInscricao(int idPessoa, int idEvento) throws SQLException {
        int deleted = eventoRepository.removerPessoaDoEvento(idPessoa, idEvento);
        if (deleted == 0) {
            throw new IllegalStateException("Não inscrito nesse evento");
        }
    }

    public boolean isInscrito(int idPessoa, int idEvento) throws SQLException {
        return eventoRepository.estaInscrito(idPessoa, idEvento);
    }

    public List<DTO_JOIN_ENDERECO_EVENTO> listarEventosComEndereco() throws SQLException {

        List<DTO_JOIN_ENDERECO_EVENTO> lista = eventoRepository.listarEventosComEndereco();

        // -------------------------
        // 🔎 Validação de regra de negócio
        // -------------------------
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("Nenhum evento encontrado.");
        }

        return lista;
    }
}
