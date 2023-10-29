package modelo;

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
        MedidaAtualDAO medidaDAO = new MedidaAtualDAO();
        System.out.println("oi");
        List<MedidaDiaria> pesquisarMedidasDiarias = medidaDAO.pesquisarMedidasDiarias();
        System.out.println("size = " + pesquisarMedidasDiarias.size());
        for (MedidaDiaria pesquisarMedidasDiaria : pesquisarMedidasDiarias) {
            System.out.println(pesquisarMedidasDiaria);
        }
        return null;
    }

}
