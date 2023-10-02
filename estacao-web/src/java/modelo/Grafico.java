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
        configTemperatura.setTension(0.1);
        dadosTemperatura.addChartDataSet(configTemperatura);
        graficoTemperatura.setData(dadosTemperatura);
        
        return graficoTemperatura;
    }
    
    public LineChartModel montarGraficoHumidade() {
        LineChartModel graficoHumidade = new LineChartModel();
        
        ChartData dadosHumidade = new ChartData();
        LineChartDataSet configHumidade = new LineChartDataSet();
        List<Object> temperaturas = new ArrayList<>();
        
        configHumidade.setData(temperaturas);
        configHumidade.setFill(false);
        configHumidade.setLabel("Humidade");
        configHumidade.setBorderColor("rgb(153, 204, 255)");
        configHumidade.setTension(0.1);
        dadosHumidade.addChartDataSet(configHumidade);
        graficoHumidade.setData(dadosHumidade);
        
        return graficoHumidade;
    }
}