package modelo;

/**
 * Responsável por ler as medidas atuais vindas do Arduino que foram salvas 
 * no banco de dados pela aplicação estacao-arduino.
 */
public class EstacaoArduino implements Estacao {

    public EstacaoArduino() {

    }
    
    @Override
    public MedidaAtual lerMedidaAtual() {
        // Ler medida mais recente diretamente do banco de dados
        throw new UnsupportedOperationException("Implementar no futuro");
    }

}