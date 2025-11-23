package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
        if (inscrito) throw new IllegalStateException("Já inscrito");

        eventoRepository.inscreverPessoaEmEvento(idPessoa, idEvento);
    }

    @Transactional
    public void removerInscricao(int idPessoa, int idEvento) throws SQLException {
        int deleted = eventoRepository.removerPessoaDoEvento(idPessoa, idEvento);
        if (deleted == 0) throw new IllegalStateException("Não inscrito nesse evento");
    }

    public boolean isInscrito(int idPessoa, int idEvento) throws SQLException {
        return eventoRepository.estaInscrito(idPessoa, idEvento);
    }
}
