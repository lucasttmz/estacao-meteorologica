package dal;

import java.sql.*;
import modelo.MedidaAtual;

/**
 * DAO para ler a medida atual salva diretamente pelo Arduino. (NUNO)
 */
public class MedidaAtualDAO {

    public String mensagem = "";

    // Metodo temporario para testes
    public MedidaAtual pesquisarMedidaAtual() {
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        MedidaAtual medidaAtual = new MedidaAtual();
        if (!conexao.mensagem.equals("")) {
            this.mensagem = conexao.mensagem;
            return medidaAtual;
        }
        try {
            String comSql = "select * from registro order by cd_registro desc limit 1;";
            PreparedStatement stmt = con.prepareStatement(comSql);
            ResultSet resultset = stmt.executeQuery();
            if (resultset.next()) {
                medidaAtual.setTemperatura(resultset.getInt("temperatura"));
                medidaAtual.setUmidade(resultset.getInt("umidade"));
                medidaAtual.setPrecipitacao(resultset.getInt("chuva"));
                medidaAtual.setData(resultset.getTimestamp("momento").toLocalDateTime());
            } else {
                this.mensagem = "Nenhuma medida salva no banco de dados";
            }
        } catch (SQLException e) {
            this.mensagem = "Erro de conexao BD";
        } finally {
            conexao.desconectar();
        }
        return medidaAtual;
    }
}
