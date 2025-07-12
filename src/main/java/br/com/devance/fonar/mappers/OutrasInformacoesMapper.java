package br.com.devance.fonar.mappers;

import br.com.devance.fonar.dto.DTOOutrasInformacoesFonar;
import br.com.devance.fonar.models.OutrasInformacoesFONAR;

public class OutrasInformacoesMapper {

    public static OutrasInformacoesFONAR toEntity(DTOOutrasInformacoesFonar dto) {
        if (dto == null) {
            return null;
        }

        return OutrasInformacoesFONAR.builder()
                .moraEmLocalDeRisco(dto.getMoraEmLocalDeRisco())
                .dependenciaFinanceiraAgressor(dto.getDependenciaFinanceiraAgressor())
                .querAbrigoTemporario(dto.getQuerAbrigoTemporario())
                .build();
    }

    public static DTOOutrasInformacoesFonar toDTO(OutrasInformacoesFONAR entity) {
        if (entity == null) {
            return null;
        }

        DTOOutrasInformacoesFonar dto = new DTOOutrasInformacoesFonar();
        dto.setMoraEmLocalDeRisco(entity.getMoraEmLocalDeRisco());
        dto.setDependenciaFinanceiraAgressor(entity.isDependenciaFinanceiraAgressor());
        dto.setQuerAbrigoTemporario(entity.isQuerAbrigoTemporario());

        return dto;
    }
}
