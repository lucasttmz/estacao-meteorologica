package config;

import dal.Conexao;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import modelo.Controle;
import static modelo.Estaticos.DELAY_INICIAL;

import static modelo.Estaticos.INTERVALO_ENTRE_DADOS;

/**
 * Configuração do Servidor.
 *
 * Inicia a leitura dos dados do Arduino em segundo plano
 *
 * Dados são então enviados para o frontend para todos os clientes conectados
 * através da conexão estabelecida através de Web Sockets
 */
@WebListener
public class Servidor implements ServletContextListener {

    private ScheduledExecutorService executor;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Contexto iniciado...");
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            new Controle().enviarMedidaAtual();
        }, DELAY_INICIAL, INTERVALO_ENTRE_DADOS, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Contexto destruido!");
        if (executor != null) {
            executor.shutdownNow();
        }
        Conexao.desligar(); // Senão o tomcat não termina!
    }
}
