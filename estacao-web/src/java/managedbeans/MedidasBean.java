package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import modelo.Controle;
import modelo.MedidaDiaria;

/**
 * Bean responsável por mostrar as medidas passadas salvas no banco de dados.
 */
@ManagedBean
@ViewScoped
public class MedidasBean {

    public List<MedidaDiaria> pesquisarMedidas() {
        Controle controle = new Controle();
        return controle.listarHistoricoMedidas();
    }
    
    public String paginaInicial() {
        return "index.xhtml?faces-redirect=true";
    }

}
