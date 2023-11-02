package Modelo;

import DAL.MedidaAtualDAO;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class Controle {
    public void salvarNovaMedida(List<String> medidas) {
        
        for (String medida : medidas) {
            System.out.println(medida);
        }
        medidas.set(1, medidas.get(1).charAt(0) + "" + medidas.get(1).charAt(1));
        MedidaAtual medidaAtual = new MedidaAtual();
        medidaAtual.setMomento(Timestamp.valueOf(LocalDateTime.now()));
        medidaAtual.setTemperatura(Integer.valueOf(medidas.get(0)));
        medidaAtual.setUmidade(Integer.valueOf(medidas.get(1)));
        medidaAtual.setChuva(Integer.valueOf(medidas.get(2)));
        
        MedidaAtualDAO medidaAtualDAO = new MedidaAtualDAO();
        medidaAtualDAO.salvarMedidaAtual(medidaAtual);
        
    }
}
