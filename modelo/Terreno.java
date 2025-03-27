package modelo;

import java.io.Serial;
import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 4L;

    Zonas tipoDeZona;

    //Construtor.
    public Terreno(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, Zonas tipoDeZona) {
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.tipoDeZona = tipoDeZona;
    }

    //Métodos.
    @Override
    public double calcularPagamentoMensal() { //Calcular o pagamento mensal de um financiamento.
        return (this. valorImovel / (prazoFinanciamento * 12)) * 1.02; // Acréscimo de 2%
    }

    public double calcularTotalPagamento() { //Calcular total a ser pago durante o financiamento.
        return calcularPagamentoMensal() * (this.prazoFinanciamento * 12); //Converte o número de anos para meses.
    }

    @Override
    public void exibirDadosFinanciamento() { //Mostrar informações sobre o imóvel.
        System.out.printf("Valor do terreno: R$ %.2f, tipo de zona: %s%n", valorImovel, tipoDeZona);
    }

    public String toString() { //Para exibir os dados.
        return "Terreno;" + valorImovel + ";" + calcularTotalPagamento() + ";" +
                taxaJurosAnual + ";" + prazoFinanciamento + ";" +
                tipoDeZona;
    }
}
