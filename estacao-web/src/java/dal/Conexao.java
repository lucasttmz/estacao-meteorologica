package dal;

import java.sql.*;

/**
 * Classe temporaria apenas para teste inicial
 * Substituir por Hibernate (Nuno)
 */
public class Conexao {
    public String mensagem;
    public String conStr = "jdbc:mysql://localhost:3306/estacaoAPS";
    private Connection con;
    
    public Connection conectar(){
        this.mensagem = "";
        try {
            if (con == null || con.isClosed()){
                // Linha mágica, sem isso aqui não funciona ?!
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(conStr, "root", "lucas123");
            }
        } catch (ClassNotFoundException | SQLException e) {
            this.mensagem = "Erro ao conectar com DB: " + e.getMessage();
        }
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