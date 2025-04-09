package financiamento;

import java.io.Serial;

public class Terreno extends FinanciamentoImovel {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String tipoZona;

    public Terreno(double valorImovel, int prazoAnos, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoAnos, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double prazoMeses = getPrazoAnos() * 12;
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        return (getValorImovel() * Math.pow(1 + taxaMensal, prazoMeses) * taxaMensal) /
                (Math.pow(1 + taxaMensal, prazoMeses) - 1);
    }

    @Override
    public void exibirDadosFinanciamento() {
        System.out.printf("Tipo de Imóvel: Terreno%n");
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Prazo do Financiamento: %d anos%n", getPrazoAnos());
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Tipo de Zona: %s%n", getTipoZona());
        System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do Pagamento: R$ %.2f%n", calcularTotalPagamento());
    }
}
