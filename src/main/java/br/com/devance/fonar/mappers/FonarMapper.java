package br.com.devance.fonar.mappers;

import br.com.devance.fonar.dto.DTOEntradaFonar;
import br.com.devance.fonar.dto.DTOSaidaFonar;
import br.com.devance.fonar.enums.Status;
import br.com.devance.fonar.models.Fonar;

public class FonarMapper {

    public static Fonar toEntity(DTOEntradaFonar dto) {
        if (dto == null) {
            return null;
        }

        Fonar fonar = new Fonar();

        fonar.setCpfVitima(dto.getCpfVitima());

        fonar.setIdentificacaoPartes(IdentificacaoPartesMapper.toEntity(dto.getIdentificacaoPartes()));
        fonar.setBlocoI_HistoricoViolencia(HistoricoViolenciaMapper.toEntity(dto.getBlocoI_HistoricoViolencia()));
        fonar.setBlocoII_SobreAgressor(SobreAgressorMapper.toEntity(dto.getBlocoII_SobreAgressor()));
        fonar.setBlocoIII_SobreVitima(SobreVitimaMapper.toEntity(dto.getBlocoIII_SobreVitima()));
        fonar.setBlocoIV_OutrasInformacoes(OutrasInformacoesMapper.toEntity(dto.getBlocoIV_OutrasInformacoes()));
        fonar.setPreenchimentoProfissional(PreenchimentoProfissionalMapper.toEntity(dto.getPreenchimentoProfissional()));

        // Outros campos como delegacia, dataRegistro, responsavel, grauDeRiscoCalculado, statusTriagem e caminhoImagemOriginal
        // normalmente são setados em outros momentos do fluxo (service/controller), então podemos deixar para o serviço

        return fonar;
    }

    public static DTOEntradaFonar toDTO(Fonar entity) {
        if (entity == null) {
            return null;
        }

        return DTOEntradaFonar.builder()
                .cpfVitima(entity.getCpfVitima())
                .identificacaoPartes(IdentificacaoPartesMapper.toDTO(entity.getIdentificacaoPartes()))
                .blocoI_HistoricoViolencia(HistoricoViolenciaMapper.toDTO(entity.getBlocoI_HistoricoViolencia()))
                .blocoII_SobreAgressor(SobreAgressorMapper.toDTO(entity.getBlocoII_SobreAgressor()))
                .blocoIII_SobreVitima(SobreVitimaMapper.toDTO(entity.getBlocoIII_SobreVitima()))
                .blocoIV_OutrasInformacoes(OutrasInformacoesMapper.toDTO(entity.getBlocoIV_OutrasInformacoes()))
                .preenchimentoProfissional(PreenchimentoProfissionalMapper.toDTO(entity.getPreenchimentoProfissional()))
                .build();
    }

    public static DTOSaidaFonar toResponseDTO(Fonar entity) {
        if (entity == null) {
            return null;
        }

        return DTOSaidaFonar.builder()
                .idFonar(entity.getIdFonar())
                .cpfVitima(entity.getCpfVitima())
                .nomeDelegacia(entity.getDelegacia().getNome())
                .dataRegistro(entity.getDataRegistro())
                .responsavel(entity.getResponsavel())
                .grauDeRiscoCalculado(entity.getGrauDeRiscoCalculado())
                .statusTriagem((Status) entity.getStatusTriagem())
                .build();
    }
}
