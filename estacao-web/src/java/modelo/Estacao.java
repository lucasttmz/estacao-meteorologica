package modelo;

/**
 * Estacao.
 * 
 * Interface para a leitura das medidas.
 * Lê temperatura, humidade e precipitação.
 */
public interface Estacao {
    public MedidaAtual lerMedidaAtual();
    
}