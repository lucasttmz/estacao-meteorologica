package modelo;

import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;

/**
 * Responsável por preparar os gráficos de temperatura e humidade.
 */
public class Grafico {

    public LineChartModel montarGraficoTemperatura() {
        LineChartModel graficoTemperatura = new LineChartModel();

        ChartData dadosTemperatura = new ChartData();
        LineChartDataSet configTemperatura = new LineChartDataSet();
        List<Object> temperaturas = new ArrayList<>();

        configTemperatura.setData(temperaturas);
        configTemperatura.setFill(false);
        configTemperatura.setLabel("Temperatura");
        configTemperatura.setBorderColor("rgb(255, 102, 102)");
        configTemperatura.setTension(0.3);
        dadosTemperatura.addChartDataSet(configTemperatura);
        graficoTemperatura.setData(dadosTemperatura);

        return graficoTemperatura;
    }

    public LineChartModel montarGraficoUmidade() {
        LineChartModel graficoUmidade = new LineChartModel();

        ChartData dadosUmidade = new ChartData();
        LineChartDataSet configUmidade = new LineChartDataSet();
        List<Object> umidade = new ArrayList<>();

        configUmidade.setData(umidade);
        configUmidade.setFill(false);
        configUmidade.setLabel("Umidade");
        configUmidade.setBorderColor("rgb(153, 204, 255)");
        configUmidade.setTension(0.3);
        dadosUmidade.addChartDataSet(configUmidade);
        graficoUmidade.setData(dadosUmidade);

        return graficoUmidade;
    }
}
