// 17. Em uma competição de salto em distância cada atleta tem direito a cinco saltos. O resultado do atleta será determinado pela média dos cinco valores restantes. Você deve fazer um programa em Java que receba o nome e as cinco distâncias alcançadas pelo atleta em seus saltos e depois informe o nome, os saltos e a média dos saltos. O programa deve ser encerrado quando não for informado o nome do atleta. A saída do programa deve ser conforme o exemplo abaixo:
// Atleta: Rodrigo Curvêllo
// Primeiro Salto: 6.5 m
// Segundo Salto: 6.1 m
// Terceiro Salto: 6.2 m
// Quarto Salto: 5.4 m
// Quinto Salto: 5.3 m

// Resultado final:
// Atleta: Rodrigo Curvêllo
// Saltos: 6.5 - 6.1 - 6.2 - 5.4 - 5.3
// Média dos saltos: 5.9 m

import java.util.Scanner;

public class Questao17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nome do atleta (ou 'sair' para encerrar): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            double[] saltos = new double[5];
            for (int i = 0; i < 5; i++) {
                System.out.print("Distância do " + (i + 1) + "º salto: ");
                saltos[i] = scanner.nextDouble();
            }
            scanner.nextLine();

            double soma = 0;
            for (double salto : saltos) {
                soma += salto;
            }
            double media = soma / 5;

            System.out.println("Resultado final:");
            System.out.println("Atleta: " + nome);
            System.out.print("Saltos: ");
            for (double salto : saltos) {
                System.out.print(salto + " m");
            }
            System.out.println();
            System.out.println("Média dos saltos: " + media + " m");
        }

        scanner.close();
    }
}