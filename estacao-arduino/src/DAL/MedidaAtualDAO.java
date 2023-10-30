package DAL;

import Modelo.MedidaAtual;
import org.hibernate.Session;

public class MedidaAtualDAO {
    public String mensagem;
    private final Session session = Conexao.getSessionFactory().openSession();
    
    public void salvarMedidaAtual(MedidaAtual medida) {
        this.mensagem = "";
        try {
            session.beginTransaction();
            session.save(medida);
            session.getTransaction().commit();
            session.flush();
            this.mensagem = "Nova medida salva com sucesso";
        } catch (Exception e) {
            this.mensagem = "Erro ao salvar no banco de dados";
        } finally {
            session.close();
        }
    }
}
