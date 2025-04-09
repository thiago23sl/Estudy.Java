package financiamento;

import java.io.Serial;

public class Casa extends FinanciamentoImovel {
    @Serial
    private static final long serialVersionUID = 1L;

    private final double areaConstruida;
    private final double tamanhoTerreno;

    public Casa(double valorImovel, int prazoAnos, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double prazoMeses = getPrazoAnos() * 12;
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        return (getValorImovel() / prazoMeses) * (1 + taxaMensal);
    }

    @Override
    public void exibirDadosFinanciamento() {
        System.out.printf("Tipo de Imóvel: Casa%n");
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.printf("Prazo do Financiamento: %d anos%n", getPrazoAnos());
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("Área Construída: %.2f m²%n", getAreaConstruida());
        System.out.printf("Tamanho do Terreno: %.2f m²%n", getTamanhoTerreno());
        System.out.printf("Pagamento Mensal: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do Pagamento: R$ %.2f%n", calcularTotalPagamento());
    }
}
