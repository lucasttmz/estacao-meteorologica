package config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import modelo.Estacao;
import modelo.EstacaoArduino;
import modelo.EstacaoFalsa;

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

    // Configuração da leitura dos dados
    private static final int INTERVALO_ENTRE_DADOS = 5;
    private static final boolean UTILIZAR_ARDUINO = false;

    private ScheduledExecutorService executor;
    private Estacao estacao;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Contexto iniciado...");
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (UTILIZAR_ARDUINO) {
                estacao = new EstacaoArduino();
            } else {
                estacao = new EstacaoFalsa();
            }
            WebSocket.enviarMedida(estacao.lerMedidaAtual());
        }, 0, INTERVALO_ENTRE_DADOS, TimeUnit.SECONDS);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Contexto destruido!");
        if (executor != null) {
            executor.shutdownNow();
        }
    }
}
