package br.com.devance.fonar.mappers;


import br.com.devance.fonar.dto.DTOSobreAgressorFonar;
import br.com.devance.fonar.models.SobreAgressorFONAR;

public class SobreAgressorMapper {

    public static SobreAgressorFONAR toEntity (DTOSobreAgressorFonar dto) {
        if (dto == null) {
            return null;
        }

        return SobreAgressorFONAR.builder()
                .usoAbusivo(dto.getUsoAbusivo())
                .doencaMental(dto.getDoencaMental())
                .descumpriuMedidaProtetiva(dto.getDescumpriuMedidaProtetiva()) // Ajuste no nome do getter
                .tentouSuicido(dto.getTentouSuicidio())
                .dificuldadesFinanceiras(dto.getDificuldadesFinancieras()) // Ajuste no nome do getter
                .acessoArmasFogo(dto.getAcessoArmasFogo()) // Ajuste no nome do getter
                .ameacouOuAgrediu(dto.getAmeacouOuAgrediu()) // Ajuste no nome do getter
                .especificacaoAmeaca(dto.getEspecificacoesAmeaca()) // Copia o Set
                .build();
    }

    public static DTOSobreAgressorFonar toDTO (SobreAgressorFONAR entity) {
        if (entity == null) {
            return null;
        }

        DTOSobreAgressorFonar dto = new DTOSobreAgressorFonar();
        dto.setUsoAbusivo(entity.getUsoAbusivo());
        dto.setDoencaMental(entity.getDoencaMental());
        dto.setDescumpriuMedidaProtetiva(entity.getDescumpriuMedidaProtetiva());
        dto.setTentouSuicidio(entity.getTentouSuicido());
        dto.setDificuldadesFinancieras(entity.getDificuldadesFinanceiras());
        dto.setAcessoArmasFogo(entity.getAcessoArmasFogo());
        dto.setAmeacouOuAgrediu(entity.getAmeacouOuAgrediu());
        dto.setEspecificacoesAmeaca(entity.getEspecificacaoAmeaca());

        return dto;
    }
}