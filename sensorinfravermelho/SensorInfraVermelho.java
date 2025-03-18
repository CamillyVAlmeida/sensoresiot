package sensorinfravermelho;

import java.util.Scanner;

public class SensorInfraVermelho {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Informar nível de infravermelho");
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
                
                System.out.print("\nDigite o nível de infravermelho: ");
                String inputInfraVermelho = scanner.nextLine().trim();

                double nivelInfra;
                try {
                    nivelInfra = Double.parseDouble(inputInfraVermelho);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite um número válido.");
                    continue;
                }

                String resultado = classificaInfraVermelho(nivelInfra);
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

    public static String classificaInfraVermelho(double nivelInfra) {
        if (nivelInfra < -5.03) {
            return "💡 Não acender luz.";
        } else {
            return "💡 Acender luz.";
        }
    }
}
