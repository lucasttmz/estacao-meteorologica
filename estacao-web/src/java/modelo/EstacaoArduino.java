package modelo;

import dal.MedidaAtualDAO;
import java.util.Date;

/**
 * Responsável por ler as medidas atuais vindas do Arduino que foram salvas no
 * banco de dados pela aplicação estacao-arduino.
 */
public class EstacaoArduino implements Estacao {

    private String mensagem;
    private static Date ultimaLeitura;
    
    
    @Override
    public MedidaAtual lerMedidaAtual() {
        MedidaAtualDAO medidaAtualDAO = new MedidaAtualDAO();
        MedidaAtual medidaAtual = medidaAtualDAO.pesquisarMedidaAtual();
        if (arduinoEstaConectado(medidaAtual)) {
            this.mensagem = medidaAtualDAO.mensagem;
        }
        EstacaoArduino.ultimaLeitura = medidaAtual.getMomento();
        return medidaAtual;
    }
    
    @Override
    public String getMensagem() {
        return this.mensagem;
    }
    
    public boolean arduinoEstaConectado(MedidaAtual medida) {
        Date momento = medida.getMomento();
        if (ultimaLeitura != null && momento.equals(ultimaLeitura)) {
            this.mensagem = "O arduino parece estar desconectado";
            return false;
        }
        return true;
    }

}
