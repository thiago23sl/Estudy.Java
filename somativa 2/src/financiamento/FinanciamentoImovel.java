package financiamento;

import java.io.Serial;
import java.io.Serializable;

public abstract class FinanciamentoImovel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    protected double valorImovel;
    protected int prazoAnos;
    protected double taxaJurosAnual;

    protected FinanciamentoImovel(double valorImovel, int prazoAnos, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoAnos = prazoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoAnos() {
        return prazoAnos;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento() {
        double pagamentoMensal = calcularPagamentoMensal();
        return pagamentoMensal * prazoAnos * 12;
    }

    public abstract void exibirDadosFinanciamento();
}
