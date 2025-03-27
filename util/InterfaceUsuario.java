package util;

import modelo.Zonas;

import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner = new Scanner(System.in);

    //region Métodos públicos
    public double pedirValorImovel() {

        while (true) { // Utiliza um loop para que o usuario insira os dados até que o valor seja válido.
            try {
                System.out.println("Digite o valor do imóvel: ");
                double valorImovel = Double.parseDouble(scanner.nextLine()); // Converte o valor.
                if (valorImovel > 0) {
                    return valorImovel; // Retorna o valor se for válido.
                } else { // Se não, pede para o usuário tentar novamente, inserindo um valor válido.
                    System.out.println("O valor precisa ser positivo. Digite novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }

        }
    }

        public int pedirPrazoFinanciamenmto () {

            while (true) { //Utiliza um loop para que o usuario insira os dados até que o valor seja válido.
                try {
                    System.out.println("Digite o prazo do financiamento em anos: ");
                    int prazoFinanciamento = Integer.parseInt(scanner.nextLine());
                    if (prazoFinanciamento > 0) { //Aceita valores maiores que zero.
                        return prazoFinanciamento; //Retorna o valor se for válido.
                    } else { //Se não, pede para o usuário tentar novamente, inserindo um valor válido.
                        System.out.println("O prazo do financiamento deve conter um valor positivo. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Digite um número válido.");
                }
            }
        }

        public double pedirTaxaJuros () {

            while (true) { //Utiliza um loop para que o usuario insira os dados até que o valor seja válido.
                try {
                    System.out.println("Digite a taxa de juros anual: ");
                    double taxaJuros = Double.parseDouble(scanner.nextLine());
                    if (taxaJuros > 0) { //Aceita valores maiores que zero.
                        return taxaJuros; //Retorna o valor se for válido.
                    } else { //Se não, pede para o usuário tentar novamente, inserindo um valor válido.
                        System.out.println("A taxa de juros anual deve conter um valor positivo. Digite novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Digite um número válido.");
                }
            }
        }

        public String pedirTipoZona() {
            Scanner scanner = new Scanner((System.in));

            while (true) {
                System.out.print("Escolha uma zona (Residencial, Comercial, Industrial, Escritorio): ");
                String zona = scanner.nextLine().trim();
                //Coloca a primeira letra em maiúscula e o restante em minúsculo.
                String zonaCorreta = zona.substring(0, 1).toUpperCase() + zona.substring(1).toLowerCase();
                try { //Verifica se a entrada é válida
                    Zonas.valueOf(zonaCorreta);
                    return zonaCorreta; //Retorna a entrada se for válida
                } catch (IllegalArgumentException e) { //Se o valor não for válido, exibe uma mensagem de erro
                    System.out.println("Opção inválida. Tente Novamente.");
                }
            }
        }
    }

    //endregion