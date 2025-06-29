package br.com.devance.fonar.mappers;

import br.com.devance.fonar.dto.DTOPreenchimentoProfissionalFonar;
import br.com.devance.fonar.models.PreenchimentoProfissionalFONAR;

public class PreenchimentoProfissionalMapper {

    public static PreenchimentoProfissionalFONAR toEntity(DTOPreenchimentoProfissionalFonar dto) {
        if (dto == null) {
            return null;
        }

        return PreenchimentoProfissionalFONAR.builder()
                .tipoPreenchimentoProfissional(dto.getTipoPreenchimento())
                .build();
    }

    public static DTOPreenchimentoProfissionalFonar toDTO(PreenchimentoProfissionalFONAR entity) {
        if (entity == null) {
            return null;
        }

        return DTOPreenchimentoProfissionalFonar.builder()
                .tipoPreenchimento(entity.getTipoPreenchimentoProfissional())
                .build();
    }
}
