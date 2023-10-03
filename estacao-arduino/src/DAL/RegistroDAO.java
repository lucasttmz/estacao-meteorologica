package DAL;
import java.sql.*;
import Modelo.Registro;
import java.time.LocalDateTime;

public class RegistroDAO {
    public String mensagem;
    
    public void registrar(Registro registro){
        this.mensagem = "";
        Conexao conexao = new Conexao();
        Connection con = conexao.conectar();
        
        if (!conexao.mensagem.equals("")) {
            this.mensagem = conexao.mensagem;
            return;
        }
        
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO registro (umidade, temperatura, chuva, momento) VALUES (?,?,?,?)");
            stmt.setString(1, registro.umidade);
            stmt.setString(2, registro.temperatura);
            stmt.setString(3, registro.chuva);
            stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            stmt.execute();
        } catch (SQLException e) {
            this.mensagem = "Erro ao salvar registro: " + e.getMessage();
        } finally {
            conexao.desconectar();
        }
        
    }
}
