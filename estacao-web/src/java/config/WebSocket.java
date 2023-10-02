package config;

import java.util.ArrayList;
import java.util.List;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import modelo.MedidaAtual;

/**
 * Configuração do WebSocket.
 *
 * Realiza o handshake cliente-servidor armazenando as sessões conectadas. 
 * É responsável por enviar as medidas para o front-end.
 */
@ServerEndpoint(value = "/ws")
public class WebSocket {

    private static final List<Session> sessoesAtuais = new ArrayList<>();

    @OnOpen
    public void onOpen(Session sessao) {
        sessoesAtuais.add(sessao);
    }

    @OnClose
    public void onClose(Session sessao) {
        sessoesAtuais.remove(sessao);
    }

    public static void enviarMedida(MedidaAtual medida) {
        for (Session sessao : sessoesAtuais) {
            sessao.getAsyncRemote().sendText(formatarMedida(medida));
        }
    }

    private static String formatarMedida(MedidaAtual medida) {
        return new StringBuilder() 
                .append("{\"hora\": \"")
                .append(medida.getData().toLocalTime().toString())
                .append("\", \"temperatura\": ")
                .append(medida.getTemperatura().toString())
                .append(", \"humidade\": ")
                .append(medida.getHumidade().toString())
                .append(", \"precipitacao\": ")
                .append(medida.getPrecipitacao().toString())
                .append("}")
                .toString();
    }
}
