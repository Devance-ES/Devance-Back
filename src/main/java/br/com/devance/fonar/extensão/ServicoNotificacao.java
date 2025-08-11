package br.com.devance.fonar.extensão;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServicoNotificacao {

    private static final Logger logger = LoggerFactory.getLogger(ServicoNotificacao.class);

    /**
     * Simula o disparo de uma notificação para delegados.
     * @param idFonar O ID do FONAR que gerou o risco alto.
     * @param pontuacaoRisco A pontuação do risco.
     * @UseCase Disparar Notificação de Risco Elevado (UC02)
     */
    public void notificarRiscoElevado(Long idFonar, int pontuacaoRisco) {
        logger.warn(">>> NOTIFICAÇÃO DE ALERTA: FONAR ID {} com pontuação de risco ALTA ({}). Necessita triagem imediata. <<<",
                idFonar, pontuacaoRisco);
    }
}