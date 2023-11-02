package modelo;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

/**
 * Classe excluiva para testes sem o Arduino. Utilizar classe `EstacaoArduino`
 * para ler os dados verdadeiros.
 */
public class EstacaoFalsa implements Estacao {

    @Override
    public MedidaAtual lerMedidaAtual() {
        Random rng = new Random();
        Integer temperatura = rng.nextInt(50);
        Integer umidade = rng.nextInt(80);
        Integer chuva = rng.nextInt(1033);
        Date data = Date.from(Instant.now());

        MedidaAtual medidaAtual = new MedidaAtual();
        medidaAtual.setChuva(chuva);
        medidaAtual.setUmidade(umidade);
        medidaAtual.setTemperatura(temperatura);
        medidaAtual.setMomento(data);

        return medidaAtual;
    }

    @Override
    public String getMensagem() {
        return "";
    }

}
