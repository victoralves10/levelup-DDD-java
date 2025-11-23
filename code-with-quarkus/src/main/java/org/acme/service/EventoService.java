package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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

//    // INSERIR NOVO EVENTO
//    public boolean criarEvento(T_LVUP_EVENTO novoEvento) throws SQLException {
//        return eventoRepository.inserirEvento(novoEvento);
//    }
//
//    // REMOVER EVENTO
//    public boolean removerEvento(long idEvento) throws SQLException {
//        return eventoRepository.removerEvento(idEvento);
//    }
}
