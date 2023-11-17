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
        
        SerialPort comPort = SerialPort.getCommPort("COM3");
        comPort.openPort();
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        InputStream in = comPort.getInputStream();
        List<String> registro = new ArrayList<String>();
        Controle controle = new Controle();
        try {
            while (Estaticos.coletaSerial) {
                retorno += (char) in.read();
                if (retorno.charAt(retorno.length()-1) == '\n') {
                    valores = retorno.split(",");
                    registro.add(String.valueOf(valores[1])); // temperatura
                    registro.add(String.valueOf(valores[0])); // umidade
                    registro.add(String.valueOf(valores[2].replaceAll("\\R", ""))); // chuva
                    retorno = "";
                    
                    controle.salvarNovaMedida(registro);
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
