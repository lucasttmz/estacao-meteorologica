package Modelo;
import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Serial implements Runnable {    
    @Override
    public void run(){
        executar();
    }
    
    public void executar(){
        String retorno = "";
        String[] valores = new String[3];
        
        SerialPort comPort = SerialPort.getCommPort("COM5");
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        InputStream in = comPort.getInputStream();
        List<String> registro = new ArrayList<String>();
        Controle controle = new Controle();
//        Registro registro = new Registro();
//        RegistroDAO registroDAO = new RegistroDAO();
        try {
            while (Estaticos.coletaSerial) {
                retorno += (char) in.read();
                if (retorno.charAt(retorno.length()-1) == '\n') {
                    valores = retorno.split(",");
//                    registro.umidade = String.valueOf(valores[0]);
//                    registro.temperatura = String.valueOf(valores[1]);
//                    registro.chuva = String.valueOf(valores[2]);
                    registro.add(String.valueOf(valores[1])); // temperatura
                    registro.add(String.valueOf(valores[0])); // umidade
//                    registro.add(String.valueOf(valores[2])); // chuva
                    registro.add(String.valueOf(valores[2].replaceAll("\\R", ""))); // chuva
                    retorno = "";
                    controle.salvarNovaMedida(registro);
//                    registroDAO.registrar(registro);
                    System.out.println(String.join(",", registro));
                    registro.clear();
                    
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: "+e.getMessage());
        }
        comPort.closePort();
    }
}
