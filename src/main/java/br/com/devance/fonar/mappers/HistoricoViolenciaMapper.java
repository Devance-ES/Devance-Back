package br.com.devance.fonar.mappers;

import br.com.devance.fonar.dto.DTOHistoricoViolenciaFonar;
import br.com.devance.fonar.models.HistoricoViolenciaFONAR;

public class HistoricoViolenciaMapper {

    public static HistoricoViolenciaFONAR toEntity (DTOHistoricoViolenciaFonar dto) {
        if (dto == null) {
            return null;
        }

        return HistoricoViolenciaFONAR.builder()
                .ameacas(dto.getAmeacas())
                .agressoesFisicasQ2(dto.getAgressoesFisicasQ2())
                .agressoesFisicasQ3(dto.getAgressoesFisicasQ3())
                .obrigouSexo(dto.getObrigouSexo())
                .comportamentos(dto.getComportamentos())
                .jaRegistrouBOAntes(dto.getJaRegistrouBOAntes())
                .frequentesRecentemente(dto.getFrequentesRecentemente())
                .build();
    }

    public static DTOHistoricoViolenciaFonar toDTO (HistoricoViolenciaFONAR entity) {
        if (entity == null) {
            return null;
        }

        DTOHistoricoViolenciaFonar dto = new DTOHistoricoViolenciaFonar();
        dto.setAmeacas(entity.getAmeacas());
        dto.setAgressoesFisicasQ2(entity.getAgressoesFisicasQ2());
        dto.setAgressoesFisicasQ3(entity.getAgressoesFisicasQ3());
        dto.setObrigouSexo(entity.getObrigouSexo());
        dto.setComportamentos(entity.getComportamentos());
        dto.setJaRegistrouBOAntes(entity.getJaRegistrouBOAntes());
        dto.setFrequentesRecentemente(entity.getFrequentesRecentemente());

        return dto;
    }
}
