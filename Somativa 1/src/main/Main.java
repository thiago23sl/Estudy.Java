package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // ArrayList para armazenar os financiamentos
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Pede ao usuário os dados dos financiamentos e cria os Financiamentos
        for (int i = 0; i < 4; i++) {
            System.out.println("Informações do Financiamento número " + (i + 1));
            double valorImovel = interfaceUsuario.qualValorImovel();
            int prazoFinanciamento = interfaceUsuario.tempoPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.porcentagemTaxaJurosAnual();

            Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
            financiamentos.add(financiamento);
        }

        // Calcula e exibe valor total
        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            System.out.println("=== Financiamento número " + (i + 1) + " ===");
            financiamento.exibirDadosFinanciamento();

            // Exemplo de uso dos getters
            double valorImovel = financiamento.getValorImovel();
            int prazoFinanciamento = financiamento.getPrazoFinanciamento();
            double taxaJurosAnual = financiamento.getTaxaJurosAnual();

            System.out.printf("Valor do Imóvel do financiamento %d: R$ %.2f%n", (i + 1), valorImovel);
            System.out.printf("Prazo do Financiamento do financiamento %d: %d anos%n", (i + 1), prazoFinanciamento);
            System.out.printf("Taxa de Juros Anual do financiamento %d: %.2f%%%n", (i + 1), taxaJurosAnual);

            totalValorImoveis += valorImovel;
            totalValorFinanciamentos += financiamento.calcularTotalPagamento();
        }

        System.out.printf("Valor total de todos os imóveis: R$ %.2f%n", totalValorImoveis);
        System.out.printf("Valor total de todos os financiamentos: R$ %.2f%n", totalValorFinanciamentos);
    }
}
