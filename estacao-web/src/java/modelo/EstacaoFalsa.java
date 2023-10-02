package modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**
 * CLASSE EXCLUSIVA PARA TESTES SEM O ARDUINO
 * UTILIZAR CLASSE `EstacaoArduino` PARA LER OS DADOS VERDADEIROS
 */
public class EstacaoFalsa implements Estacao {

    @Override
    public Medida lerMedidaAtual() {
        // Reescrever os valores para que sejam mais próximos dos valores reais
        Random rng = new Random();
        LocalDateTime data = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        Double temperatura = rng.nextDouble(0, 100);
        Double humidade = rng.nextDouble(0, 100);
        Integer precipitacao = rng.nextInt(0, 1033);
        
        return new Medida(data, temperatura, humidade, precipitacao);
    }
   
}