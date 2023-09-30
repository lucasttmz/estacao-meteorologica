package modelo;

/**
 * FAZER O MAPEAMENTO DO HIBERNATE (NUNO)
 */

public class Medida {
    
    private Double temperatura;
    private Double humidade;
    private Double precipitacao;

    public Medida() {
        
    }
    
    public Medida(Double temperatura, Double humidade, Double precipitacao) {
        this.temperatura = temperatura;
        this.humidade = humidade;
        this.precipitacao = precipitacao;
    }
    
    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getHumidade() {
        return humidade;
    }

    public void setHumidade(Double humidade) {
        this.humidade = humidade;
    }

    public Double getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(Double precipitacao) {
        this.precipitacao = precipitacao;
    }
    
}