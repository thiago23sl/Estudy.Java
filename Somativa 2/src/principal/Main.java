package principal;

import financiamento.*;
import util.InterfaceUsuario;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<FinanciamentoImovel> financiamentos = new ArrayList<>();

        // Dados fixos de financiamento
        financiamentos.add(new Casa(250000, 18, 3, 150, 200));
        financiamentos.add(new Casa(450000, 5, 6, 450, 1000));
        financiamentos.add(new Apartamento(150000, 8, 10, 2, 5));
        financiamentos.add(new Apartamento(600000, 25, 5, 5, 30));
        financiamentos.add(new Terreno(300000, 15, 35, "residencial"));

        // Solicitar dados do usuário e adicionar aos financiamentos
        FinanciamentoImovel novoFinanciamento = interfaceUsuario.solicitarDadosFinanciamento();
        financiamentos.add(novoFinanciamento);

        // Salvar dados de financiamento em um arquivo de texto
        salvarDadosFinanciamento(financiamentos);

        // Ler dados de financiamento do arquivo de texto
        lerDadosFinanciamento();

        // Serializar o ArrayList de financiamentos
        serializarFinanciamentos(financiamentos);

        // Desserializar o ArrayList de financiamentos
        ArrayList<FinanciamentoImovel> financiamentosDesserializados = desserializarFinanciamentos();
        if (financiamentosDesserializados != null) {
            financiamentos = financiamentosDesserializados;
        }

        // Calcular e exibir os totais
        exibirTotais(financiamentos);
    }

    private static void salvarDadosFinanciamento(ArrayList<FinanciamentoImovel> financiamentos) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("financiamentos.txt"), StandardCharsets.UTF_8))) {
            for (FinanciamentoImovel financiamento : financiamentos) {
                writer.write("Tipo de Imóvel: " + financiamento.getClass().getSimpleName());
                writer.newLine();
                writer.write("Valor do Imóvel: R$ " + financiamento.getValorImovel());
                writer.newLine();
                writer.write("Prazo do Financiamento: " + financiamento.getPrazoAnos() + " anos");
                writer.newLine();
                writer.write("Taxa de Juros Anual: " + financiamento.getTaxaJurosAnual() + "%");
                writer.newLine();

                switch (financiamento) {
                    case Casa casa -> {
                        writer.write("Área Construída: " + casa.getAreaConstruida());
                        writer.newLine();
                        writer.write("Tamanho do Terreno: " + casa.getTamanhoTerreno());
                        writer.newLine();
                    }
                    case Apartamento apartamento -> {
                        writer.write("Número de Vagas na Garagem: " + apartamento.getNumVagasGaragem());
                        writer.newLine();
                        writer.write("Número do Andar: " + apartamento.getNumAndar());
                        writer.newLine();
                    }
                    case Terreno terreno -> {
                        writer.write("Tipo de Zona: " + terreno.getTipoZona());
                        writer.newLine();
                    }
                    default -> {
                    }
                }

                writer.write("Pagamento Mensal: R$ " + financiamento.calcularPagamentoMensal());
                writer.newLine();
                writer.write("Total do Pagamento: R$ " + financiamento.calcularTotalPagamento());
                writer.newLine();
                writer.write("--------------------------------------------");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void lerDadosFinanciamento() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("financiamentos.txt"), StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void serializarFinanciamentos(ArrayList<FinanciamentoImovel> financiamentos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("financiamentos.ser"))) {
            oos.writeObject(financiamentos);
            System.out.println("Dados de financiamentos foram serializados\n");
        } catch (IOException e) {
            System.err.println("Erro ao serializar os dados de financiamentos\n");
        }
    }

    @SuppressWarnings("unchecked")
    private static ArrayList<FinanciamentoImovel> desserializarFinanciamentos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financiamentos.ser"))) {
            return (ArrayList<FinanciamentoImovel>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao desserializar os dados dos financiamentos: " + e.getMessage());
            return null;
        }
    }

    private static void exibirTotais(ArrayList<FinanciamentoImovel> financiamentos) {
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

        System.out.printf("Total de todos os imóveis: R$ %.2f%n", totalValorImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f%n", totalValorFinanciamentos);
    }
}
