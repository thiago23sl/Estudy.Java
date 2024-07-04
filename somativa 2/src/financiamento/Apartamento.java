package financiamento;

public class Apartamento extends FinanciamentoImovel {
    private final int numVagasGaragem;
    private final int numAndar;

    // Construtor da classe
    public Apartamento(double valorImovel, int prazoAnos, double taxaJurosAnual, int numVagasGaragem, int numAndar) {
        super(valorImovel, prazoAnos, taxaJurosAnual);
        this.numVagasGaragem = numVagasGaragem;
        this.numAndar = numAndar;
    }

    // Métodos getters
    public int getNumVagasGaragem() {
        return numVagasGaragem;
    }

    public int getNumAndar() {
        return numAndar;
    }

    // Método para calcular o pagamento mensal do financiamento
    @Override
    public double calcularPagamentoMensal() {
        double prazoMeses = getPrazoAnos() * 12;
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        return (getValorImovel() * Math.pow(1 + taxaMensal, prazoMeses) * taxaMensal) /
                (Math.pow(1 + taxaMensal, prazoMeses) - 1);
    }

    // Método para exibir os dados específicos do financiamento
    @Override
    public void exibirDadosFinanciamento() {
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Prazo do Financiamento: %d anos%n", getPrazoAnos());
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Número de Vagas na Garagem: %d%n", numVagasGaragem);
        System.out.printf("Número do Andar: %d%n", numAndar);
        System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do Pagamento: R$ %.2f%n", calcularTotalPagamento());
    }
}
