package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private final Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public double qualValorImovel() {
        double valor;
        do {
            System.out.print("Digite o valor do imóvel (positivo): ");
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Valor inválido. Digite novamente.");
            }
        } while (valor <= 0);
        return valor;
    }

    public int tempoPrazoFinanciamento() {
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento (em anos, positivo): ");
            prazo = scanner.nextInt();
            if (prazo <= 0) {
                System.out.println("Prazo inválido. Digite novamente.");
            }
        } while (prazo <= 0);
        return prazo;
    }

    public double porcentagemTaxaJurosAnual() {
        double taxa;
        do {
            System.out.print("Digite a taxa de juros anual (em %, positivo): ");
            taxa = scanner.nextDouble();
            if (taxa <= 0) {
                System.out.println("Taxa inválida. Digite novamente.");
            }
        } while (taxa <= 0);
        return taxa;
    }
}
