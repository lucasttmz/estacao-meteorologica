package modelo;

import dal.MedidaAtualDAO;

/**
 * Responsável por ler as medidas atuais vindas do Arduino que foram salvas no
 * banco de dados pela aplicação estacao-arduino.
 */
public class EstacaoArduino implements Estacao {

    @Override
    public MedidaAtual lerMedidaAtual() {
        return new MedidaAtualDAO().pesquisarMedidaAtual();
    }

}
