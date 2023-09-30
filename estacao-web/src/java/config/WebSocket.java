package config;

import java.util.ArrayList;
import java.util.List;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import modelo.Medida;

@ServerEndpoint(value = "/ws")
public class WebSocket {

    private static final List<Session> sessoesAtuais = new ArrayList<>();

    @OnOpen
    public void onOpen(Session sessao) {
        System.out.println("Cliente " + sessao.getId() + " se conectou...");
        sessoesAtuais.add(sessao);
    }

    @OnClose
    public void onClose(Session sessao) {
        System.out.println("Cliente " + sessao.getId() + " se desconectou!");
        sessoesAtuais.remove(sessao);
    }

    public static void enviarMedida(Medida medida) {
        for (Session sessao : sessoesAtuais) {
            sessao.getAsyncRemote().sendText(formatarMedida(medida));
        }
    }

    private static String formatarMedida(Medida medida) {
        return new StringBuilder()
                .append("{\"temperatura\": ")
                .append(medida.getTemperatura().toString())
                .append(", \"humidade\": ")
                .append(medida.getHumidade().toString())
                .append(", \"precipitacao\": ")
                .append(medida.getPrecipitacao().toString())
                .append("}")
                .toString();
    }
}
