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
            Query query = session.createQuery("from MedidaAtual m where m.idMedidaAtual = :id");
            query.setParameter("id", 1);
            if (query.list().size() > 0) {
                medida = (MedidaAtual) query.list().get(0);
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
        // METODO TEMPORARIO PARA TESTES
         /*
         Algo semelhante a isso porem no Hibernate
         SELECT 
            DATE(dataHora) AS data,
            MIN(temperatura) AS tempMin,
            AVG(temperatura) AS tempAvg,
            MAX(temperatura) AS tempMax
            MIN(umidade) AS umiMin,
            AVG(umidade) AS umiAvg,
            MAX(umidade) AS umiMax
            MAX(precipitacao >= 50) AS choveu
         FROM
            MedidaAtual
         GROUP BY
            DATE(dataHora);
         */
        List<MedidaDiaria> dados = new ArrayList<>();
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 1), 10d, 20d, 30d, 5d, 20d, 35d, false));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 2), 15d, 25d, 35d, 50d, 200d, 350d, true));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 3), 5d, 10d, 15d, 5d, 10d, 15d, false));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 4), 50d, 55d, 60d, 1d, 2d, 3d, false));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 5), 10d, 25d, 40d, 20d, 40d, 60d, true));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 6), 40d, 60d, 80d, 5d, 7d, 10d, false));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 7), 30d, 35d, 40d, 5d, 10d, 15d, false));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 8), 12d, 17d, 23d, 30d, 30d, 35d, true));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 9), 20d, 30d, 40d, 5d, 10d, 15d, false));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 10), 40d, 47d, 55d, 25d, 30d, 35d, true));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 7), 30d, 35d, 40d, 5d, 10d, 15d, false));
        dados.add(new MedidaDiaria(LocalDate.of(2023, Month.MARCH, 8), 12d, 17d, 23d, 30d, 30d, 35d, true));
        return dados;
    }
}
