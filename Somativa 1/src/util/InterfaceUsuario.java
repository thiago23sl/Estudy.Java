package util;

import financiamento.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private final Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public FinanciamentoImovel solicitarDadosFinanciamento() {
        System.out.println("Digite o tipo de imóvel (casa, apartamento, terreno): ");
        String tipoImovel = scanner.next().toLowerCase();

        double valorImovel = solicitarValorImovel();
        int prazoAnos = solicitarPrazoAnos();
        double taxaJurosAnual = solicitarTaxaJurosAnual();

        return switch (tipoImovel) {
            case "casa" -> {
                double areaConstruida = solicitarAreaConstruida();
                double tamanhoTerreno = solicitarTamanhoTerreno(areaConstruida);
                yield new Casa(valorImovel, prazoAnos, taxaJurosAnual, areaConstruida, tamanhoTerreno);
            }
            case "apartamento" -> {
                int numVagasGaragem = solicitarNumVagasGaragem();
                int numAndar = solicitarNumAndar();
                yield new Apartamento(valorImovel, prazoAnos, taxaJurosAnual, numVagasGaragem, numAndar);
            }
            case "terreno" -> {
                String tipoZona = solicitarTipoZona();
                yield new Terreno(valorImovel, prazoAnos, taxaJurosAnual, tipoZona);
            }
            default -> throw new IllegalArgumentException("Tipo de imóvel inválido.");
        };
    }

    public double solicitarValorImovel() {
        double valor = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o valor do imóvel (mínimo R$ 50.000): ");
                valor = scanner.nextDouble();
                if (valor < 50000) {
                    System.out.println("Valor inválido. Tente novamente.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return valor;
    }

    public int solicitarPrazoAnos() {
        int prazo = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o prazo do financiamento (entre 1 e 35 anos): ");
                prazo = scanner.nextInt();
                if (prazo < 1 || prazo > 35) {
                    System.out.println("Prazo inválido. Tente novamente.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return prazo;
    }

    public double solicitarTaxaJurosAnual() {
        double taxa = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite a taxa de juros anual (entre 0.1% e 12%): ");
                taxa = scanner.nextDouble();
                if (taxa < 0.1 || taxa > 12) {
                    System.out.println("Taxa inválida. Tente novamente.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return taxa;
    }

    public double solicitarAreaConstruida() {
        double area = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite a área construída: ");
                area = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return area;
    }

    public double solicitarTamanhoTerreno(double areaConstruida) {
        double tamanho = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o tamanho do terreno: ");
                tamanho = scanner.nextDouble();
                if (tamanho < areaConstruida) {
                    System.out.println("O tamanho do terreno não pode ser menor que a área construída. Tente novamente.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return tamanho;
    }

    public int solicitarNumVagasGaragem() {
        int numVagas = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o número de vagas na garagem: ");
                numVagas = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return numVagas;
    }

    public int solicitarNumAndar() {
        int numAndar = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o número do andar: ");
                numAndar = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return numAndar;
    }

    public String solicitarTipoZona() {
        String tipoZona;
        do {
            System.out.print("Digite o tipo de zona (residencial, comercial): ");
            tipoZona = scanner.next().toLowerCase();
            if (!tipoZona.equals("residencial") && !tipoZona.equals("comercial")) {
                System.out.println("Tipo de zona inválido. Tente novamente.");
            }
        } while (!tipoZona.equals("residencial") && !tipoZona.equals("comercial"));
        return tipoZona;
    }
}
