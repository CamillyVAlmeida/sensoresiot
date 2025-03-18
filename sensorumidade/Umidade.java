package sensorumidade;

import java.util.Scanner;

public class Umidade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Informar umidade do solo");
            System.out.println("2 - Sair do programa");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Escolha 1 ou 2.");
                continue;
            }

            if (opcao == 1) {
                System.out.print("\nDigite a umidade do solo (ex: 45% ou 45): ");
                String input = scanner.nextLine().trim();

                double umidade;
                try {
                    umidade = Double.parseDouble(input.replace("%", "").trim());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite um número válido.");
                    continue;
                }

                String resultado = classificaUmidade(umidade);
                System.out.println(resultado);

            } else if (opcao == 2) {
                System.out.println("Finalizando o programa...");
                break;
            } else {
                System.out.println("Opção inválida! Escolha 1 ou 2.");
            }
        }

        scanner.close();
    }

    public static String classificaUmidade(double umidade) {
        if (umidade < 20) {
            return "Solo muito seco! Irrigação urgente.";
        } else if (umidade >= 20 && umidade <= 40) {
            return "Solo seco. Recomendado irrigar.";
        } else if (umidade > 40 && umidade <= 70) {
            return "Umidade ideal para o solo";
        } else if (umidade > 70 && umidade <= 90) {
            return "Solo muito úmido. Verifique necessidade de drenagem.";
        } else {
            return "Encharcado! Risco de erosão e perda de nutrientes.";
        }
    }
}
