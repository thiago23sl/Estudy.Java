# Estudy.Java
Aqui estão as funcionalidades do código ,organizadas por classe e suas respectivas responsabilidades:

<h1> Classes de Imóveis </h1>
<h2> Apartamento </h2>
Atributos:

numVagasGaragem: Armazena o número de vagas de garagem disponíveis para o apartamento.
numAndar: Armazena o número do andar em que o apartamento está localizado.
Métodos:

calcularPagamentoMensal(): Calcula o pagamento mensal do financiamento do apartamento usando a fórmula de amortização.
exibirDadosFinanciamento(): Exibe informações detalhadas sobre o financiamento do apartamento, incluindo valor do imóvel, prazo, taxa de juros, número de vagas e andar.
Casa
Atributos:

areaConstruida: Armazena a área construída da casa.
tamanhoTerreno: Armazena o tamanho total do terreno da casa.
Métodos:

calcularPagamentoMensal(): Calcula o pagamento mensal do financiamento da casa com base no valor do imóvel e no prazo.
exibirDadosFinanciamento(): Exibe informações detalhadas sobre o financiamento da casa, incluindo valor do imóvel, prazo, taxa de juros, área construída e tamanho do terreno.
Terreno
Atributos:

tipoZona: Especifica o tipo de zona em que o terreno está localizado (residencial, comercial, etc.).
Métodos:

calcularPagamentoMensal(): Calcula o pagamento mensal do financiamento do terreno usando a fórmula de amortização.
exibirDadosFinanciamento(): Exibe informações detalhadas sobre o financiamento do terreno, incluindo valor do imóvel, prazo, taxa de juros e tipo de zona.

<h1> Classe Abstrata FinanciamentoImovel </h1>
<h2>Funcionalidade: </h2>
Serve como uma classe base para os diferentes tipos de imóveis, garantindo que todos os tipos de imóveis tenham métodos comuns, como calcularPagamentoMensal() e exibirDadosFinanciamento().
O método calcularTotalPagamento() é mantido, permitindo que as subclasses o utilizem para calcular o total a ser pago ao longo do financiamento.

<h1> Exceções</h1>
DescontoMaiorDoQueJurosException
Funcionalidade:
Uma exceção personalizada que pode ser lançada em situações onde um desconto aplicado ao financiamento é maior do que os juros, permitindo um tratamento específico para esse caso.

<h1> Classe Principal (Main)</h1>
<h2> Funcionalidade: </h2>
Cria uma interface de usuário para interagir com o usuário e coletar dados sobre financiamentos de imóveis.
Adiciona financiamentos fixos e permite que o usuário insira novos financiamentos.
Salva os dados de financiamento em um arquivo de texto.
Lê dados de financiamento de um arquivo de texto e exibe no console.
Serializa e desserializa a lista de financiamentos, permitindo que os dados sejam mantidos entre execuções do programa.
Calcula e exibe os totais de todos os financiamentos.

<h1> Classe EntradaDeDados </h1>
<h2> Funcionalidade: </h2>
Facilita a entrada de dados do usuário, com métodos para solicitar informações sobre o imóvel, como valor, prazo, taxa de juros, tipo de imóvel, área construída, tamanho do terreno, número de vagas de garagem e tipo de zona.
Implementa validações para garantir que as entradas do usuário sejam válidas, evitando entradas inválidas.
Funcionalidades Gerais
Persistência de Dados:

O código inclui funcionalidades para salvar e ler dados de financiamentos em arquivos de texto, além de serializar e desserializar objetos, permitindo que os dados sejam mantidos entre execuções do programa.
Cálculo de Pagamentos:

A lógica de cálculo de pagamentos foi refinada para cada tipo de imóvel, garantindo que os cálculos sejam precisos e específicos para as características de cada tipo de financiamento.

<h3> Finalizando </h3>
Essas funcionalidades tornam o sistema de financiamento de imóveis mais robusto, flexível e fácil de usar, permitindo que os usuários insiram dados de forma eficiente e que o sistema trate esses dados de maneira adequada, incluindo a persistência e o cálculo preciso dos pagamentos. Se precisar de mais informações ou detalhes sobre alguma funcionalidade específica, estou à disposição!
