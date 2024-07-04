package financiamento;

public class Casa extends FinanciamentoImovel {
    private static final double TAXA_SEGURO = 80;
    private final double areaConstruida;
    private final double tamanhoTerreno;

    // Construtor da classe
    public Casa(double valorImovel, int prazoAnos, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    // Métodos getters
    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    // Método para calcular o pagamento mensal do financiamento
    @Override
    public double calcularPagamentoMensal() {
        double prazoMeses = getPrazoAnos() * 12;
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        double pagamentoBase = (getValorImovel() / prazoMeses) * (1 + taxaMensal);
        return pagamentoBase + TAXA_SEGURO;
    }

    // Método para aplicar desconto, lançando exceção se o desconto for maior que os juros
    public void aplicarDesconto(double desconto) throws DescontoMaiorDoQueJurosException {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        double jurosMensal = getValorImovel() * taxaMensal;

        if (desconto > jurosMensal) {
            throw new DescontoMaiorDoQueJurosException("Desconto maior do que os juros mensais.");
        }

        System.out.printf("Desconto de R$ %.2f aplicado com sucesso.%n", desconto);
    }

    // Método para exibir os dados específicos do financiamento
    @Override
    public void exibirDadosFinanciamento() {
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Prazo do Financiamento: %d anos%n", getPrazoAnos());
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Área Construída: %.2f m²%n", areaConstruida);
        System.out.printf("Tamanho do Terreno: %.2f m²%n", tamanhoTerreno);
        System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do Pagamento: R$ %.2f%n", calcularTotalPagamento());
    }
}
