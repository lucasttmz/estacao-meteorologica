package Modelo;
import DAL.RegistroDAO;
import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.InputStream;

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
        Registro registro = new Registro();
        RegistroDAO registroDAO = new RegistroDAO();
        try {
            while (Estaticos.coletaSerial) {
                retorno += (char) in.read();
                if (retorno.charAt(retorno.length()-1) == '\n') {
                    valores = retorno.split(",");
                    registro.umidade = String.valueOf(valores[0]);
                    registro.temperatura = String.valueOf(valores[1]);
                    registro.chuva = String.valueOf(valores[2]);
                    retorno = "";
                    registroDAO.registrar(registro);
                    System.out.println(registro.toString());
                    
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: "+e.getMessage());
        }
        comPort.closePort();
    }
}
