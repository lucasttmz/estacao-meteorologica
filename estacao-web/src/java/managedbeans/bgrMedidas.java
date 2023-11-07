package managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import modelo.Controle;
import modelo.MedidaDiaria;

/**
 * Bean responsável por mostrar as medidas passadas salvas no banco de dados.
 */
@ManagedBean
@ApplicationScoped
public class bgrMedidas implements Serializable {

    private List<MedidaDiaria> historicoDeMedidas;

    public List<MedidaDiaria> getHistoricoDeMedidas() {
        return historicoDeMedidas;
    }

    public void setHistoricoDeMedidas(List<MedidaDiaria> historicoDeMedidas) {
        this.historicoDeMedidas = historicoDeMedidas;
    }
    
    public void carregarHistorico() {
        Controle controle = new Controle();
        historicoDeMedidas = controle.listarHistoricoMedidas();
    }
    
    public String paginaInicial() {
        return "index.xhtml?faces-redirect=true";
    }

}
