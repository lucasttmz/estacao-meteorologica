package modelo;

import dal.MedidaDiariaDAO;
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

    public LineChartModel montarGraficoHumidade() {
        Grafico grafico = new Grafico();
        return grafico.montarGraficoHumidade();
    }

    public MedidaAtual lerMedidaAtual() {
        Estacao estacao;
        if (UTILIZAR_ARDUINO) {
            estacao = new EstacaoArduino();
        } else {
            estacao = new EstacaoFalsa();
        }
        return estacao.lerMedidaAtual();
    }

    public List<MedidaDiaria> listarHistoricoMedidas() {
        MedidaDiariaDAO medidaDiariaDAO = new MedidaDiariaDAO();
        return medidaDiariaDAO.pesquisarMedidasDiarias();
    }

}
