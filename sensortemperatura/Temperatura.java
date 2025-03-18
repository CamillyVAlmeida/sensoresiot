package sensortemperatura;

import java.util.Scanner;

public class Temperatura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { 
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Informar temperatura");
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
                System.out.print("\nDigite a temperatura (ex: -5°C, 10°C ou 25): ");
                String input = scanner.nextLine().trim();

                double temperatura;
                try {
                    temperatura = Double.parseDouble(input.replace("°C", "").trim());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite um número válido.");
                    continue;
                }

                String resultado = calculaTemperatura(temperatura);
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

    public static String calculaTemperatura(double temperatura) {
        if (temperatura < -10) {
            return "Frio extremo! Temperatura muito baixa.";
        } else if (temperatura >= -10 && temperatura <= 10) {
            return "Muito frio! Ligue o aquecedor.";
        } else if (temperatura > 10 && temperatura < 27) {
            return "Temperatura confortável.";
        } else if (temperatura >= 27 && temperatura <= 36) {
            return "Temperatura quente!";
        } else {
            return "Alta temperatura! Ligue o ar-condicionado ou ventilador.";
        }
    }
}
