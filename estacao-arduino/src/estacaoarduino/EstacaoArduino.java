package estacaoarduino;

import Apresentacao.FrmPrincipal;
import Modelo.Controle;
import java.util.ArrayList;
import java.util.List;

public class EstacaoArduino {

    public static void main(String[] args) {
        FrmPrincipal frmPrincipal = new FrmPrincipal(null, true);
        frmPrincipal.setVisible(true);
//        simular();
        System.exit(0); // Para terminar o processo do hibernate
    }

    public static void simular() {
        String retorno = "";
        String[] valores = new String[3];

        List<String> registro = new ArrayList<String>();
        Controle controle = new Controle();
        try {
            retorno = "50,55,80\n";
            if (retorno.charAt(retorno.length() - 1) == '\n') {
                valores = retorno.split(",");
                registro.add(valores[1]); // temperatura
                registro.add(valores[0]); // umidade
                registro.add(String.valueOf(valores[2].replaceAll("\\R", ""))); // chuva
                retorno = "";
                controle.salvarNovaMedida(registro);
                System.out.println(String.join(",", registro));
                registro.clear();

            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

}
