# meu-projeto-poo
Este é um projeto de simulação de financiamento de imóveis, desenvolvido como parte de uma atividade da disciplina de Fundamentos da Programação Orientada a Objetos. 
O sistema permite a criação de financiamentos, garantindo que apenas valores válidos sejam aceitos. 
O objetivo do sistema é calcular e mostrar o valor total de imóveis e financiamentos, além de salvar e ler os dados em arquivos de texto e arquivos serializados, para garantir persistência após a execução do programa.

Criação de Financiamentos:
O sistema permite criar financiamentos de imóveis, com valores válidos e específicos para cada tipo de imóvel (casa ou apartamento).

Cálculos de Totais:
O programa calcula o valor total de todos os imóveis e o valor total de todos os financiamentos, com base nos financiamentos criados.

Persistência de Dados:
Os dados dos financiamentos são salvos em um arquivo de texto, incluindo informações como o valor do imóvel, o valor do financiamento, a taxa de juros e o prazo.
Utiliza serialização para salvar os dados do ArrayList de financiamentos em um arquivo binário, garantindo que os dados possam ser lidos novamente.

Leitura de Dados:
Após salvar os dados, o sistema lê novamente os dados dos arquivos para verificar se as informações foram corretamente salvas.
