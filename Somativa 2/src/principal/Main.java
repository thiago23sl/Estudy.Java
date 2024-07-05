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

        // Informação sobre até no máximo 4 imóveis que serão financiados
        for (int i = 1; i <= 4; i++) {
            System.out.println("Informações do imóvel " + i + ":");
            String tipoImovel = interfaceUsuario.solicitarTipoImovel();
            double valorImovel = interfaceUsuario.solicitarValorImovel();
            int prazoAnos = interfaceUsuario.solicitarPrazoAnos();
            double taxaJurosAnual = interfaceUsuario.solicitarTaxaJurosAnual();

            FinanciamentoImovel financiamento;

            try {
                switch (tipoImovel.toLowerCase()) {
                    case "casa":
                        double tamanhoTerreno = interfaceUsuario.solicitarTamanhoTerreno();
                        double areaConstruida = interfaceUsuario.solicitarAreaConstruida(tamanhoTerreno);
                        Casa casa = new Casa(valorImovel, prazoAnos, taxaJurosAnual, areaConstruida, tamanhoTerreno);
                        double desconto = 50; // Exemplo de desconto
                        casa.aplicarDesconto(desconto); // Pode lançar a exceção
                        financiamento = casa;
                        break;
                    case "apartamento":
                        int numVagasGaragem = interfaceUsuario.solicitarNumeroVagasGaragem();
                        int numAndar = interfaceUsuario.solicitarNumeroAndar();
                        financiamento = new Apartamento(valorImovel, prazoAnos, taxaJurosAnual, numVagasGaragem, numAndar);
                        break;
                    case "terreno":
                        String tipoZona = interfaceUsuario.solicitarTipoZona();
                        financiamento = new Terreno(valorImovel, prazoAnos, taxaJurosAnual, tipoZona);
                        break;
                    default:
                        System.out.println("Tipo de imóvel não reconhecido.");
                        continue; // Pula para a próxima interação do loop
                }
                financiamentos.add(financiamento);
            } catch (DescontoMaiorDoQueJurosException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

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
            System.out.println("Erro ao salvar dados de financiamento: " + e.getMessage());
        }
    }



    private static void lerDadosFinanciamento() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("financiamentos.txt"), StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler dados de financiamento: " + e.getMessage());
        }
    }

    private static void serializarFinanciamentos(ArrayList<FinanciamentoImovel> financiamentos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("financiamentos.ser"))) {
            oos.writeObject(financiamentos);
        } catch (IOException e) {
            System.out.println("Erro ao serializar financiamentos: " + e.getMessage());
        }
    }

    private static ArrayList<FinanciamentoImovel> desserializarFinanciamentos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financiamentos.ser"))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?> arrayList) {
                if (!arrayList.isEmpty() && arrayList.getFirst() instanceof FinanciamentoImovel) {
                    return (ArrayList<FinanciamentoImovel>) arrayList;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao desserializar financiamentos: " + e.getMessage());
        }
        return null;
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
