package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private final Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
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

    public String solicitarTipoImovel() {
        String tipoImovel;
        do {
            System.out.print("Escolha o tipo de imóvel que deseja financiar (casa, apartamento, terreno): ");
            tipoImovel = scanner.next().toLowerCase();
            if (!tipoImovel.equals("casa") && !tipoImovel.equals("apartamento") && !tipoImovel.equals("terreno")) {
                System.out.println("Tipo de imóvel inválido. Tente novamente.");
            }
        } while (!tipoImovel.equals("casa") && !tipoImovel.equals("apartamento") && !tipoImovel.equals("terreno"));
        return tipoImovel;
    }

    public double solicitarAreaConstruida(double tamanhoTerreno) {
        double area = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite a área construída do imóvel (m²): ");
                area = scanner.nextDouble();
                if (area <= 0 || area > tamanhoTerreno) {
                    System.out.println("Área inválida. Deve ser maior que 0 e menor ou igual ao tamanho do terreno. Tente novamente.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return area;
    }

    public double solicitarTamanhoTerreno() {
        double tamanho = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o tamanho do terreno (mínimo de 150m²): ");
                tamanho = scanner.nextDouble();
                if (tamanho < 150) {
                    System.out.println("Tamanho inválido. Deve ser maior que 150m². Tente novamente.");
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

    public int solicitarNumeroVagasGaragem() {
        int vagas = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o número de vagas de garagem (entre 0 e 5): ");
                vagas = scanner.nextInt();
                if (vagas < 0 || vagas > 5) {
                    System.out.println("Número de vagas inválido. Deve ser entre 0 e 5. Tente novamente.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return vagas;
    }

    public int solicitarNumeroAndar() {
        int andar = 0;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                System.out.print("Digite o número do andar: ");
                andar = scanner.nextInt();
                if (andar < 0) {
                    System.out.println("Número de andar inválido. Deve ser maior ou igual a 0. Tente novamente.");
                    entradaValida = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                entradaValida = false;
                scanner.next(); // limpa a entrada inválida
            }
        } while (!entradaValida);
        return andar;
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
