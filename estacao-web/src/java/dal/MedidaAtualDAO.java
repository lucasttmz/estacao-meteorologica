package dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.MedidaAtual;
import modelo.MedidaDiaria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * DAO para ler a medida atual salva diretamente pelo Arduino. (NUNO)
 */
public class MedidaAtualDAO {

    public String mensagem = "";
    public Session session = Conexao.getSessionFactory().openSession();

    public MedidaAtual pesquisarMedidaAtual() {
        this.mensagem = "";
        MedidaAtual medida = new MedidaAtual();

        try {
            Query query = session.createQuery("from MedidaAtual where id=(select max(idMedidaAtual) from MedidaAtual)");
            if (query.list().size() > 0) {
                medida = (MedidaAtual) query.uniqueResult();
            } else {
                this.mensagem = "Registro não encontrado";
            }
            session.flush();
        } catch (Exception e) {
            this.mensagem = "Erro de BD";
        } finally {
            session.close();
        }

        return medida;
    }

    public List<MedidaDiaria> pesquisarMedidasDiarias() {

        List<MedidaDiaria> medidas = new ArrayList<MedidaDiaria>();

        try {
            Query query = session.createQuery("SELECT "
                    + "DATE(m.momento) AS data, "
                    + "MIN(m.temperatura) AS temperaturaMinima, "
                    + "AVG(m.temperatura) AS temperaturaMedia, "
                    + "MAX(m.temperatura) AS temperaturaMaxima, "
                    + "MIN(m.umidade) AS umidadeMinima, "
                    + "AVG(m.umidade) AS umidadeMedia, "
                    + "MAX(m.umidade) AS umidadeMaxima, "
                    + "CASE WHEN MAX(m.chuva) > 500 THEN false ELSE true END AS choveu "
                    + "FROM MedidaAtual m "
                    + "GROUP BY DATE(m.momento)");

            List<Object[]> resultados = query.list();
            MedidaDiaria medidaDiaria;
            for (Object[] resultado : resultados) {
                medidaDiaria = new MedidaDiaria();
                medidaDiaria.setData((Date) resultado[0]);
                medidaDiaria.setTemperaturaMinima((Integer) resultado[1]);
                medidaDiaria.setTemperaturaMedia((Double) resultado[2]);
                medidaDiaria.setTemperaturaMaxima((Integer) resultado[3]);
                medidaDiaria.setUmidadeMinima((Integer) resultado[4]);
                medidaDiaria.setUmidadeMedia((Double) resultado[5]);
                medidaDiaria.setUmidadeMaxima((Integer) resultado[6]);
                medidaDiaria.setChoveu((Boolean) resultado[7]);
                medidas.add(medidaDiaria);
            }

        } catch (Exception e) {
            this.mensagem = "Erro de BD";
        } finally {
            session.close();
        }

        return medidas;
    }
}
