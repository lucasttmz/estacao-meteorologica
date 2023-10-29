package modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 * Representa a média das medidas de um certo dia.
 * 
 * FAZER O MAPEAMENTO DO HIBERNATE (NUNO)
 */
public class MedidaDiaria {
    private Date data;
    private int temperaturaMinima;
    private double temperaturaMedia;
    private int temperaturaMaxima;
    private int umidadeMinima;
    private double umidadeMedia;
    private int umidadeMaxima;
    private boolean choveu;

    
    public MedidaDiaria() {
        
    }

    public MedidaDiaria(Date data, int temperaturaMinima, double temperaturaMedia, int temperaturaMaxima, int umidadeMinima, double umidadeMedia, int umidadeMaxima, boolean choveu) {
        this.data = data;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMedia = temperaturaMedia;
        this.temperaturaMaxima = temperaturaMaxima;
        this.umidadeMinima = umidadeMinima;
        this.umidadeMedia = umidadeMedia;
        this.umidadeMaxima = umidadeMaxima;
        this.choveu = choveu;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(int temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(int temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public int getUmidadeMinima() {
        return umidadeMinima;
    }

    public void setUmidadeMinima(int umidadeMinima) {
        this.umidadeMinima = umidadeMinima;
    }

    public double getUmidadeMedia() {
        return umidadeMedia;
    }

    public void setUmidadeMedia(double umidadeMedia) {
        this.umidadeMedia = umidadeMedia;
    }

    public int getUmidadeMaxima() {
        return umidadeMaxima;
    }

    public void setUmidadeMaxima(int umidadeMaxima) {
        this.umidadeMaxima = umidadeMaxima;
    }

    public boolean isChoveu() {
        return choveu;
    }

    public void setChoveu(boolean choveu) {
        this.choveu = choveu;
    }

}