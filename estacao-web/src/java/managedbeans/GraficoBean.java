package managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;

@ManagedBean
@ApplicationScoped
public class GraficoBean {
    private LineChartModel graficoTemperatura;
    private LineChartModel graficoHumidade;
    
    @PostConstruct
    public void inicializarGraficos() {
        iniciarTemperatura();
        iniciarHumidade();
    }
    
    private void iniciarTemperatura() {
        graficoTemperatura = new LineChartModel();
        
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
    }
    
    private void iniciarHumidade() {
        graficoHumidade = new LineChartModel();
        
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
    }

    public LineChartModel getGraficoTemperatura() {
        return graficoTemperatura;
    }

    public void setGraficoTemperatura(LineChartModel graficoTemperatura) {
        this.graficoTemperatura = graficoTemperatura;
    }

    public LineChartModel getGraficoHumidade() {
        return graficoHumidade;
    }

    public void setGraficoHumidade(LineChartModel graficoHumidade) {
        this.graficoHumidade = graficoHumidade;
    }
    
}