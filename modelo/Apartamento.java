package modelo;

import java.io.Serial;
import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    //Atributos
    int numVagasGaragem;

    int numAndar;

    //Construtor
    public Apartamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, int numVagasGarangem, int numAndar) {
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.numVagasGaragem = numVagasGarangem;
        this.numAndar = numAndar;
    }

    //Métodos
    @Override
    public double calcularPagamentoMensal() { //Calcular o pagamento mensal de um financiamento.
        double taxaMensal = this.taxaJurosAnual / 12 / 100; //Taxa mensal em decimal.
        int valorMeses = this.prazoFinanciamento * 12; //Prazo em meses.
        return (this.valorImovel * taxaMensal * Math.pow(1 + taxaMensal, valorMeses)) / (Math.pow(1 + taxaMensal, valorMeses) - 1);
    }

    @Override
    public double calcularTotalPagamento() { //Calcular total a ser pago durante o financiamento.
        return calcularPagamentoMensal() * (this.prazoFinanciamento * 12); // Converte o número de anos para meses.
    }

    @Override
    public void exibirDadosFinanciamento() { //Mostrar informações sobre o imóvel.
        System.out.printf("Valor do apartamento: R$ %.2f, número de garagens: %d, andar: %d%n", valorImovel, numVagasGaragem, numAndar);
    }

    public String toString() { //Para exibir os dados.
        return "Apartamento;" + valorImovel + ";" + calcularTotalPagamento() + ";" +
                taxaJurosAnual + ";" + prazoFinanciamento + ";" +
                numAndar + ";" + numVagasGaragem;
    }

}
