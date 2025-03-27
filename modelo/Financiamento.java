package modelo;

import java.io.Serial;
import java.io.Serializable;

public abstract class Financiamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //region Atributos protected
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
    //endregion

    //region Getters públicos
    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }
    //endregion

    //region Construtor público
    public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual){
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this. taxaJurosAnual = taxaJurosAnual;
    }
    //endregion

    //region Métodos públicos
    public abstract double calcularPagamentoMensal(); // Método para calcular o pagamento mensal do financiamento.

    public abstract double calcularTotalPagamento(); // Método para calcular o pagamento total do financiamento.

    public void exibirDadosFinanciamento() {} // Método para exibir os dados do financiamento.

    public abstract String toString(); // Para exibir os dados.
    //endregion
}
