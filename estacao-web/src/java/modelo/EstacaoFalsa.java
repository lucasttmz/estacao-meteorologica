package modelo;

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
        Double temperatura = rng.nextDouble(0, 100);
        Double humidade = rng.nextDouble(0, 100);
        Double precipitacao = rng.nextDouble(0, 1000);
        
        return new Medida(temperatura, humidade, precipitacao);
    }
   
}