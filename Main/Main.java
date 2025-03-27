package Main;

import modelo.*;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Lista para armazenar os financiamentos.
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        //Adiciona 2 financiamentos de casa.
        listaDeFinanciamentos.add(new Casa(300000, 20, 8, 60, 80));
        listaDeFinanciamentos.add(new Casa(450000, 15, 4, 100,250));

        //Adiciona 2 financiamentos de apartamento.
        listaDeFinanciamentos.add(new Apartamento(500000, 25, 10, 2, 10));
        listaDeFinanciamentos.add(new Apartamento(350000, 10, 5, 1, 3));

        //Adiciona 1 financiamento de terreno.
        listaDeFinanciamentos.add(new Terreno(250000, 12, 5, Zonas.Comercial));

        // Escrita
        FileWriter escritor = null;

        try {
            escritor = new FileWriter("financiamentos.txt");

            for(Financiamento financiamento : listaDeFinanciamentos) {
                String linha = financiamento.toString();
                for (int i = 0; i < linha.length(); i++) {
                    escritor.write(linha.charAt(i));
                }
                escritor.write("\n");
            }
        } catch (IOException e ) {
            e.printStackTrace();
        } finally {
            try {
                if (escritor != null) escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Leitura
        FileReader leitorArquivos;
        try {
             leitorArquivos = new FileReader("financiamentos.txt");
             int contadorLeitura;
             StringBuilder linha = new StringBuilder();

             while ((contadorLeitura = leitorArquivos.read()) != -1) {
                 char caractere = (char) contadorLeitura;
                 if (caractere == '\n') {
                     System.out.println(linha);
                     linha.setLength(0);
                 } else {
                     linha.append(caractere);
                 }
             }
             leitorArquivos.close();

        } catch (IOException e ) {
            e.printStackTrace();
        }

        //Serialização.
        try (ObjectOutputStream escritor2 = new ObjectOutputStream(new FileOutputStream("financiamentos_serializados.dat"))) {
            escritor2.writeObject(listaDeFinanciamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Leitura Serialização.
        try (ObjectInputStream leitor = new ObjectInputStream(new FileInputStream("financiamentos_serializados.dat"))) {
            List<Financiamento> financiamentosLidos = (List<Financiamento>) leitor.readObject();

            for (Financiamento financiamento : financiamentosLidos) {
                financiamento.exibirDadosFinanciamento();
                System.out.printf("Valor do imóvel: R$ %.2f e Valor do financiamento: R$ %.2f%n\n", financiamento.getValorImovel(), financiamento.calcularTotalPagamento());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Variável para calcular o total dos imóveis e financiamentos.
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        //Exibir os dados e fazer os calculos.
        for (Financiamento financiamento : listaDeFinanciamentos){
            financiamento.exibirDadosFinanciamento();

            System.out.printf("Valor do imóvel: R$ %.2f e Valor do financiamento: R$ %.2f%n\n", financiamento.getValorImovel() ,financiamento.calcularTotalPagamento());

            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.calcularTotalPagamento();
        }

        //Exibir o total dos imóveis e financiamentos.
        System.out.printf("Total de todos os imóveis: R$ %.2f\nTotal de todos os financiamentos: R$ %.2f%n", totalImoveis, totalFinanciamentos);

        //Nova instância da classe interfaceUsuario.
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        //Coleta dados do usuário.
        System.out.println("\nInsira os dados de um novo financiamento. ");
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamentoEmAnos = interfaceUsuario.pedirPrazoFinanciamenmto();
        double taxaJuros = interfaceUsuario.pedirTaxaJuros();

        //Pede o tipo de zona.
        System.out.println("Informe o tipo de zona. ");
        String zonaEscolhida = interfaceUsuario.pedirTipoZona(); //Método para coletar o tipo de zona.
        Zonas tipoDeZona = Zonas.valueOf(zonaEscolhida); //Converte a String para o enum.

        //Financiamento com os dados inseridos pelo usuário.
        Terreno novoTerreno = new Terreno(valorImovel, prazoFinanciamentoEmAnos, taxaJuros, tipoDeZona);

        //Adicionar a lista.
        listaDeFinanciamentos.add(novoTerreno);

        novoTerreno.exibirDadosFinanciamento();
        System.out.printf("Valor do financiamento: R$ %.2f%n", novoTerreno.calcularTotalPagamento());


    }
}
