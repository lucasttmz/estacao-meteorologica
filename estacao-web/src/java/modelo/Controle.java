package modelo;

import config.WebSocket;
import dal.MedidaAtualDAO;
import java.util.List;
import static modelo.Estaticos.UTILIZAR_ARDUINO;
import org.primefaces.model.charts.line.LineChartModel;

/**
 * Classe central da aplicação.
 */
public class Controle {

    public LineChartModel montarGraficoTemperatura() {
        Grafico grafico = new Grafico();
        return grafico.montarGraficoTemperatura();
    }

    public LineChartModel montarGraficoUmidade() {
        Grafico grafico = new Grafico();
        return grafico.montarGraficoUmidade();
    }

    public void enviarMedidaAtual() {
        Estacao estacao;
        if (UTILIZAR_ARDUINO) {
            estacao = new EstacaoArduino();
        } else {
            estacao = new EstacaoFalsa();
        }
        WebSocket.enviarMedida(estacao.lerMedidaAtual());
    }
    
    public List<MedidaDiaria> listarHistoricoMedidas() {
        MedidaAtualDAO medidaDAO = new MedidaAtualDAO();
        return medidaDAO.pesquisarMedidasDiarias();
    }

}
