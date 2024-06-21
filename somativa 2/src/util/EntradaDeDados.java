package util;

import java.util.Scanner;

public class EntradaDeDados {
    private Scanner scanner;

    public EntradaDeDados() {
        this.scanner = new Scanner(System.in);
    }
    //solicitação do valor do imóvel
    public double solicitarValorImovel() {
        double valor;
        do {
            System.out.print("Digite o valor do imóvel (positivo): ");
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Valor inválido. Tente novamente.");
            }
        } while (valor <= 0);
        return valor;
    }
    //solicitação do prazo do financiamento do imóvel
    public int solicitarPrazoAnos() {
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento (em anos, positivo): ");
            prazo = scanner.nextInt();
            if (prazo <= 0) {
                System.out.println("Prazo inválido. Tente novamente.");
            }
        } while (prazo <= 0);
        return prazo;
    }
    //solicitação do valor do juros anual do imóvel
    public double solicitarTaxaJurosAnual() {
        double taxa;
        do {
            System.out.print("Digite a taxa de juros anual (em %, positivo): ");
            taxa = scanner.nextDouble();
            if (taxa <= 0) {
                System.out.println("Taxa inválida. Tente novamente.");
            }
        } while (taxa <= 0);
        return taxa;
    }
    //solicitação do tipo (casa,apartamento ou terrano) do imóvel
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
    //se por acaso for uma casa, ele pergunta qual a area do imóvel e qual a area que vai ser construida

    public double solicitarAreaConstruida() {
        double area;
        do {
            System.out.print("Digite a área construída do imóvel (m²): ");
            area = scanner.nextDouble();
            if (area <= 0) {
                System.out.println("Área inválida. Tente novamente.");
            }
        } while (area <= 0);
        return area;
    }

    public double solicitarTamanhoTerreno() {
        double terreno;
        do {
            System.out.print("Digite o tamanho do terreno do imóvel (m²): ");
            terreno = scanner.nextDouble();
            if (terreno <= 0) {
                System.out.println("Tamanho do terreno inválido. Tente novamente.");
            }
        } while (terreno <= 0);
        return terreno;
    }
    //apartamento ele pergunta em qual andar e quantas vagas de garagem tem

    public int solicitarNumeroVagasGaragem() {
        int vagas;
        do {
            System.out.print("Digite o número de vagas na garagem do apartamento: ");
            vagas = scanner.nextInt();
            if (vagas <= 0) {
                System.out.println("Número de vagas inválido. Tente novamente.");
            }
        } while (vagas <= 0);
        return vagas;
    }

    public int solicitarNumeroAndar() {
        int andar;
        do {
            System.out.print("Digite o número do andar do apartamento: ");
            andar = scanner.nextInt();
            if (andar <= 0) {
                System.out.println("Número do andar inválido. Tente novamente.");
            }
        } while (andar <= 0);
        return andar;
    }
    //e se for terreno ele pergunta o tipo de zona que vai ser instalado
    public String solicitarTipoZona() {
        System.out.print("Digite o tipo de zona do terreno (residencial, comercial): ");
        return scanner.next();
    }
}
