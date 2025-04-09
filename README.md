# 🏠 Sistema de Financiamento de Imóveis

Sistema completo desenvolvido em Java para simular financiamentos de diferentes tipos de imóveis (apartamentos, casas e terrenos), com foco em cálculo de pagamento, entrada de dados validada e persistência das informações.

---

## 🏗️ Arquitetura do Projeto

O projeto é estruturado em diversas classes, cada uma com responsabilidades bem definidas, utilizando princípios de orientação a objetos como herança, polimorfismo e abstração.

---

## 🧱 Classes de Imóveis

### 🏢 Apartamento

**Atributos:**
- `numVagasGaragem`: Número de vagas na garagem.
- `numAndar`: Andar em que o apartamento está localizado.

**Métodos:**
- `calcularPagamentoMensal()`: Calcula o pagamento mensal do financiamento do apartamento usando a fórmula de amortização.
- `exibirDadosFinanciamento()`: Exibe os detalhes do financiamento, incluindo valor, prazo, juros, vagas de garagem e andar.

---

### 🏡 Casa

**Atributos:**
- `areaConstruida`: Área construída da casa.
- `tamanhoTerreno`: Tamanho total do terreno.

**Métodos:**
- `calcularPagamentoMensal()`: Calcula o pagamento mensal com base no valor do imóvel e no prazo.
- `exibirDadosFinanciamento()`: Mostra informações do financiamento da casa, como valor, prazo, juros, área construída e tamanho do terreno.

---

### 🌳 Terreno

**Atributos:**
- `tipoZona`: Tipo de zona onde o terreno está localizado (residencial, comercial, etc.).

**Métodos:**
- `calcularPagamentoMensal()`: Calcula o pagamento mensal considerando o tipo de terreno.
- `exibirDadosFinanciamento()`: Exibe os dados do financiamento, incluindo valor, prazo, juros e zona.

---

## 🧩 Classe Abstrata: `FinanciamentoImovel`

**Responsabilidade:**
- Serve como base para todas as classes de imóveis.
- Define métodos comuns: `calcularPagamentoMensal()` e `exibirDadosFinanciamento()`.
- Possui método utilitário: `calcularTotalPagamento()`, que retorna o valor total pago durante o financiamento.

---

## ⚠️ Exceção Personalizada

### `DescontoMaiorDoQueJurosException`

**Finalidade:**
- Lançada quando um desconto informado é maior do que a taxa de juros aplicada, permitindo tratamento específico para essa inconsistência.

---

## 🧵 Classe Principal: `Main`

**Funcionalidades:**
- Interface interativa com o usuário via terminal.
- Adiciona financiamentos fixos e permite o cadastro de novos financiamentos.
- Salva os financiamentos em arquivo `.txt`.
- Lê e exibe dados de financiamentos salvos.
- Serializa e desserializa a lista de financiamentos (`.ser`), garantindo persistência entre execuções.
- Exibe totais de pagamento de todos os financiamentos cadastrados.

---

## 🎛️ Classe `EntradaDeDados`

**Responsabilidades:**
- Facilita a entrada de dados de forma estruturada e validada.
- Permite a coleta de:
  - Valor do imóvel
  - Prazo do financiamento
  - Taxa de juros
  - Tipo de imóvel
  - Número de vagas
  - Tipo de zona
  - Área construída
  - Tamanho do terreno
- Valida entradas do usuário para evitar dados inconsistentes ou inválidos.

---

## 💾 Funcionalidades Gerais

### 🧮 Cálculo de Pagamentos

- Cada tipo de imóvel possui sua própria lógica para cálculo de parcelas mensais, adaptada às suas características específicas.
- O método de amortização é aplicado quando necessário, promovendo precisão nas simulações.

### 🗃️ Persistência de Dados

- Suporte a leitura e escrita em arquivos `.txt`.
- Suporte à serialização e desserialização de objetos, permitindo que os dados sejam preservados mesmo após o encerramento do programa.

---

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java
- **Paradigma:** Orientação a Objetos
- **I/O:** Manipulação de arquivos (texto e binário)
- **Tratamento de Erros:** Exceções personalizadas
- **Persistência:** Serialização de objetos

---
