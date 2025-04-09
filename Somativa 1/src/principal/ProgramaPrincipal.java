package principal;

import financiamento.*;
import util.EntradaDeDados;

import java.util.ArrayList;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        EntradaDeDados entradaDeDados = new EntradaDeDados();
        ArrayList<FinanciamentoImovel> financiamentos = new ArrayList<>();

        //Infomação sobre até no maximo 4 imóveis que serão financiados
        for (int i = 1; i <= 4; i++) {
            System.out.println("Informações do imóvel " + i + ":");
            String tipoImovel = entradaDeDados.solicitarTipoImovel();

            double valorImovel = entradaDeDados.solicitarValorImovel();
            int prazoAnos = entradaDeDados.solicitarPrazoAnos();
            double taxaJurosAnual = entradaDeDados.solicitarTaxaJurosAnual();

            FinanciamentoImovel financiamento;

            switch (tipoImovel) {
                case "casa":
                    double areaConstruida = entradaDeDados.solicitarAreaConstruida();
                    double tamanhoTerreno = entradaDeDados.solicitarTamanhoTerreno();
                    financiamento = new Casa(valorImovel, prazoAnos, taxaJurosAnual, areaConstruida, tamanhoTerreno);
                    break;
                case "apartamento":
                    int numVagasGaragem = entradaDeDados.solicitarNumeroVagasGaragem();
                    int numAndar = entradaDeDados.solicitarNumeroAndar();
                    financiamento = new Apartamento(valorImovel, prazoAnos, taxaJurosAnual, numVagasGaragem, numAndar);
                    break;
                case "terreno":
                    String tipoZona = entradaDeDados.solicitarTipoZona();
                    financiamento = new Terreno(valorImovel, prazoAnos, taxaJurosAnual, tipoZona);
                    break;
                default:
                    System.out.println("Tipo de imóvel não reconhecido.");
                    continue; // Pula para a próxima iteração do loop
            }

            financiamentos.add(financiamento);
        }

        // Os dados de todos os financiamentos
        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        for (int i = 0; i < financiamentos.size(); i++) {
            FinanciamentoImovel financiamento = financiamentos.get(i);
            System.out.println("Dados do Financiamento do Imóvel " + (i + 1) + ":");
            financiamento.exibirDadosFinanciamento();
            System.out.println();

            totalValorImoveis += financiamento.getValorImovel();
            totalValorFinanciamentos += financiamento.calcularTotalPagamento();
        }

        // Valor total de tudo
        System.out.printf("Total de todos os imóveis: R$ %.2f%n", totalValorImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f%n", totalValorFinanciamentos);
    }
}
