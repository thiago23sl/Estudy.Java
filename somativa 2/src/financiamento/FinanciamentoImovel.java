package financiamento;

public abstract class FinanciamentoImovel {
    private final double valorImovel;
    private final int prazoAnos;
    private final double taxaJurosAnual;

    // Construtor da classe
    public FinanciamentoImovel(double valorImovel, int prazoAnos, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoAnos = prazoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoAnos() {
        return prazoAnos;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Método abstrato para calcular o pagamento mensal do financiamento
    public abstract double calcularPagamentoMensal();

    // Método para calcular o total de pagamento ao longo do financiamento
    public double calcularTotalPagamento() {
        double pagamentoMensal = calcularPagamentoMensal();
        return pagamentoMensal * prazoAnos * 12; // Multiplica pelo número total de meses do prazo
    }

    // Método abstrato para exibir os dados específicos do financiamento
    public abstract void exibirDadosFinanciamento();
}
