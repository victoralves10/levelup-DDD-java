package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_VAGA_EMPRESA;
import org.acme.model.DTO.DTO_T_VAGA_EMPRESA_2;
import org.acme.model.T_VAGA_EMPRESA;
import org.acme.repository.T_VAGA_EMPRESA_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class VagaEmpresaService {

    @Inject
    T_VAGA_EMPRESA_REPOSITORY vagaEmpresaRepository;

    public List<T_VAGA_EMPRESA> listarVagasDasEmpresas() throws SQLException {

        return vagaEmpresaRepository.listarVagasDasEmpresas();
    }

    public List<DTO_T_VAGA_EMPRESA> listarVagasPorEmpresa(long idEmpresa) throws SQLException {

        return vagaEmpresaRepository.listarVagasPorEmpresa(idEmpresa);
    }

    public boolean criarNovaVaga(long idEmpresa, DTO_T_VAGA_EMPRESA_2 novaVaga) throws SQLException {
        // Cria DTO completo para o insert
        DTO_T_VAGA_EMPRESA vaga_formatada = new DTO_T_VAGA_EMPRESA(
                novaVaga.getVaga_tema(),
                novaVaga.getDes_vaga(),
                "A" // Status sempre Aberta
        );

        long idVaga = vagaEmpresaRepository.inserirVaga(vaga_formatada);
        if (idVaga > 0) {
            vagaEmpresaRepository.vincularVagaEmpresa(idEmpresa, idVaga);
            return true;
        }
        return false;
    }


}
