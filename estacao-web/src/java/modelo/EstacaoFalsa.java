package modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**
 * Classe excluiva para testes sem o Arduino.
 * Utilizar classe `EstacaoArduino` para ler os dados verdadeiros.
 */
public class EstacaoFalsa implements Estacao {

    @Override
    public MedidaAtual lerMedidaAtual() {
        // Reescrever os valores para que sejam mais próximos dos valores reais
        Random rng = new Random();
        LocalDateTime data = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        Integer temperatura = rng.nextInt(100);
        Integer umidade = rng.nextInt(100);
        Integer precipitacao = rng.nextInt(1033);
        return new MedidaAtual(data, temperatura, umidade, precipitacao);
    }
   
}