package managedbeans;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Controle;
import org.primefaces.model.charts.line.LineChartModel;

/**
 * Bean responsável pelo carregamento dos gráficos de temperatura e umidade.
 */
@ManagedBean
@ApplicationScoped
public class bgrGrafico implements Serializable {

    private LineChartModel graficoTemperatura;
    private LineChartModel graficoUmidade;

    public bgrGrafico() {
        Controle controle = new Controle();
        graficoTemperatura = controle.montarGraficoTemperatura();
        graficoUmidade = controle.montarGraficoUmidade();
    }

    public LineChartModel getGraficoTemperatura() {
        return graficoTemperatura;
    }

    public void setGraficoTemperatura(LineChartModel graficoTemperatura) {
        this.graficoTemperatura = graficoTemperatura;
    }

    public LineChartModel getGraficoUmidade() {
        return graficoUmidade;
    }

    public void setGraficoUmidade(LineChartModel graficoUmidade) {
        this.graficoUmidade = graficoUmidade;
    }

    public String historicoMedidas() {
        return "historico.xhtml?faces-redirect=true";
    }

}
