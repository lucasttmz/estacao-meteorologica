package modelo;

import java.time.LocalDate;

/**
 * Representa a média das medidas de um certo dia.
 * 
 * FAZER O MAPEAMENTO DO HIBERNATE (NUNO)
 */
public class MedidaDiaria {
    private LocalDate data;
    private Double temperaturaMinima;
    private Double temperaturaMedia;
    private Double temperaturaMaxima;
    private Double umidadeMinima;
    private Double umidadeMedia;
    private Double umidadeMaxima;
    private Boolean choveu;

    
    public MedidaDiaria() {
        
    }

    public MedidaDiaria(LocalDate data, Double temperaturaMinima, Double temperaturaMedia, Double temperaturaMaxima, Double umidadeMinima, Double umidadeMedia, Double umidadeMaxima, Boolean choveu) {
        this.data = data;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMedia = temperaturaMedia;
        this.temperaturaMaxima = temperaturaMaxima;
        this.umidadeMinima = umidadeMinima;
        this.umidadeMedia = umidadeMedia;
        this.umidadeMaxima = umidadeMaxima;
        this.choveu = choveu;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(Double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public Double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(Double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public Double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(Double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Double getUmidadeMinima() {
        return umidadeMinima;
    }

    public void setUmidadeMinima(Double umidadeMinima) {
        this.umidadeMinima = umidadeMinima;
    }

    public Double getUmidadeMedia() {
        return umidadeMedia;
    }

    public void setUmidadeMedia(Double umidadeMedia) {
        this.umidadeMedia = umidadeMedia;
    }

    public Double getUmidadeMaxima() {
        return umidadeMaxima;
    }

    public void setUmidadeMaxima(Double umidadeMaxima) {
        this.umidadeMaxima = umidadeMaxima;
    }

    public Boolean getChoveu() {
        return choveu;
    }

    public void setChoveu(Boolean choveu) {
        this.choveu = choveu;
    }
    
}