package modelo;

import java.time.LocalDateTime;

/**
 * Representa a medida mais recente que está armazenada no banco de dados.
 * 
 * FAZER O MAPEAMENTO DO HIBERNATE (NUNO)
 */

public class MedidaAtual {
    private LocalDateTime data;
    private Double temperatura;
    private Double humidade;
    private Integer precipitacao;

    public MedidaAtual() {
        
    }
    
    public MedidaAtual(LocalDateTime data, Double temperatura, Double humidade, Integer precipitacao) {
        this.data = data;
        this.temperatura = temperatura;
        this.humidade = humidade;
        this.precipitacao = precipitacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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

    public Integer getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(Integer precipitacao) {
        this.precipitacao = precipitacao;
    }
    
}