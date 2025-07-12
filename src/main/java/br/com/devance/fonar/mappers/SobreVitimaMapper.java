package br.com.devance.fonar.mappers;

import br.com.devance.fonar.dto.DTOSobreVitimaFonar;
import br.com.devance.fonar.models.SobreVitimaFONAR;

public class SobreVitimaMapper {

    public static SobreVitimaFONAR toEntity(DTOSobreVitimaFonar dto) {
        if (dto == null) {
            return null;
        }

        return SobreVitimaFONAR.builder()
                .tentouSeparar(dto.getTentouSeparar())
                .situacaoFilhos(dto.getSituacaoFilhos())
                .qtdFilhosComAgressor(dto.getQtdFilhosComAgressor())
                .qtdFilhosDeOutroRelacionamento(dto.getQtdFilhosDeOutroRelacionamento())
                .faixaEtariaFilhos(dto.getFaixaEtariaFilhos())
                .temFilhosDeficientes(dto.getTemFilhosDeficientes())
                .qtdFilhosDeficiencia(dto.getQtdFilhosDeficiencia())
                .conflitoDeGuarda(dto.getConflitoDeGuarda())
                .filhosViramViolencia(dto.getFilhosViramViolencia())
                .violenciaGravidezPosParto(dto.getViolenciaGravidezPosParto())
                .novoRelAumentaViolencia(dto.getNovoRelAumentaViolencia())
                .possuiDeficiencia(dto.getPossuiDeficiencia())
                .qualDeficiencia(dto.getQualDeficiencia())
                .corRaca(dto.getCorRaca())
                .build();
    }

    public static DTOSobreVitimaFonar toDTO(SobreVitimaFONAR entity) {
        if (entity == null) {
            return null;
        }

        return DTOSobreVitimaFonar.builder()
                .tentouSeparar(entity.getTentouSeparar())
                .situacaoFilhos(entity.getSituacaoFilhos())
                .qtdFilhosComAgressor(entity.getQtdFilhosComAgressor())
                .qtdFilhosDeOutroRelacionamento(entity.getQtdFilhosDeOutroRelacionamento())
                .faixaEtariaFilhos(entity.getFaixaEtariaFilhos())
                .temFilhosDeficientes(entity.isTemFilhosDeficientes())
                .qtdFilhosDeficiencia(entity.getQtdFilhosDeficiencia())
                .conflitoDeGuarda(entity.isConflitoDeGuarda())
                .filhosViramViolencia(entity.isFilhosViramViolencia())
                .violenciaGravidezPosParto(entity.isViolenciaGravidezPosParto())
                .novoRelAumentaViolencia(entity.isNovoRelAumentaViolencia())
                .possuiDeficiencia(entity.isPossuiDeficiencia())
                .qualDeficiencia(entity.getQualDeficiencia())
                .corRaca(entity.getCorRaca())
                .build();
    }
}
