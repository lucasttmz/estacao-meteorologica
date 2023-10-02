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
    private Double humidadeMinima;
    private Double humidadeMedia;
    private Double humidadeMaxima;
    private Boolean choveu;

    
    public MedidaDiaria() {
        
    }

    public MedidaDiaria(LocalDate data, Double temperaturaMinima, Double temperaturaMedia, Double temperaturaMaxima, Double humidadeMinima, Double humidadeMedia, Double humidadeMaxima, Boolean choveu) {
        this.data = data;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMedia = temperaturaMedia;
        this.temperaturaMaxima = temperaturaMaxima;
        this.humidadeMinima = humidadeMinima;
        this.humidadeMedia = humidadeMedia;
        this.humidadeMaxima = humidadeMaxima;
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

    public Double getHumidadeMinima() {
        return humidadeMinima;
    }

    public void setHumidadeMinima(Double humidadeMinima) {
        this.humidadeMinima = humidadeMinima;
    }

    public Double getHumidadeMedia() {
        return humidadeMedia;
    }

    public void setHumidadeMedia(Double humidadeMedia) {
        this.humidadeMedia = humidadeMedia;
    }

    public Double getHumidadeMaxima() {
        return humidadeMaxima;
    }

    public void setHumidadeMaxima(Double humidadeMaxima) {
        this.humidadeMaxima = humidadeMaxima;
    }

    public Boolean getChoveu() {
        return choveu;
    }

    public void setChoveu(Boolean choveu) {
        this.choveu = choveu;
    }
    
}