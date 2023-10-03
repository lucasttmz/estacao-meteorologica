package DAL;
import java.sql.*;

public class Conexao {
    public String mensagem;
    public String conStr = "jdbc:mysql://localhost:3306/estacaoAPS";
    private Connection con;
    
    public Connection conectar(){
        this.mensagem = "";
        try {
            if (con == null || con.isClosed()){
                con = DriverManager.getConnection(conStr, "root", "");
                System.out.println("Sucesso ao realizar conexao com o DB");
            }
        } catch (SQLException e) {
            this.mensagem = "Erro ao conectar com DB: " + e.getMessage();
        }
        
        System.out.println(this.mensagem);
        return con;
    }
    
    public void desconectar(){
        try {
            if (con != null && !con.isClosed()){
                con.close();
            }
        } catch (SQLException e) {
            this.mensagem = "Erro ao fechar conexao: " + e.getMessage();
        }
    }
}