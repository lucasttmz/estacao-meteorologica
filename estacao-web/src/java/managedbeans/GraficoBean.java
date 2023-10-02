package managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import modelo.Controle;
import org.primefaces.model.charts.line.LineChartModel;

/**
 * Bean responsável pelo carregamento dos gráficos de temperatura e humidade.
 */
@ManagedBean
@ApplicationScoped
public class GraficoBean {

    private LineChartModel graficoTemperatura;
    private LineChartModel graficoHumidade;
    private Controle controle;

    @PostConstruct
    public void inicializarGraficos() {
        controle = new Controle();
        graficoTemperatura = controle.montarGraficoTemperatura();
        graficoHumidade = controle.montarGraficoHumidade();
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

    public String historicoMedidas() {
        return "historico.xhtml?faces-redirect=true";
    }

}
