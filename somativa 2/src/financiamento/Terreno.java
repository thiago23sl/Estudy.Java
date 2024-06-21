package financiamento;

public class Terreno extends FinanciamentoImovel {
    private static final double ACRESCIMO_INADIMPLENCIA = 1.02;
    private final String tipoZona;

    public Terreno(double valorImovel, int prazoAnos, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoAnos, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double prazoMeses = getPrazoAnos() * 12;
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        double pagamentoBase = (getValorImovel() / prazoMeses) * (1 + taxaMensal);
        return pagamentoBase * ACRESCIMO_INADIMPLENCIA;
    }

    @Override
    public void exibirDadosFinanciamento() {
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Prazo do Financiamento: %d anos%n", getPrazoAnos());
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Tipo de Zona: %s%n", tipoZona);
        System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do Pagamento: R$ %.2f%n", calcularTotalPagamento());
    }
}
