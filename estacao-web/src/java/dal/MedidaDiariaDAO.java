package dal;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import modelo.MedidaDiaria;

/**
 * DAO para ler as medidas diárias a partir das medidas já salvas no BD.
 * (NUNO)
 */
public class MedidaDiariaDAO {
    /*
    Algo semelhante a isso porem no Hibernate
    SELECT 
        DATE(dataHora) AS data,
        MIN(temperatura) AS tempMin,
        AVG(temperatura) AS tempAvg,
        MAX(temperatura) AS tempMax
        MIN(humidade) AS humMin,
        AVG(humidade) AS humAvg,
        MAX(humidade) AS humMax
        MAX(precipitacao >= 50) AS choveu
    FROM
        MedidaAtual
    GROUP BY
        DATE(dataHora);
    */
    
    public List<MedidaDiaria> pesquisarMedidasDiarias() {
        // METODO TEMPORARIO PARA TESTES
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
        return dados;
    }
}