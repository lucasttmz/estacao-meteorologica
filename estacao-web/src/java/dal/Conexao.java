package dal;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class Conexao {

    private static SessionFactory sessionFactory;

    static {
        iniciarFactory();
    }

    private static void iniciarFactory() {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Criação da SessionFactory falhou: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void limparCache() {
        fecharFactory();
        iniciarFactory();
    }

    public static void fecharFactory() {
        sessionFactory.close();
    }
}
