package br.com.devance.fonar.mappers;

import br.com.devance.fonar.dto.DTOIdentificacaoPartesFonar;
import br.com.devance.fonar.models.IdentificacaoPartesFONAR;

public class IdentificacaoPartesMapper {

    public static IdentificacaoPartesFONAR toEntity (DTOIdentificacaoPartesFonar dto) {
        if (dto == null) {
            return null;
        }

        return IdentificacaoPartesFONAR.builder()
                .nomeVitima(dto.getNomeVitima())
                .idadeVitima(dto.getIdadeVitima())
                .escolaridadeVitima(dto.getEscolaridadeVitima())
                .nacionalidadeVitima(dto.getNacionalidadeVitima())
                .nomeAgressor(dto.getNomeAgressor())
                .idadeAgressor(dto.getIdadeAgressor())
                .escolaridadeAgressor(dto.getEscolaridadeAgressor())
                .nacionalidadeAgressor(dto.getNacionalidadeAgressor())
                .vinculoEntrePartes(dto.getVinculoEntrePartes())
                .dataOcorrencia(dto.getDataOcorrencia())
                .build();
    }

    public static DTOIdentificacaoPartesFonar toDTO (IdentificacaoPartesFONAR entity) {
        if (entity == null) {
            return null;
        }

        DTOIdentificacaoPartesFonar dto = new DTOIdentificacaoPartesFonar();
        dto.setNomeVitima(entity.getNomeVitima());
        dto.setIdadeVitima(entity.getIdadeVitima());
        dto.setEscolaridadeVitima(entity.getEscolaridadeVitima());
        dto.setNacionalidadeVitima(entity.getNacionalidadeVitima());
        dto.setNomeAgressor(entity.getNomeAgressor());
        dto.setIdadeAgressor(entity.getIdadeAgressor());
        dto.setEscolaridadeAgressor(entity.getEscolaridadeAgressor());
        dto.setNacionalidadeAgressor(entity.getNacionalidadeAgressor());
        dto.setVinculoEntrePartes(entity.getVinculoEntrePartes());
        dto.setDataOcorrencia(entity.getDataOcorrencia());

        return dto;
    }
}