package dal;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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

    // Metodo temporario para testes
    public MedidaAtual pesquisarMedidaAtual() {
        this.mensagem = "";
        MedidaAtual medida = new MedidaAtual();

        try {
            // Mudar a query para ser dinamica
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
                    + "CASE WHEN MAX(m.chuva) >= 50 THEN 1 ELSE 0 END AS choveu "
                    + "FROM MedidaAtual m "
                    + "GROUP BY DATE(m.momento)");
            
            if (query.list().size() > 0) {
                System.out.println("PRINT AQUI");
                
                for (int i = 0; i < query.list().size(); i++) {
                    MedidaDiaria medida = (MedidaDiaria) query.list().get(i);
                    System.out.println(medida);
                    medidas.add(medida);
                }
            } else {
                this.mensagem = "Registro não encontrado";
            }

        } catch (Exception e) {
            this.mensagem = "Erro de BD";
        } finally {
            session.close();
        }
        
        for (MedidaDiaria medida : medidas) {
            System.out.println(medida);
            System.out.println("123");
        }

        return medidas;
    }
}
