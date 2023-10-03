package modelo;

import java.time.LocalDateTime;

/**
 * Representa a medida mais recente que está armazenada no banco de dados.
 * 
 * FAZER O MAPEAMENTO DO HIBERNATE (NUNO)
 */

public class MedidaAtual {
    private LocalDateTime data;
    private Integer temperatura;
    private Integer humidade;
    private Integer precipitacao;

    public MedidaAtual() {
        
    }
    
    public MedidaAtual(LocalDateTime data, Integer temperatura, Integer humidade, Integer precipitacao) {
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
    
    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getHumidade() {
        return humidade;
    }

    public void setHumidade(Integer humidade) {
        this.humidade = humidade;
    }

    public Integer getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(Integer precipitacao) {
        this.precipitacao = precipitacao;
    }
    
}