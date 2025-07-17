# Simulação de Financiamento de Imóveis (Java POO)

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.java.com/)
[![POO](https://img.shields.io/badge/Paradigma-POO-blue.svg)]()
[![Status](https://img.shields.io/badge/Status-Concluído-green.svg)]()

## 📝 Descrição do Projeto

Este projeto é uma simulação de um sistema de financiamento de imóveis, desenvolvido em Java. Ele foi criado como parte de uma atividade acadêmica da disciplina de **Fundamentos da Programação Orientada a Objetos (POO)**.

O sistema modela diferentes tipos de imóveis (Casa, Apartamento, Terreno) através de herança e polimorfismo, calcula os valores de financiamento e demonstra a persistência de dados utilizando tanto a escrita em arquivos de texto simples quanto a serialização de objetos.

## ✨ Funcionalidades Principais

* **Modelagem Orientada a Objetos:** Implementação de uma hierarquia de classes (`Financiamento`, `Casa`, `Apartamento`, `Terreno`) para representar os diferentes tipos de financiamento e suas características específicas.
* **Cálculo de Financiamentos:** Lógica para calcular o pagamento mensal e o valor total do financiamento para cada tipo de imóvel, com variações específicas (e.g., acréscimo para casas, juros diferenciados para terrenos).
* **Validação de Entradas:** A interface de usuário (`InterfaceUsuario`) garante que os dados inseridos para o valor do imóvel, prazo e taxa de juros sejam válidos (positivos e numéricos).
* **Tratamento de Exceções Personalizado:** Demonstração do uso de exceções customizadas (`AumentoMaiorDoQueJurosException`) para lidar com regras de negócio específicas, como um acréscimo de financiamento sendo maior que os juros.
* **Persistência de Dados em Arquivo de Texto:** Os detalhes dos financiamentos são gravados em um arquivo `financiamentos.txt` para consulta posterior.
* **Serialização de Objetos:** A lista completa de objetos `Financiamento` é serializada e salva em um arquivo binário (`financiamentos_serializados.dat`), permitindo a reconstituição dos objetos em execuções futuras do programa.
* **Relatórios:** O sistema calcula e exibe o valor total de todos os imóveis e o valor total de todos os financiamentos cadastrados.

## 📁 Estrutura do Projeto

O projeto está organizado nos seguintes diretórios e arquivos principais:

* `src/`: Contém todo o código-fonte Java.
    * `src/Main/`: Inclui a classe `Main.java`, o ponto de entrada do programa.
    * `src/modelo/`: Contém as classes que representam os modelos de dados e a hierarquia de financiamentos (e.g., `Financiamento.java`, `Casa.java`, `Apartamento.java`, `Terreno.java`, `Zonas.java`).
    * `src/util/`: Armazena classes utilitárias, como `InterfaceUsuario.java` para interação com o console e `AumentoMaiorDoQueJurosException.java` para tratamento de exceções customizadas.
* `financiamentos.txt`: Arquivo de texto gerado para persistir os dados dos financiamentos.
* `financiamentos_serializados.dat`: Arquivo binário gerado pela serialização de objetos.
* `README.md`: Este arquivo, que fornece informações sobre o projeto.

## 🚀 Como Executar o Projeto

Para compilar e executar este projeto em sua máquina local, você precisará ter o Java Development Kit (JDK) instalado.

1.  **Pré-requisitos:**
    * [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/downloads/) ou superior.

2.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/biapeters/programacao-orientada-objetos.git](https://github.com/biapeters/programacao-orientada-objetos.git)
    ```

3.  **Navegue até o diretório do projeto:**
    ```bash
    cd programacao-orientada-objetos
    ```

4.  **Compile os arquivos `.java`:**
    ```bash
    javac -d out src/Main/*.java src/modelo/*.java src/util/*.java
    ```
    *(Este comando compilará todos os arquivos `.java` dentro das pastas `Main`, `modelo` e `util` e colocará os `.class` gerados na pasta `out`.)*

5.  **Execute o programa principal:**
    ```bash
    java -cp out Main.Main
    ```

## 🛠️ Tecnologias Utilizadas

* **Java:** Linguagem de programação.
* **Programação Orientada a Objetos (POO):** Classes, objetos, herança, polimorfismo, encapsulamento.
* **Manipulação de Arquivos (I/O):** `FileWriter`, `FileReader`, `FileOutputStream`, `FileInputStream`, `ObjectOutputStream`, `ObjectInputStream`.
* **Tratamento de Exceções:** `try-catch-finally`, exceções customizadas.

## 🧠 Aprendizados e Desafios

Este projeto foi crucial para o aprofundamento em diversos conceitos de programação e design de software:

* **Fundamentos de POO na prática:** Apliquei herança e polimorfismo para criar uma estrutura flexível de financiamentos, onde cada tipo de imóvel calcula o pagamento de forma específica, mas todos compartilham uma interface comum.
* **Persistência de Dados Robusta:** Explorei duas abordagens distintas para salvar e carregar dados: a escrita/leitura em arquivos de texto para representações simples e a serialização para manter a integridade dos objetos Java.
* **Tratamento de Erros e Exceções:** Compreendi a importância de prever e gerenciar erros de entrada do usuário e condições inesperadas, como a exceção personalizada, tornando o sistema mais robusto e amigável.
* **Modularização do Código:** A divisão do código em diferentes pacotes (`Main`, `modelo`, `util`) e classes demonstrou a importância da organização para a manutenibilidade e escalabilidade do projeto.

O principal desafio foi interligar os conceitos de POO com a persistência de dados, garantindo que os objetos fossem corretamente salvos e recuperados, especialmente a parte de serialização, que exige atenção às interfaces `Serializable`.

## 🤝 Contribuições

Contribuições são bem-vindas! Se você tiver sugestões, melhorias ou encontrar algum bug, sinta-se à vontade para abrir uma issue ou enviar um pull request.

---

Made with ❤️ by Bianca Peters
