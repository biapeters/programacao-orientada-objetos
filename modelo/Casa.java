package modelo;

import util.AumentoMaiorDoQueJurosException;

import java.io.Serial;
import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

    //Atributos.
    double areaConstruida;

    double areaTerreno;

    //Construtor.
    public Casa(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    //Métodos.
    private void validarJuros(double valorJuros, double valorAcrescimo) throws AumentoMaiorDoQueJurosException {

        if (valorAcrescimo > valorJuros) { // Se o acréscimo for maior que o valor do juros, aparece a exceção.
            throw new AumentoMaiorDoQueJurosException("O acréscimo de R$80 é maior do que os juros.");
        }
    }

    @Override
    public double calcularPagamentoMensal() {

        double valorJuros = this.valorImovel * (this.taxaJurosAnual / 100) / 12; //Juros mensais.
        double valorAcrescimo = 80; //Acréscimo de R$80.

        try { //Verifica se o acréscimo não é maior que os juros.
            validarJuros(valorJuros, valorAcrescimo);
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println(e.getMessage()); //Mostra a mensagem da exceção.
            valorAcrescimo = valorJuros; //Muda o valor do acréscimo pelo valor dos juros.
        }
        double taxaMensal = this.taxaJurosAnual / 12 / 100; //Taxa mensal em decimal.
        int valorMeses = this.prazoFinanciamento * 12; //Prazo em meses
        double pagamentoMensal = (this.valorImovel * taxaMensal *Math.pow(1 + taxaMensal, valorMeses)) / (Math.pow(1 + taxaMensal, valorMeses) - 1);

        return pagamentoMensal + valorAcrescimo;
    }

    @Override
    public double calcularTotalPagamento() { //Calcular total a ser pago durante o financiamento
        return calcularPagamentoMensal() * (this.prazoFinanciamento * 12); //Converte o número de anos para meses.
    }

    @Override
    public void exibirDadosFinanciamento() { //Mostrar informações sobre o imóvel.
        System.out.printf("\nValor da casa: R$ %.2f, área construida: %.2f m², área do terreno: %.2f m²%n", valorImovel, areaConstruida, areaTerreno);
    }

    public String toString() { //Para exibir os dados.
        return "Casa;" + valorImovel + ";" + calcularTotalPagamento() + ";" +
                taxaJurosAnual + ";" + prazoFinanciamento + ";" +
                areaConstruida + ";" + areaTerreno;
    }
}